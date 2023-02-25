package visao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Conta;

public class EntradaSaida {
	 

	public static int solicitaOpcao() {
		String[] op = { "Conta", "Dados da Conta",  "Fazer uma movimentação", "Extrato Completo ", "Extrato de Depósitos",
				"Extrato de Saques", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(op);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção abaixo:", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPgm() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado");
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
				.showInputDialog("Insira o tipo da conta\n" + "1 - Conta Corrente\n" + "2 - Conta Poupança"));
		while ((tipoConta != 1) && (tipoConta !=2 )) {
		tipoConta = Integer.parseInt(JOptionPane.showInputDialog("Tipo de conta Inválida, por favor digite novamente."));	
		}
		return tipoConta;
	}

	public static void exibeDadosDaConta(String infoDados ) {
		JOptionPane.showMessageDialog(null, infoDados, "Informações",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static String solicitaData() {
		String data = JOptionPane.showInputDialog("Insira a data de hoje");
		return data;
	}

	public static String solitaTipoMovimentacao() {
		String[] opTipo = { "Saque    ", "Depósito" };
		int tipoMovi = JOptionPane.showOptionDialog(null, "Informe qual o tipo de transição", "Movimentações",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opTipo, opTipo[1]);
		if (tipoMovi == 0) {

			return "Saque    ";
		} else {

			return "Depósito";
		}
	}

	public static void imprimeExtratoCompleto(String info, Conta conta) {
		
		JOptionPane.showMessageDialog(null, info     , "Informações",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void imprimeExtDep(String infoDep) {
		JOptionPane.showMessageDialog(null, infoDep);
	}

	public static void imprimeExtSaque(String infoSaque) {
		JOptionPane.showMessageDialog(null, infoSaque);
	}
}
