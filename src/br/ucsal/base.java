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
//                        else if (celula == 8) {
//                            System.out.print("\u2691"); // Mostra uma bandeira ⚑
//                        }
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

    public static void perdeu(int[][] gradeOculta, Boolean[][] gradeVisualizacao) {
        System.out.println("Perdeu!");
        for (int li = 0; li < gradeVisualizacao.length; li ++) {
            for (int co = 0; co < gradeVisualizacao[li].length; co ++) {
                gradeVisualizacao[li][co] = true;
            }
        }
        imprimirGrade(gradeOculta, gradeVisualizacao);
    }

    public static boolean verificarAcerto (int[] pos, int vlr) {
        if (vlr == gradeOculta[pos[0]][pos[1]]) {
            gradeVisualizacao[pos[0]][pos[1]] = true;
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean interagirGrade() {
        Scanner ent = new Scanner(System.in);
        String comando = ent.nextLine(); // Comando deve ser um string no seguinte formato "C 0, 0 0"
        boolean acerto = true;
        if (comando.length() == 8) {
            char escolha = comando.charAt(0);
            int[] pos = new int[2];
            pos[0] = Integer.parseInt(comando.substring(2,3));
            pos[1] = Integer.parseInt(comando.substring(5,6));
            int vlr = Integer.parseInt(comando.substring(7,8));
            if (escolha == 'I') { // I é o comando para inserir uma bandeira, no campo minado, ou um integer, no soduko.
                if (soduko) {
                    return verificarAcerto(pos, vlr);
                }
//                else {
//                    acerto = verificarAcerto(pos, vlr);
//                }

            } else if (escolha == 'C') { // C é o comando para "clicar" no campo minado, vai resultar em erro se for soduko.
                if (soduko) {
                    System.out.println("Comando inválido para o Soduko.");
                    return acerto;
                }
                else {
                    return verificarAcerto(pos, vlr);
                }
            } else {
                System.out.println("Comando não reconhecido. Tente 'M', 'I' ou ...");
                return acerto;
            }
        }
        else {
            System.out.println("Comando malformatado. Tente novamente.");
            return acerto;
        }
        ent.close();
        return acerto;
    }
}
