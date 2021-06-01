package fr.eni.tppapeterie.ihm;

import javax.swing.*;
import fr.eni.tppapeterie.ihm.GUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame app = new GUI();
            }
        });
    }
}
