package br.com.pedrodeveloper.springdataexamples.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(
		basePackages = {"br.com.pedrodeveloper.springdataexamples"}
)
public class JpaConfiguration {

	@Value("${db.driverClassName}")
	private String DRIVER_CLASS_NAME;
	@Value("${db.url}")
	private String URL;
	@Value("${db.username}")
	private String USER;
	@Value("${db.password}")
	private String PASSWORD;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;
	@Value("${hibernate.format_sql}")
	private String HIBERNATE_FORMAT_SQL;
	
	@Bean
	public DataSource dataSource() {
	    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(DRIVER_CLASS_NAME);
	    dataSource.setUrl(URL);
	    dataSource.setUsername(USER);
	    dataSource.setPassword(PASSWORD);
	    return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			Properties additionalProperties) {

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaProperties(additionalProperties);
		factoryBean.setPackagesToScan("br.com.pedrodeveloper.springdataexamples");

		return factoryBean;
	}

	@Bean
	public Properties additionalProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
		props.setProperty("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		props.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		props.setProperty("hibernate.format_sql", HIBERNATE_FORMAT_SQL);
		return props;
	}
}
