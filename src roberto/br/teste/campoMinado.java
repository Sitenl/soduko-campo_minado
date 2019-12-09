package br.teste;
import java.util.Random;
import java.util.Scanner;

public class campoMinado {

	static String[][] minas = new String [16][16];
	static String[][] tabela = new String [16][16];
	static Random sc = new Random();
	static int linha, coluna;
	static Scanner ent = new Scanner(System.in);
	static String [][] temp = campoMinas();



	public static void main (String[] args) {

		inicio();
	}

	//CAMPO MINADO
	public static void CampoMinado() {
		imprimir(campoTabela(temp));
		System.out.println();
		campoMinas();

		Jogo();
	}

	//MENU
	public static void inicio () {
		String nome [] = new String [1];
		String matricula [] = new String [1];
		int opcao;

		System.out.println("Bem vido, aos jogos de raciocínio! Para darmos início"
				+ " digite seu nome e matrícula: "
				+ "\nDigite seu nome: ");

		//cadastro do nome e matrícula
		for (int i = 0; i < matricula.length; i++) {
			nome[i] = ent.nextLine();
			System.out.println("Digite sua matrícula: ");
			matricula[i] = ent.nextLine();

			//menu seleção dos jogos
			System.out.println("Qual jogo deseja jogar?\nDigite 1 para Sudoku ou 2 para Campo Minado:"
					+ "\n1) Sudoku\n2) Campo Minado (Logic Problem)");
			opcao = ent.nextInt() ;

			switch (opcao) {	
			//case 1: Sudoku(); break;
			case 2: CampoMinado(); break;
			default: System.out.println("Opção inválida!!"); break;
			}
		}



	}


	//JOGO
	public static void Jogo () {

		String teste;

		linha=0;
		coluna=0;

		//do {
		for (int vidas = 1; vidas==1; ) {
			int count =0;

			System.out.println("Escolha a linha [0-16]: ");
			int linha = ent.nextInt();
			System.out.println("Escolha a coluna [0-16]: ");
			int coluna = ent.nextInt();


			if (minas [linha][coluna]== "1") {
				imp(minas);
				vidas = 0;
				System.out.println("\n Você perdeu!");
			}else {

				vidas = 1;
				teste = minas[linha][coluna];
				System.out.println(teste + " bombas próximas");
			}

			if(minas[linha][coluna]=="_")
				count++;
			if(count == 241) {
				vidas=0;
				System.out.print("Você ganhou!");
			}
		}

	}

	// TABELA E MINAS 
	public static String [][] campoMinas(){

		/*minas[1][1] = "1";
		minas[1][2] = "1";
		minas[1][4] = "1";
		minas[1][1] = "1";
		minas[1][3] = "1";
		minas[1][4] = "1";
		minas[1][5] = "1";
		minas[2][1] = "1";
		minas[2][2] = "1";
		minas[2][7] = "1";
		minas[3][1] = "1";
		minas[3][4] = "1";
		minas[3][8] = "1";
		minas[4][1] = "1";
		minas[4][3] = "1";
		minas[4][5] = "1";
		minas[4][8] = "1";
		minas[5][1] = "1";
		minas[5][4] = "1";
		minas[5][8] = "1";
		minas[6][1] = "1";
		minas[6][6] = "1";
		minas[6][7] = "1";
		minas[7][3] = "1";
		minas[7][4] = "1";
		minas[7][5] = "1";*/
		minas[7][8] = "1";
		//minas[8][4] = "1";
		minas[8][7] = "1";
		minas[8][8] = "1";	
		for (int i = 1; i < minas.length-1; i++) {
			for (int j = 1; j < minas[i].length-1; j++) {
				if (minas[i][j]!="1") {
					int num=0;

					if(minas[i-1][j]=="1") {
						num++;
					}
					if(tabela[i+1][j]=="1") {
						num++;
					}
					if(tabela[i-1][j-1]=="1") {
						num++;
					}
					if(tabela[i][j-1]=="1") {
						num++;
					}
					if(tabela[i+1][j-1]=="1") {
						num++;
					}
					if(tabela[i-1][j+1]=="1") {
						num++;
					}
					if(tabela[i][j+1]=="1") {
						num++;
					}
					if(tabela[i+1][j+1]=="1") {
						num++;
					}
					if (num == 0) { 
						tabela[i][j] = " _ ";
					}else{
						tabela[i][j] = " "+Integer.toString(num)+" ";	
					}

				}

			}
		}


		return minas;
	}


	public static String[][] campoTabela(String[][] temp) {
		for (int i = 0; i < tabela.length; i++) {
			for (int j = 0; j < tabela[i].length; j++) {

				tabela = campoMinas();
				if (tabela[i][j]!= "1") {

					tabela[i][j] = " _ ";
				}

			}

		}

		return tabela;


	}


	//IMPRESSÕES

	private static void imp (String [][] ar) {


		for (int li = 0;li < ar.length; li++) {
			for (int co = 0; co < ar[li].length; co++) {

				if (ar[li][co]== "1")
					System.out.print(" * " );

				else {
					System.out.print(ar[li][co]);
					//System.out.print(" _ ");
				}


			}
			System.out.println();

		}
	}


	static void imprimir(String[][] tabuleiro){

		for(int li = 15 ; li > 0 ; li--){


			for(int co = 1 ; co < 16; co++){
				tabuleiro[li][co] = " _ ";
				System.out.print(""+ tabuleiro[li][co]);
			}

			System.out.println();
		}


	}




}