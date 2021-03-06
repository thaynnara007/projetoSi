package com.ufcg.si1.model;

import java.math.BigDecimal;

import exceptions.ObjetoInvalidoException;

public class Produto {

	private long id;

	private String nome;

	private BigDecimal preco;

	private String codigoBarra;

	private String fabricante;

	private String categoria;

	private State state;
	
	

	public Produto() {
		this.id = 0;
		this.preco = new BigDecimal(0);
	}

	public Produto(long id, String nome, String codigoBarra, String fabricante,
			String nomeCategoria) {
		this.id = id;
		this.nome = nome;
		this.preco = new BigDecimal(0);
		this.codigoBarra = codigoBarra;
		this.fabricante = fabricante;
		this.categoria = nomeCategoria;
		this.state = new Unavailable(); 
	}

	public String getNome() {
		return nome;
	}

	public void mudaNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public void mudaId(long codigo) {
		this.id = codigo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void mudaFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void mudaCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void updateProduto(Produto produto) {
		this.mudaNome(produto.getNome());
		this.setPreco(produto.getPreco());
		this.setCodigoBarra(produto.getCodigoBarra());
		this.mudaFabricante(produto.getFabricante());
		this.mudaCategoria(produto.getCategoria());
	}
		
	public void mudaSituacao(State state) throws ObjetoInvalidoException{
		
		if (state instanceof Available) {
			
			this.setState(new Available());
		}
		else if( state instanceof Unavailable) {
			
			this.setState(new Unavailable());;
		}
		else {
			
			throw new ObjetoInvalidoException("Estado invalido");
		}
		
	}
	public void setState(State novoState) {
		
		this.state = novoState;
	}

	public int getSituacao() throws ObjetoInvalidoException {
		return this.state.getState();
	}
	public State getState() {
		
		return this.state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
