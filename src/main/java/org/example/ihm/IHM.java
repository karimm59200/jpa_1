package org.example.ihm;

import org.example.demo.Demo1;

import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    Scanner scanner;

    String choix;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start() throws SQLException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1": Demo1.main();
                    break;
                case "2": Demo1.createQuery();
                    break;
                case "3": Demo1.remove();
                    break;

            }

        } while (!choix.equals("0"));
    }

    private void menu() {
        System.out.println("1- Entrez une tache.");
        System.out.println("2- Afficher toutes les taches de la liste.");
        System.out.println("3- Supprimer une tache de la liste.");
        System.out.println("0-Quitter");
    }

}
