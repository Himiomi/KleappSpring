package br.com.pedrodeveloper.springdataexamples.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VendaItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	private LocalDateTime cadastro = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	private BigDecimal valor;
	
	private BigDecimal qtde;
	
	/** Recalcula o valor total do item toda vez que houver uma alteração 
	 * no produto ou na qtde. */
	private void calculaValorTotal() {
		if (this.qtde == null || this.produto == null || this.produto.getValor() == null) {
			//Se nao tem qtde ou valor entao valor e nulo
			this.valor = null;
			return;
		}
		
		this.valor = this.produto.getValor()
				.multiply(this.qtde)
				.setScale(2, RoundingMode.DOWN);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDateTime cadastro) {
		this.cadastro = cadastro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		calculaValorTotal();
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public BigDecimal getQtde() {
		return qtde;
	}

	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
		calculaValorTotal();
	}

	public BigDecimal getValor() {
		return valor;
	}

}
