package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Conta;
import modelo.Movimentacao;
import visao.EntradaSaida;

public class Controladora {
	
	/*
	 * salvar na conta os dados do usu�rio
	 * criar op��o no menu para exibir dados da conta
	 * mudar nome da op��o do menu que faz as movimenta��es
	 * EntradaSaida.exibeDadosDaConta receber a conta como par�metro
	 * fazer else da movimenta��o, onde se n�o estourar limite deve fazer a movimenta��o e troca do saldo 
	 * colocar op��o 5 (sair) no switch como um case
	 * mosrar mensagem de que n�o foram feitas movimenta��es nos 3 extratos
	 */
 
	private Conta conta = null;

	String op;
	String data;
	double valor;
	String cont;

	public void exibeMenu() {
		int tipoConta = 0;
		
			int opcao = 0;
			boolean validConta = false;
			do {
			//Se clicar primeiro em sair, para que n�o apare�a a solicita��o de dados, 
			//fizemos essa valida��o para ja encerrar o programa. 
				opcao = EntradaSaida.solicitaOpcao();
				if (opcao == 6) { 
					EntradaSaida.exibeMsgEncerraPgm();
					System.exit(0);
				}
				//Validar se o cliente j� colocou os dados da conta como o nome e tipo da conta
			 if (validConta != true) { 
				while (opcao!= 0) { 
					JOptionPane.showMessageDialog(null, "Insira seus dados cadastrais.");
					opcao = EntradaSaida.solicitaOpcao();
					
					
				}
			}
		
				switch (opcao) {
				//caso 0 criamos nossa conta cadastrando os dados do usuario no objeto conta. 
			
				case 0:
					validConta = true;
					this.conta = new Conta();
					String titular = EntradaSaida.solicitaNome();
					tipoConta = EntradaSaida.tipoConta();
					conta.setTitularDaConta(titular);
					conta.setTipo(tipoConta);
					 conta.gerarDadosDaConta(cont);
					 cont = conta.validaTipoConta(tipoConta);
					
					break;

				case 1: 
				String infoDados = conta.gerarDadosDaConta(cont );
				EntradaSaida.exibeDadosDaConta(infoDados);
					break;
				case 2:
					
					//caso 1: criamos ent�o uma instacia para acessar os atributos da classe movimentacao, 
					//e atribuimos os valores solicitados e salvamos dentro do objeto. 
					
			 
					Movimentacao movimentacao = new Movimentacao();
					op = EntradaSaida.solitaTipoMovimentacao();
					data = EntradaSaida.solicitaData();
					valor = EntradaSaida.validaMovi(op);//fazer na EntradaSaida

					double valorSaldo = conta.gerarSaldo(valor, op);
				
					// System.out.print(valorSaldo);
					//J� validando se o saldo for menor que -1000 n�o h� mais limite de cr�dito para o usu�rio.
					if (valorSaldo <= -1000) {
						JOptionPane.showMessageDialog(null, "Voc� atingiu seu limite de cr�dito."+ "\n Voc� ser� redirecionado ao menu");
						valorSaldo = valorSaldo + valor;
						conta.setSaldo(valorSaldo); 
				
					
					}else { 
					movimentacao.setValor(valor);
					movimentacao.setTipo(tipoConta);
					movimentacao.setTipoMovi(op);
					movimentacao.setData(data);
					conta.gerarMovimentacao(movimentacao);
					conta.setSaldo(valorSaldo);
					}
					break;

				case 3:
					//Utilizando um for each da lista de movimenta��es, atribuimos a uma variavel (info) todos os dados 
					//pegando dos atributos do objeto 
					String info = conta.gerarExtrato();
					if (info == "") { 
						JOptionPane.showMessageDialog(null, "N�o h� movimenta��es para mostrar.");
					}else { 
					EntradaSaida.imprimeExtratoCompleto(info, conta);
					}
					break;

				case 4:
					//dentro deste m�todo fiz a mesma coisa mas desta vez selecionando somente as movimenta��es com o nome
					// """"deposito"""" pois foi o nome que nomeamos para o usuario escolher. 
					
					String infoDep = conta.gerarExtDeposito();
					if (infoDep == "" ) { 
						JOptionPane.showMessageDialog(null, "Voc� n�o executou nenhum dep�sito.");
					}else { 
					EntradaSaida.imprimeExtDep(infoDep);
					}
					break;

				case 5:
					// o mesmo para o caso 3, o que muda � que selecionei os dados de saques. 
					String infoSaque = conta.gerarExtSaque();
					if  (
							infoSaque == "")  { 
						JOptionPane.showMessageDialog(null, "Voc� n�o possui saques.");
					}else { 
					EntradaSaida.imprimeExtSaque(infoSaque);
					}
					break;
				case 6: 
					
						EntradaSaida.exibeMsgEncerraPgm();
						System.exit(0);
					
				
				}

			} while (opcao != 6);
		

		
	}
}