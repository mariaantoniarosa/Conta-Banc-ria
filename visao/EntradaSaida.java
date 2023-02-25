package visao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Conta;

public class EntradaSaida {
	 

	public static int solicitaOpcao() {
		String[] op = { "Conta", "Dados da Conta",  "Fazer uma movimenta��o", "Extrato Completo ", "Extrato de Dep�sitos",
				"Extrato de Saques", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(op);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o abaixo:", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPgm() {
		JOptionPane.showMessageDialog(null, "O programa ser� encerrado");
	}

	public static double validaMovi(String op) {

		double infoSaque = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do " + op));
		return infoSaque;
	}
	public static String solicitaNome() {
		String nome = JOptionPane.showInputDialog(null, "Insira seu nome");
		return nome;
	}

	public static int tipoConta() {
		int tipoConta = Integer.parseInt(JOptionPane
				.showInputDialog("Insira o tipo da conta\n" + "1 - Conta Corrente\n" + "2 - Conta Poupan�a"));
		while ((tipoConta != 1) && (tipoConta !=2 )) {
		tipoConta = Integer.parseInt(JOptionPane.showInputDialog("Tipo de conta Inv�lida, por favor digite novamente."));	
		}
		return tipoConta;
	}

	public static void exibeDadosDaConta(String infoDados ) {
		JOptionPane.showMessageDialog(null, infoDados, "Informa��es",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static String solicitaData() {
		String data = JOptionPane.showInputDialog("Insira a data de hoje");
		return data;
	}

	public static String solitaTipoMovimentacao() {
		String[] opTipo = { "Saque    ", "Dep�sito" };
		int tipoMovi = JOptionPane.showOptionDialog(null, "Informe qual o tipo de transi��o", "Movimenta��es",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opTipo, opTipo[1]);
		if (tipoMovi == 0) {

			return "Saque    ";
		} else {

			return "Dep�sito";
		}
	}

	public static void imprimeExtratoCompleto(String info, Conta conta) {
		
		JOptionPane.showMessageDialog(null, info     , "Informa��es",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void imprimeExtDep(String infoDep) {
		JOptionPane.showMessageDialog(null, infoDep);
	}

	public static void imprimeExtSaque(String infoSaque) {
		JOptionPane.showMessageDialog(null, infoSaque);
	}
}
