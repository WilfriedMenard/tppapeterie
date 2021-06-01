package fr.eni.tppapeterie.ihm;

import fr.eni.tppapeterie.ihm.Main;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JPanel panneauTextField;

    private JPanel panneauType;
    private JPanel panneauRadioButton;

    private JPanel panneauGrammage;
    private JPanel panneauCheckBox;

    private JPanel panneauComboBox;
    private JPanel panneauButton;

    private JLabel reference;
    private JLabel designation;
    private JLabel marque;
    private JLabel stock;
    private JLabel prix;
    private JLabel typeArticle;
    private JLabel grammage;
    private JLabel couleur;

    private JTextField fieldReference;
    private JTextField fieldDesignation;
    private JTextField fieldMarque;
    private JTextField fieldStock;
    private JTextField fieldPrix;

    private JRadioButton buttonRamette;
    private JRadioButton buttonStylo;

    private JCheckBox check80G;
    private JCheckBox check100G;

    private JComboBox listCouleur;

    private JButton previousArticle;
    private JButton newArticle;
    private JButton saveArticle;
    private JButton deleteArticle;
    private JButton nextArticle;

    public GUI() {
        this.setTitle("Papeterie");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getPanneauTextField());
        this.setVisible(true);
        this.pack();
    }

    public JPanel getPanneauTextField() {
        // Panneau TextField
        if (panneauTextField == null) {
            panneauTextField = new JPanel(); // Création du panneau comportant les TextField
            panneauTextField.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints(); // Utilisation du Layout GridBagConstraints
            // Ligne Référence
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panneauTextField.add(getReference(), gbc); // J'ajoute le bouton au panneau principal
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panneauTextField.add(getFieldReference(), gbc); // J'ajoute le bouton2 au panneau principal
            // Ligne Désignation
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 1;
            panneauTextField.add(getDesignation(), gbc);
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panneauTextField.add(getFieldDesignation(), gbc);
            // Ligne Marque
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 2;
            panneauTextField.add(getMarque(), gbc);
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 1;
            gbc.gridy = 2;
            panneauTextField.add(getFieldMarque(), gbc);
            // Ligne Stock
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 3;
            panneauTextField.add(getStock(), gbc);
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 1;
            gbc.gridy = 3;
            panneauTextField.add(getFieldStock(), gbc);
            // Ligne Prix
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 4;
            panneauTextField.add(getPrix(), gbc);
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 1;
            gbc.gridy = 4;
            panneauTextField.add(getFieldPrix(), gbc);
            // Ajout des panneaux secondaires
            // Ligne Type
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            panneauTextField.add(getPanneauType(), gbc);
            // Ligne Grammage
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 2;
            panneauTextField.add(getPanneauGrammage(), gbc);
            // Ligne Couleur
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 2;
            panneauTextField.add(getPanneauCouleur(), gbc);
            // Ligne des 5 boutons
            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.gridwidth = 5;
            panneauTextField.add(getPanneauButton(), gbc);
        }
        return panneauTextField;
    }

    // Panneau Secondaire Type (RadioButton)
    public JPanel getPanneauType() {
        if (panneauType == null) {
            panneauType = new JPanel();
            panneauType.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            // Mise en place du Label
            gbc.insets = new Insets(5, 5, 5, 85);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panneauType.add(getTypeArticle(), gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panneauType.add(getPanneauRadioButton(), gbc);
        }
        return panneauType;
    }
    // Construction d'un panneau tertiaire pour le panneau secondaire panneauType
    public JPanel getPanneauRadioButton() {
        if (panneauRadioButton == null) {
            panneauRadioButton = new JPanel();
            panneauRadioButton.setLayout(new BoxLayout(panneauRadioButton, BoxLayout.Y_AXIS));
            BoxLayout boxLayout = new BoxLayout(panneauRadioButton, BoxLayout.Y_AXIS);
            ButtonGroup boutonGroupe = new ButtonGroup();
            boutonGroupe.add(getButtonRamette());
            boutonGroupe.add(getButtonStylo());
            panneauRadioButton.add(getButtonRamette(), boxLayout);
            panneauRadioButton.add(getButtonStylo(), boxLayout);
        }
        return panneauRadioButton;
    }

    // Panneau Secondaire Grammage (CheckBox)
    public JPanel getPanneauGrammage() {
        if (panneauGrammage == null) {
            panneauGrammage = new JPanel();
            panneauGrammage.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 65);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panneauGrammage.add(getGrammage(), gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panneauGrammage.add(getPanneauCheckBox(), gbc);
        }
        return panneauGrammage;
    }
    // Construction d'un panneau tertiaire pour le panneau secondaire panneauGrammage
    public JPanel getPanneauCheckBox() {
        if (panneauCheckBox == null) {
            panneauCheckBox = new JPanel();
            panneauCheckBox.setLayout(new BoxLayout(panneauCheckBox, BoxLayout.Y_AXIS));
            BoxLayout boxLayout = new BoxLayout(panneauCheckBox, BoxLayout.Y_AXIS);
            ButtonGroup boutonGroupe = new ButtonGroup();
            boutonGroupe.add(getCheck80G());
            boutonGroupe.add(getCheck100G());
            panneauCheckBox.add(getCheck80G(), boxLayout);
            panneauCheckBox.add(getCheck100G(), boxLayout);
        }
        return panneauCheckBox;
    }

    // Panneau Couleur (ComboBox)
    public JPanel getPanneauCouleur() {
        if (panneauComboBox == null) {
            panneauComboBox = new JPanel();
            panneauComboBox.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 80);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panneauComboBox.add(getCouleur(), gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panneauComboBox.add(getListCouleur(), gbc);
        }
        return panneauComboBox;
    }

    // Panneau Button
    public JPanel getPanneauButton() {
        if (panneauButton == null) {
            panneauButton = new JPanel();
            panneauButton.setLayout(new FlowLayout());
            panneauButton.add(getPreviousArticle());
            panneauButton.add(getNewArticle());
            panneauButton.add(getSaveArticle());
            panneauButton.add(getDeleteArticle());
            panneauButton.add(getNextArticle());
        }
        return panneauButton;
    }

    // Création Label Référence
    public JLabel getReference() {
        if (reference == null) {
            reference = new JLabel("Référence");
        }
        return reference;
    }
    // Création TextField Référence
    public JTextField getFieldReference() {
        if (fieldReference == null) {
            fieldReference = new JTextField(null, 21);
        }
        return fieldReference;
    }

    // Création Label Désignation
    public JLabel getDesignation() {
        if (designation == null) {
            designation = new JLabel("Désignation");
        }
        return designation;
    }
    // Création Textfield Désignation
    public JTextField getFieldDesignation() {
        if (fieldDesignation == null) {
            fieldDesignation = new JTextField(null, 21);
        }
        return fieldDesignation;
    }

    // Création Label Marque
    public JLabel getMarque() {
        if (marque == null) {
            marque = new JLabel("Marque");
        }
        return marque;
    }
    // Création Textfield Marque
    public JTextField getFieldMarque() {
        if (fieldMarque == null) {
            fieldMarque = new JTextField(null, 21);
        }
        return fieldMarque;
    }

    // Création Label Stock
    public JLabel getStock() {
        if (stock == null) {
            stock = new JLabel("Stock");
        }
        return stock;
    }
    // Création TextField Stock
    public JTextField getFieldStock() {
        if (fieldStock == null) {
            fieldStock = new JTextField(null, 21);
        }
        return fieldStock;
    }

    // Création Label Prix
    public JLabel getPrix() {
        if (prix == null) {
            prix = new JLabel("Prix");
        }
        return prix;
    }
    // Création TextField Prix
    public JTextField getFieldPrix() {
        if (fieldPrix == null) {
            fieldPrix = new JTextField(null, 21);
        }
        return fieldPrix;
    }

    // Création Label Type
    public JLabel getTypeArticle() {
        if (typeArticle == null) {
            typeArticle = new JLabel("Type");
        }
        return typeArticle;
    }
    // Création RadioButton Ramette et Stylo
    public JRadioButton getButtonRamette() {
        if (buttonRamette == null) {
            buttonRamette = new JRadioButton("Ramette");
        }
        return buttonRamette;
    }
    public JRadioButton getButtonStylo() {
        if (buttonStylo == null) {
            buttonStylo = new JRadioButton("Stylo");
        }
        return buttonStylo;
    }

    // Création Label Grammage
    public JLabel getGrammage() {
        if (grammage == null) {
            grammage = new JLabel("Grammage");
        }
        return grammage;
    }
    // Création CheckBox Grammage 80G et 100G
    public JCheckBox getCheck80G() {
        if (check80G == null) {
            check80G = new JCheckBox("80 grammes");
        }
        return check80G;
    }
    public JCheckBox getCheck100G() {
        if (check100G == null) {
            check100G = new JCheckBox("100 grammes");
        }
        return check100G;
    }

    // Création Label Couleur
    public JLabel getCouleur() {
        if (couleur == null) {
            couleur = new JLabel("Couleur");
        }
        return couleur;
    }
    // Création ComboBox Couleur
    public JComboBox getListCouleur() {
        if (listCouleur == null) {
            listCouleur = new JComboBox(Couleur.values());
        }
        return listCouleur;
    }

    // Création Button previousArticle
    public JButton getPreviousArticle() {
        if (previousArticle == null) {
            previousArticle = new JButton(new ImageIcon("ressources/Back24.gif"));
        }
        return previousArticle;
    }
    // Création Button newArticle
    public JButton getNewArticle() {
        if (newArticle == null) {
            newArticle = new JButton(new ImageIcon("ressources/New24.gif"));
        }
        return newArticle;
    }
    // Création Button saveArticle
    public JButton getSaveArticle() {
        if (saveArticle == null) {
           saveArticle = new JButton(new ImageIcon("ressources/Save24.gif"));
        }
        return saveArticle;
    }
    // Création Button deleteArticle
    public JButton getDeleteArticle() {
        if (deleteArticle == null) {
            deleteArticle = new JButton(new ImageIcon("ressources/Delete24.gif"));
        }
        return deleteArticle;
    }
    // Création Button nextArticle
    public JButton getNextArticle() {
        if (nextArticle == null) {
            nextArticle = new JButton(new ImageIcon("ressources/Forward24.gif"));
        }
        return nextArticle;
    }
}
