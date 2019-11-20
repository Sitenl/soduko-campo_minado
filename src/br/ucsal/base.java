package br.ucsal;

import java.util.Scanner;

public class base {

    public static boolean soduko = true; // Estabelece se o jogo é soduko. Por padrão é soduko. Deve ser alterado pelo menu.

    public static void main(String[] args) {
    }

    public static void loop() {
        menu();
        int[][] gradeOculta = gerarGradeOculta();
        Boolean[][] gradeVisualizacao = gerarGradeDeVisualizacao(gradeOculta);
        imprimirGrade(gradeOculta, gradeVisualizacao);
    }

    public static void menu(){

    }

    public static void imprimirGrade(int[][] gradeOculta, Boolean[][] gradeVisualizacao) {
        for(int li = 0; li < gradeOculta.length; li ++) {
            System.out.print(li + " -");
            for(int co = 0; co < gradeOculta[li].length; co ++) {
                System.out.print(" ");
                int celula = gradeOculta[li][co];
                if (gradeVisualizacao[li][co]) {
                    if (soduko) {
                        System.out.print(celula);
                    }
                    else {
                        if (celula == 0) {
                            System.out.print("\u25A1"); // Mostra um celula vazia □
                        }
                        else if (celula == 8) {
                            System.out.print("\u2691"); // Mostra uma bandeira ⚑
                        }
                        else if (celula == 9) {
                            System.out.print("\uD83D\uDCA3"); // Mostra uma bomba 💣
                        }
                        else {
                            System.out.print(celula); // Mostra o numero
                        }
                    }
                }
                else {
                    if (soduko) {
                        System.out.print(" ");
                    }
                    else {
                        System.out.print("\u25A0"); // ■
                    }
                }
            }
            System.out.println("\n");
        }
    }

    public static int[][] gerarGradeOculta() {
        int[][] grade = new int[0][0];
        if (soduko) {
            grade = new int[9][9];
            // Lógica do Soduko
        }
        else {
            grade = new int[10][5];
            // Lógica do Campo Minado
        }
        return grade;
    }

    public static Boolean[][] gerarGradeDeVisualizacao(int[][] gradeOculta) {
        Boolean[][] grade = new Boolean[gradeOculta.length][gradeOculta[1].length];
        return grade;
    }
//    public static void integarirGrade(int[][] gradeOculta, boolean[][] gradeVisualizacao) {
//        Scanner ent = new Scanner(System.in);
//        String comando = ent.nextLine();
//        if (comando.substring())
//            ent.close();
//    }
}
