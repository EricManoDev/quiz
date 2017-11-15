/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Formation
 */
public class Quiz {

    private String titreQuiz;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz() {
    }

    public Quiz(String titreQuiz) {
        this.titreQuiz = titreQuiz;
    }

    public String getTitreQuiz() {
        return titreQuiz;
    }

    public void setTitreQuiz(String titreQuiz) {
        this.titreQuiz = titreQuiz;
    }

    //Saisie Question////
    public void saisieQuiz() {

        Scanner scanner = new Scanner(System.in);
//        Question nouveauQuiz = new Question();

        System.out.print("Saisissez votre Titre du Quiz: ");// Saisie titre Quiz
        this.setTitreQuiz(scanner.nextLine());
        saisieQuestions();
        System.out.println("*** LISTE QUESTIONS : " + this);
    }

    public void saisieQuestion() {
        Scanner scanner = new Scanner(System.in);//création questionActuelle
        Question nouvelleQuestion = new Question();
        System.out.print("Saisissez votre question:  ");// Saisie questionActuelle
        nouvelleQuestion.setTitreQuestion(scanner.nextLine());
        this.questions.add(nouvelleQuestion);

        //Saisie réponse 1//////
        System.out.print("Réponse 1: ");
        String rep1 = scanner.nextLine();
        nouvelleQuestion.setReponse1(rep1);

        //Saisie réponse 2//////
        System.out.print("Réponse 2: ");
        String rep2 = scanner.nextLine();
        nouvelleQuestion.setReponse2(rep2);

        //Saisie réponse 3//////
        System.out.print("Réponse 3: ");
        String rep3 = scanner.nextLine();
        nouvelleQuestion.setReponse3(rep3);

        // Saisie réponse 4//////
        System.out.print("Réponse 4: ");
        String rep4 = scanner.nextLine();
        nouvelleQuestion.setReponse4(rep4);

        // Affiche choix de la bonne réponse////
        int choix = 0;
        do {
            System.out.print("Sélectionner la bonne réponse (1 à 4): ");
//            System.out.println("1" + reponse1.getReponse1());
//            System.out.println("2" + reponse2.getReponse2());
//            System.out.println("3" + reponse3.getReponse3());
//            System.out.println("4" + reponse4.getReponse4());

            // Sasiie bonne réponse
            choix = Integer.valueOf(scanner.nextLine());
        } while (choix < 1 || choix > 4);
        nouvelleQuestion.setNumReponseCorrecte(choix);
        
        scanner.reset();
    }

    public void saisieQuestions() {

        boolean quitter = false;
        while (quitter == false) {

            // Saisit question et l'ajoute à la liste
            this.saisieQuestion();
            
            // Demander nouvelle questionActuelle?
            System.out.println("1. Saisie nouvelle question pour le Quiz: " + this.titreQuiz);
            System.out.println("2. Quitter la saisie du Quiz ");
            System.out.print("Votre réponse: ");

            Scanner scanner = new Scanner(System.in);//création questionActuelle
            scanner.reset();
            String choix = scanner.nextLine();
            switch (choix) {

                case "1":
                    saisieQuestions();
                    break;
                case "2":
                    quitter = true;
                    break;
                default:
                    System.out.println("Sélectionner à nouveau");
                    break;
            }
        }
    }

    public void jouerQuiz() {

        // Saisie nom
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nouveau Joueur - Saisissez votre nom: ");
        String nouveauNom = scanner.nextLine();

        // initialiser Score à Zéro
        int score = 0;

        // Itere sur affichage, saisie et recalcul score pour chaque questionActuelle
        for (Question questionActuelle : questions) {

            System.out.println("Question: " + questionActuelle.getTitreQuestion());
            System.out.println("Réponse 1. : " + questionActuelle.getReponse1());
            System.out.println("Réponse 2. : " + questionActuelle.getReponse2());
            System.out.println("Réponse 3. : " + questionActuelle.getReponse3());
            System.out.println("Réponse 4. : " + questionActuelle.getReponse4());

            System.out.print("Sélection de votre réponse de 1 à 4 : ");
            Scanner scanner1= new Scanner(System.in);
            int repNum = scanner.nextInt();
            questionActuelle.setNumReponseCorrecte(repNum);
            
            // Incrémente score si réponse correcte
            if (questionActuelle.getNumReponseCorrecte() == repNum ){
                score++;
            }
        }

        // Fin du quizz: affiche le score
        System.out.println("Votre score = " + score);
    }

    @Override
    public String toString() {
        return "Quiz{" + "titreQuiz=" + titreQuiz + ", questions=" + questions + '}';
    }

    /////get set/////
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
