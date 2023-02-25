package modelo;

public class Movimentacao {
	private int tipo;
	private double valor;
	private String data;
	private String tipoMovi;
	
	public String getTipoMovi() { 
		return tipoMovi;
	}
	public void setTipoMovi(String tipoMovi) { 
		this.tipoMovi = tipoMovi;
	}
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipoConta) {
		this.tipo = tipoConta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	

}
