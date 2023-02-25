package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Conta;
import modelo.Movimentacao;
import visao.EntradaSaida;

public class Controladora {
	
	/*
	 * salvar na conta os dados do usuário
	 * criar opção no menu para exibir dados da conta
	 * mudar nome da opção do menu que faz as movimentações
	 * EntradaSaida.exibeDadosDaConta receber a conta como parâmetro
	 * fazer else da movimentação, onde se não estourar limite deve fazer a movimentação e troca do saldo 
	 * colocar opção 5 (sair) no switch como um case
	 * mosrar mensagem de que não foram feitas movimentações nos 3 extratos
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
			//Se clicar primeiro em sair, para que não apareça a solicitação de dados, 
			//fizemos essa validação para ja encerrar o programa. 
				opcao = EntradaSaida.solicitaOpcao();
				if (opcao == 6) { 
					EntradaSaida.exibeMsgEncerraPgm();
					System.exit(0);
				}
				//Validar se o cliente já colocou os dados da conta como o nome e tipo da conta
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
					
					//caso 1: criamos então uma instacia para acessar os atributos da classe movimentacao, 
					//e atribuimos os valores solicitados e salvamos dentro do objeto. 
					
			 
					Movimentacao movimentacao = new Movimentacao();
					op = EntradaSaida.solitaTipoMovimentacao();
					data = EntradaSaida.solicitaData();
					valor = EntradaSaida.validaMovi(op);//fazer na EntradaSaida

					double valorSaldo = conta.gerarSaldo(valor, op);
				
					// System.out.print(valorSaldo);
					//Já validando se o saldo for menor que -1000 não há mais limite de crédito para o usuário.
					if (valorSaldo <= -1000) {
						JOptionPane.showMessageDialog(null, "Você atingiu seu limite de crédito."+ "\n Você será redirecionado ao menu");
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
					//Utilizando um for each da lista de movimentações, atribuimos a uma variavel (info) todos os dados 
					//pegando dos atributos do objeto 
					String info = conta.gerarExtrato();
					if (info == "") { 
						JOptionPane.showMessageDialog(null, "Não há movimentações para mostrar.");
					}else { 
					EntradaSaida.imprimeExtratoCompleto(info, conta);
					}
					break;

				case 4:
					//dentro deste método fiz a mesma coisa mas desta vez selecionando somente as movimentações com o nome
					// """"deposito"""" pois foi o nome que nomeamos para o usuario escolher. 
					
					String infoDep = conta.gerarExtDeposito();
					if (infoDep == "" ) { 
						JOptionPane.showMessageDialog(null, "Você não executou nenhum depósito.");
					}else { 
					EntradaSaida.imprimeExtDep(infoDep);
					}
					break;

				case 5:
					// o mesmo para o caso 3, o que muda é que selecionei os dados de saques. 
					String infoSaque = conta.gerarExtSaque();
					if  (
							infoSaque == "")  { 
						JOptionPane.showMessageDialog(null, "Você não possui saques.");
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