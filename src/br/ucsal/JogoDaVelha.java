package br.ucsal;

import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {
	public static void main(String[] args) {

		inicio();
	}

	public static void inicio() {

		// imprimir(coordenadas(tabuleiro()));
		System.out.println("INSTRUÇÕES: Para avançar digite A+Coordenada e para fincar Bandeira degite B+coordenada."
				+ "\n" + "Exemplo: AP1(avançar na coordenada P1), BK12(Fincar bandeira no coordenada K12)");
		imprimir(tela(coordenadas(tabuleiro())));
		gameplayAvancada(tela(coordenadas(tabuleiro())), coordenadas(tabuleiro()));

	}

	public static String[][] tabuleiro() {
		String[][] tabuleiro = new String[18][18];
		for (int li = 0; li < tabuleiro.length; li++) {
			for (int co = 0; co < tabuleiro[li].length; co++) {
				tabuleiro[li][co] = "-";
			}
		}
		String mina = " * ";
		Random rd = new Random();
		int li = rd.nextInt(16) + 1;
		int co = rd.nextInt(16) + 1;
		tabuleiro[li][co] = mina;
		for (int i = 0; i < 39; i++) {
			while (tabuleiro[li][co] == mina) {
				li = rd.nextInt(16) + 1;
				co = rd.nextInt(16) + 1;
			}
			tabuleiro[li][co] = mina;
		}
		for (li = 1; li < tabuleiro.length - 1; li++) {
			for (co = 1; co < tabuleiro[li].length - 1; co++) {
				if (tabuleiro[li][co] != mina) {
					int num = 0;

					if (tabuleiro[li - 1][co] == mina) {
						num++;
					}
					if (tabuleiro[li + 1][co] == mina) {
						num++;
					}
					if (tabuleiro[li - 1][co - 1] == mina) {
						num++;
					}
					if (tabuleiro[li][co - 1] == mina) {
						num++;
					}
					if (tabuleiro[li + 1][co - 1] == mina) {
						num++;
					}
					if (tabuleiro[li - 1][co + 1] == mina) {
						num++;
					}
					if (tabuleiro[li][co + 1] == mina) {
						num++;
					}
					if (tabuleiro[li + 1][co + 1] == mina) {
						num++;
					}
					if (num == 0) {
						tabuleiro[li][co] = " - ";
					} else {
						tabuleiro[li][co] = " " + Integer.toString(num) + " ";
					}

				}

			}
		}

		return tabuleiro;

	}

	public static String[][] coordenadas(String[][] bid) {
		bid[0][0] = " / ";
		int num = 0, li = 0, co = 0;
		for (num = 1, li = 0, co = 1; li < 1 && co < bid[1].length - 1; co++, num++) {
			if (num < 10) {
				bid[li][co] = " " + Integer.toString(num) + " ";
			} else {
				bid[li][co] = " " + Integer.toString(num);
			}
		}
		for (num = 1, li = 1, co = 0; co < 1 && li < bid.length - 1; li++, num++) {
			switch (num) {

			case 1:
				bid[li][co] = " A ";
				break;

			case 2:
				bid[li][co] = " B ";
				break;

			case 3:
				bid[li][co] = " C ";
				break;

			case 4:
				bid[li][co] = " D ";
				break;

			case 5:
				bid[li][co] = " E ";
				break;

			case 6:
				bid[li][co] = " F ";
				break;

			case 7:
				bid[li][co] = " G ";
				break;

			case 8:
				bid[li][co] = " H ";
				break;

			case 9:
				bid[li][co] = " I ";
				break;

			case 10:
				bid[li][co] = " J ";
				break;

			case 11:
				bid[li][co] = " K ";
				break;

			case 12:
				bid[li][co] = " L ";
				break;

			case 13:
				bid[li][co] = " M ";
				break;

			case 14:
				bid[li][co] = " N ";
				break;

			case 15:
				bid[li][co] = " O ";
				break;

			case 16:
				bid[li][co] = " P ";
				break;

			}

		}

		return bid;
	}

	public static String[][] tela(String[][] tabu) {
		String[][] tela = new String[17][17];
		for (int li = 0; li < tela.length; li++) {
			for (int co = 0; co < tela[li].length; co++) {
				tela[li][co] = tabu[li][co];
			}
		}
		for (int li = 1; li < tela.length; li++) {
			for (int co = 1; co < tela[li].length; co++) {
				tela[li][co] = " \u25A0 ";
			}
		}
		return tela;
	}

	public static void imprimir(String[][] ar) {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		for (int li = 0; li < ar.length; li++) {
			System.out.print("| ");
			for (int co = 0; co < ar[li].length; co++) {
				System.out.print(ar[li][co] + " | ");
			}
			System.out.println();
			System.out.println(
					"-------------------------------------------------------------------------------------------------------");
		}
		System.out.println();
	}

	public static String[][] gameplayAvancada(String[][] fon, String[][] lul) {
		String mine = " * ";
		String[] armazenadorDeJogada = new String[4999];
		int i = 0, contwin = 0;
		int li = 0, co = 0, verif2 = 0;
		boolean repetida = false, verif = true, mina = false, ganhou = false;
		Scanner ent = new Scanner(System.in);
		String[][] gmp = new String[fon.length][fon[0].length];
		for (li = 0; li < fon.length; li++) {
			for (co = 0; co < fon[li].length; co++) {
				gmp[li][co] = fon[li][co];
			}
		}
		while (mina == false && ganhou == false) {
			repetida = false;
			System.out.println("Faça sua jogada:");
			String jogada = ent.nextLine();
			jogada = jogada.toUpperCase();
			System.out.println(jogada);
			armazenadorDeJogada[i] = jogada;
			for (int t = 0; t < i; t++) {
				if (armazenadorDeJogada[t].equals(jogada)) {
					repetida = true;
				}
			}
			i++;

			if (repetida == false) {

				if (jogada.length() == 3 || (jogada.length() == 4 && jogada.substring(2, 3).equals("1"))) {

					if (jogada.substring(0, 1).equals("A") || jogada.substring(0, 1).equals("B")) {
						switch (jogada.substring(1, 2)) {

						case "A":
							li = 1;
							break;

						case "B":
							li = 2;
							break;

						case "C":
							li = 3;
							break;

						case "D":
							li = 4;
							break;

						case "E":
							li = 5;
							break;

						case "F":
							li = 6;
							break;

						case "G":
							li = 7;
							break;

						case "H":
							li = 8;
							break;

						case "I":
							li = 9;
							break;

						case "J":
							li = 10;
							break;

						case "K":
							li = 11;
							break;

						case "L":
							li = 12;
							break;

						case "M":
							li = 13;
							break;

						case "N":
							li = 14;
							break;

						case "O":
							li = 15;
							break;

						case "P":
							li = 16;
							break;

						default:
							verif = false;
							break;
						}
						if (verif == true) {
							verif2 = Integer.parseInt(jogada.substring(2, jogada.length()));
							if (verif2 > 0 && verif2 < 17) {
								co = verif2;
								if (jogada.substring(0, 1).equals("A")) {
									gmp[li][co] = lul[li][co];

									if (gmp[li][co] == mine) {
										mina = true;
									} else {
										contwin++;
										if(li>1 && li < gmp.length-1 && co>1 && co<gmp[0].length-1) {
											if(lul[li+1][co] != mine) {
												gmp[li+1][co]= lul[li+1][co];
												contwin++;
											}
											if(lul[li-1][co] != mine) {
												gmp[li-1][co]= lul[li-1][co];
												contwin++;
											}
											if(lul[li][co+1] != mine) {
												gmp[li][co+1]= lul[li][co+1];
												contwin++;
											}
											if(lul[li][co-1] != mine) {
												gmp[li][co-1]= lul[li][co-1];
												contwin++;
											}
										}
										if (contwin == 216) {
											ganhou = true;
										}
									}
								} else {
									gmp[li][co] = "  \u2691  ";
								}
								imprimir(gmp);
							} else {
								System.out.println("Jogada inválida irmão");
							}

						} else {
							System.out.println("Jogada inválida");
						}

					} else {
						System.out.println("Jogade inválida");
					}
				} else {
					System.out.println("Jogada inválida");
				}
				/*
				 * System.out.println( jogada.length() + " " + jogada.substring(0, 1) + " " +
				 * jogada.substring(1, 2) + " " + verif2); System.out.println(jogada); for (int
				 * k = 0; k < armazenadorDeJogada.length; k++) {
				 * System.out.print(armazenadorDeJogada[k] + " "); }
				 */
				System.out.println();
			} else {
				System.out.println("Jogada repetida");
			}

		}
		ent.close();
		if (mina = true) {
			Random rd = new Random();
			int frases = rd.nextInt(5);
			switch (frases) {
			case 1:
				System.out.println("Você foi EXPRUDIDO '-' ");
				break;
			case 2:
				System.out.println("KABUUUM");
				break;
			case 3:
				System.out.println("Voou pelos ares!");
				break;
			case 4:
				System.out.println("Igual celular no microondas");
				break;
			case 5:
				System.out.println("Ops, parece que você pisou numa mina");
				break;
			default:
				System.out.println("Faleceu");
				break;
			}
		} else {
			System.out.println("PARABÉNS MEU FILHO, VOCÊ É UM GUERREIRO!");
		}
		return gmp;
	}
}

// |
