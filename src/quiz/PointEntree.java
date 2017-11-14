/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.Scanner;

/**
 *
 * @author Formation
 */
public class PointEntree {

    public void menuPrincipal() {

        Quiz q1 = new Quiz();
        boolean quitter = false;
        while (quitter == false) {

            System.out.println("MENU PRINCIPAL");
            System.out.println("----------------");
            System.out.println("1. Creer  Quiz");
            System.out.println("2. Jouer au Quiz");
            System.out.println("3. Quitter");
            System.out.print("votre choix: ");

            // Saisie Clavier
            Scanner scanner = new Scanner(System.in);
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    q1.saisieQuiz();
                    break;
                case "2":
                    q1.jouerQuiz();
                    break;
                case "3":
                    quitter = true;
                    break;
                default:
                    System.out.println("Choix invalide, Sélectionner à nouveau !!!");
            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PointEntree pe = new PointEntree();
        
        pe.menuPrincipal();
    }

    
}
