package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Conta {

	private String titularDaConta;
	private int tipo;
	private double saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String gerarDadosDaConta(String cont) {

		String info = "Titular: " + getTitularDaConta() + "\n Tipo: " + getTipo() + "- " + cont + "\n " + "Saldo: "
				+ getSaldo();
		return info;
	}

	public String validaTipoConta(int tipoConta) {
		String cont;

		if (tipoConta == 1) {
			cont = "Conta Corrente\n ";
		} else {
			cont = "Conta Poupança\n ";
		}
		return cont;
	}



	public double gerarSaldo(double valor, String op) {

		if (op.equals("Saque    ")) {
			return saldo = saldo - valor;

		} else {
			return saldo = saldo + valor;
		}

	}

	public String gerarExtDeposito() {
		String infoDep = "";
	

			for (Movimentacao movimentacao : this.listaDeMovimentacao) {
				if (movimentacao.getTipoMovi().equals("Depósito")) {
					infoDep += movimentacao.getTipoMovi() + "   " + movimentacao.getValor() + "     "
							+ movimentacao.getData() + "\n";
				}
			

		}
		return infoDep;
	}

	public String gerarExtSaque() {
		String infoSaque = "";
		
			for (Movimentacao movimentacao : this.listaDeMovimentacao) {
				if (movimentacao.getTipoMovi().equals("Saque    ")) {
					infoSaque += movimentacao.getTipoMovi() + "   " + movimentacao.getValor() + "     "
							+ movimentacao.getData() + "\n";
				
			}
		}
		return infoSaque;
	}

	public String gerarExtrato() {
		String info = "";

		
			for (Movimentacao movimentacao : this.listaDeMovimentacao) {

				info += movimentacao.getTipoMovi() + "    " + movimentacao.getValor() + "    " + movimentacao.getData()
						+ "    " + "\n";
			

		}
		return info;

	}

	public void gerarMovimentacao(Movimentacao movimentacao) {
		listaDeMovimentacao.add(movimentacao);
	}
}
