
import java.util.Scanner;

public class JogoVelha {
	static String[][] tabuleiro = new String[3][3];
	static int coluna;
	static int linha;
	static String jogador1;
	static String jogador2;
	static Scanner sc = new Scanner(System.in);
	static int Win1 = 0;
	static int Win2 = 0;

	public static void main(String[] args) {
		String continuar;

		do {
			System.out.println("Bem vindo");
			System.out.println("Escolha entre X ou O");
			jogador1 = sc.next();

			// Definindo os jogadores
			if (jogador1.equals("X")) {
				jogador2 = "O";
			} else {
				jogador2 = "X";
			}
			// Atribuindo valores as variaveis
			tabuleiro[0][0] = " ";
			tabuleiro[0][1] = " ";
			tabuleiro[0][2] = " ";
			tabuleiro[1][0] = " ";
			tabuleiro[1][1] = " ";
			tabuleiro[1][2] = " ";
			tabuleiro[2][0] = " ";
			tabuleiro[2][1] = " ";
			tabuleiro[2][2] = " ";

			boolean inverte = true;

			// Ordem do jogo
			for (int i = 1; i <= 9; i++) {
				if (inverte) {
					if (Jogador(jogador1)) {
						Win1++;
						break;
					}
				} else {
					if(Jogador(jogador2)) {
						Win2++;
						break;
					}					
				}				
				inverte = !inverte;
			}
			

			System.out.println("Deseja Continuar? s/n");
			continuar = sc.next();	
			
		} while (continuar.equals("s"));
		
		System.out.println("O placa da partida é:");
		System.out.println("Jogador 1: " + Win1);
		System.out.println("Jogador 2: " + Win2);

	}// Fim do metedo Main

	public static boolean Jogador(String player) {

		System.out.println("-----------");
		System.out.println("Jogador " + player);

		ConfereColunas();
		ConfereLinhas();

		// --------Marca a posição no tabuleiro------------

		if(tabuleiro[linha][coluna].equals(" ")) {
			tabuleiro[linha][coluna] = player;
		} else 
			System.err.println("Opção já utilizada");
			
		
//		if (coluna == 0) {
//			switch (linha) {
//			case 0:
//				tabuleiro[0][0] = player;
//				break;
//			case 1:
//				tabuleiro[1][0] = player;
//				break;
//			default:
//				tabuleiro[2][0] = player;
//				break;
//			}
//		}
//		if (coluna == 1) {
//			switch (linha) {
//			case 0:
//				tabuleiro[0][1] = player;
//				break;
//			case 1:
//				tabuleiro[1][1] = player;
//				break;
//			default:
//				tabuleiro[2][1] = player;
//				break;
//			}
//		}
//		if (coluna == 2) {
//			switch (linha) {
//			case 0:
//				tabuleiro[0][2] = player;
//				break;
//			case 1:
//				tabuleiro[1][2] = player;
//				break;
//			default:
//				tabuleiro[2][2] = player;
//				break;
//			}
//		}

		Tabuleiro();
		// Metodo que verifica se o jogador 1 vence em algum momento	
		return Vencer(player);

	}

	public static void Tabuleiro() {
		System.out.println("-----------");
		System.out.printf("%s|", tabuleiro[0][0]);
		System.out.printf("%s|", tabuleiro[0][1]);
		System.out.printf("%s", tabuleiro[0][2]);
		System.out.println();
		System.out.printf("%s|", tabuleiro[1][0]);
		System.out.printf("%s|", tabuleiro[1][1]);
		System.out.printf("%s", tabuleiro[1][2]);
		System.out.println();
		System.out.printf("%s|", tabuleiro[2][0]);
		System.out.printf("%s|", tabuleiro[2][1]);
		System.out.printf("%s", tabuleiro[2][2]);
		System.out.println();
	}

	public static void ConfereLinhas() {
		// ------------Confere a Linha--------------------
		do {
			System.out.println("Informe um numero para a linha de 0 a 2");
			linha = sc.nextInt();

			if (linha < 0 || linha > 2) {
				System.err.println("Opação invalida");
			}
		} while (linha < 0 || linha > 2);
	}

	public static void ConfereColunas() {
		// --------Confere a Coluna---------------------------
		do {
			System.out.println("Informe um numero para a coluna de 0 a 2");
			coluna = sc.nextInt();

			if (coluna < 0 || coluna > 2) {
				System.err.println("OpÃ§Ã£o invalida");
			}
		} while (coluna < 0 || coluna > 2);
	}

	public static boolean Vencer(String jogador) {
		// vencer em horizontal
		if (tabuleiro[0][0].equals(jogador) && tabuleiro[0][1].equals(jogador) && tabuleiro[0][2].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
		
			return true;
		}
		if (tabuleiro[1][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[1][2].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		}
		if (tabuleiro[2][0].equals(jogador) && tabuleiro[2][1].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		}
		// vencer na vertical
		if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][0].equals(jogador) && tabuleiro[2][0].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		}
		if (tabuleiro[0][1].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][1].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		}
		if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][2].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		}
		// vencer em diagonal
		if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		}
		if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(jogador)) {
			System.err.println("Parabens jogador " + jogador);
			return true;
		} else {
			return false;
		}

	}

}
