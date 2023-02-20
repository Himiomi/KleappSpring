package br.com.pedrodeveloper.springdataexamples.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.github.javafaker.Faker;

public class MockGenerator {

	public static void main(String[] args) {
		//Qtde de registros a adicionar
		Integer max = 200;
		
		Faker faker = new Faker(new Locale("pt-BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		System.out.println("INSERT INTO cliente (nome, cadastro) VALUES ");
		
		for (int i=1; i<=max; i++) {
			System.out.print("('" + faker.name().fullName() + "','" + sdf.format(faker.date().birthday(0, 10)) + "')");
			
			if (i == max) {
				System.out.println(";");
			} else {
				System.out.println(",");
			}
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");
		

		System.out.println("INSERT INTO produto (descricao, valor, ativo, cadastro) VALUES ");

		for (int i=1; i<=max; i++) {
			System.out.print("('" + faker.commerce().productName() + "',"
								+ "'" + faker.commerce().price().replace(".", "").replace(",", ".") + "',"
								+ faker.bool().bool() + ","
								+ "'" + sdf.format(faker.date().birthday(0, 10)) + "')");
			
			if (i == max) {
				System.out.println(";");
			} else {
				System.out.println(",");
			}
		}
	}
	
}
