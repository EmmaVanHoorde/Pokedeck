import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event {

    List<Card> cardList;

    public Event(List<Card> cardListP){

        cardList = cardListP;
        cardList = new ArrayList<Card>();


    } // end Events

    public void addCard() {

        JFrame window = new JFrame("Pokedeck");
        window.setSize (750, 200);
        window.setLocationRelativeTo(null);
        JButton exit = new JButton("Quitter");
        JLabel labelAdd = new JLabel("<html><body><u>Ajouter un Pokemon:</u></body></html>");
        JLabel labelName = new JLabel("Nom:");
        JTextField textField = new JTextField();
        textField.setText("Nom");
        textField.setPreferredSize(new Dimension(100, 20));
        JComboBox comboCardType = new JComboBox();
        comboCardType.setPreferredSize(new Dimension(100, 20));
        comboCardType.addItem("feu");
        comboCardType.addItem("eau");
        comboCardType.addItem("électrique");
        comboCardType.addItem("plante");
        comboCardType.addItem("sol");
        comboCardType.addItem("vol");
        comboCardType.addItem("insecte");
        comboCardType.addItem("poison");
        comboCardType.addItem("fée");
        comboCardType.addItem("normal");
        comboCardType.addItem("autre");

        JComboBox comboStage = new JComboBox();
        comboStage.setPreferredSize(new Dimension(100, 20));
        comboStage.addItem("base");
        comboStage.addItem("niveau1");
        comboStage.addItem("niveau2");

        JLabel labelHP = new JLabel("PV:");
        JTextField textFieldHP = new JTextField();
        textFieldHP.setPreferredSize(new Dimension(40, 20));
        textFieldHP.setText("50");

        JLabel labelEvolution = new JLabel("Evolué de :");

        JComboBox comboEvolution = new JComboBox();
        comboEvolution.setPreferredSize(new Dimension(130, 20));
        comboEvolution.addItem("aucun");
        for(int i = 0; i < cardList.size(); i++) {
            comboEvolution.addItem(cardList.get(i).getName());
        }

        JButton add = new JButton("Ajouter");
        window.setLayout(new FlowLayout ());
        window.add(labelAdd);
        //window.add(labelName);
        window.add(textField);
        window.add(comboCardType);
        window.add(comboStage);
        window.add(labelHP);
        window.add(textFieldHP);
        window.add(labelEvolution);
        window.add(comboEvolution);
        window.add(add);
        window.add(exit);
        window.setVisible(true);
        exit.addActionListener(new Close());

        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                String getCardType = (String) comboCardType.getSelectedItem();
                String getStage = (String) comboStage.getSelectedItem();
                String getEvolvesFrom = (String) comboEvolution.getSelectedItem();
                int test1 = 1;
                String getName = textField.getText();
                String getHP = textFieldHP.getText();
                JOptionPane pop1, pop2, popError;
                String t = getName;
                String hp = getHP;
                int test2 = 0;
                int testHP = 0;
                for (int a = 0; a < t.length(); a++) {
                    char c = t.charAt(a);
                    if (Character.isLetter(c)) {
                        test2 = 1;
                    }
                }
                for (int b = 0; b < hp.length(); b++) {
                    char ca = hp.charAt(b);
                    if (Character.isDigit(ca)){
                        testHP = 1;
                    }
                }
                if (test2 != 1){
                    popError = new JOptionPane();
                    popError.showMessageDialog(null, "Veuillez rentrer au moins une lettre pour le nom de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                else if (testHP !=1) {
                    popError = new JOptionPane();
                    popError.showMessageDialog(null, "Veuillez rentrer au moins un chiffre pour les points de vie de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    for (int i = 0; i < cardList.size(); i++) {
                        if (getName.equals(cardList.get(i).getName())) {
                            test1++;
                        }
                    }
                    if (test1 == 1){
                        cardList.add(new Card(getName, getCardType, getStage, getHP, getEvolvesFrom));
                        comboEvolution.addItem(getName);
                        pop1 = new JOptionPane();
                        pop1.showMessageDialog(null, getName+" a été ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        pop2 = new JOptionPane();
                        pop2.showMessageDialog(null, "Action impossible, ce nom de pokemon est déjà utilisé", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }); // end add
    } //end addCard

    public void removeCard(){
        JFrame window = new JFrame("Pokedeck");
        window.setSize (500, 200);
        window.setLocationRelativeTo(null);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        JButton exit = new JButton("Quitter");
        JButton remove = new JButton("Supprimer");

        window.setLayout(new FlowLayout ());
        window.add(label);
        window.add(combo);
        window.add(remove);
        window.add(exit);

        window.setVisible(true);

        exit.addActionListener(new Close());

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {


                String name = (String) combo.getSelectedItem();

                if (cardList.size() < 1){
                    JOptionPane popNone;
                    popNone = new JOptionPane();
                    popNone.showMessageDialog(null, "Il ne reste plus aucun pokémon", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane jop = new JOptionPane();
                    int option = jop.showConfirmDialog(null, "Etes vous sûr de vouloir supprimer "+name+"?", "Arrêt de l'animation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if(option == JOptionPane.YES_OPTION) {
                        for(int i = 0; i < cardList.size(); i++) {

                            if (name == cardList.get(i).getName()){
                                cardList.remove(cardList.get(i)); // Remove from the array
                                combo.removeItem(combo.getSelectedItem()); // Remove from the ComboBox
                                JOptionPane popRemove;
                                popRemove = new JOptionPane();
                                popRemove.showMessageDialog(null, name+" a été supprimé", "Information", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
            }
        }); // end remove

    } // endTestRemove

    public void searchCard(){
        JFrame window = new JFrame("Pokedeck");
        window.setSize (580, 300);
        window.setLocationRelativeTo(null);

        JComboBox comboStage = new JComboBox();
        comboStage.setPreferredSize(new Dimension(120, 20));
        comboStage.addItem("sélectionner");
        comboStage.addItem("base");
        comboStage.addItem("niveau1");
        comboStage.addItem("niveau2");

        window.setLayout(new FlowLayout ());
        window.add ( new JLabel (" Chercher par niveau: "));
        window.add(comboStage);
        window.setVisible(true);
        JLabel label = new JLabel("--- ");
        window.add ( new JLabel (" pokemon(s) correspondant(s): "));
        window.add(label);

        JComboBox comboCardType = new JComboBox();
        comboCardType.setPreferredSize(new Dimension(100, 20));
        comboCardType.addItem("sélectionner");
//        comboCardType.addItem("feu");
//        comboCardType.addItem("eau");
//        comboCardType.addItem("électrique");
//        comboCardType.addItem("plante");
//        comboCardType.addItem("sol");
//        comboCardType.addItem("vol");
//        comboCardType.addItem("insecte");
//        comboCardType.addItem("poison");
//        comboCardType.addItem("fée");
//        comboCardType.addItem("normal");
//        comboCardType.addItem("autre");


        List testList;
        testList = new ArrayList();

        for(int i = 0; i < cardList.size(); i++) {

            String item;
            int testItem = 0;
            item = cardList.get(i).getPokemonType();


            for(int a = 0; a < testList.size(); a++){

                if(item.equals(testList.get(a))){
                    testItem++;
                }
            }
            if(testItem == 0){
                comboCardType.addItem(item);
                testList.add(item);
            }
        }

        window.add ( new JLabel ("<html><body><u>Chercher par type:</u></body></html>"));
        window.add(comboCardType);
        JLabel labelType = new JLabel("---");
        window.add ( new JLabel (" pokemon(s) correspondant(s): "));
        window.add(labelType);
        comboStage.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String stage = (String) comboStage.getSelectedItem();
                String result = "";
                int test = 0;
                for (int i = 0; i < cardList.size(); i++) {
                    if (stage.equals(cardList.get(i).getStage())) {
                        if (test == 0){
                            test++;
                        }
                        String name = cardList.get(i).getName();
                        result = result + " "+name;
                    }
                }
                if(test == 0){
                    result = "aucun";
                }
                label.setText(result);
            }
        });

        comboCardType.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String type = (String) comboCardType.getSelectedItem();
                String result = "";
                int test = 0;
                for (int i = 0; i < cardList.size(); i++) {
                    if (type.equals(cardList.get(i).getPokemonType())) {
                        if (test == 0){
                            test++;
                        }
                        String name = cardList.get(i).getName();
                        result = result + " "+name;
                    }
                }
                if(test == 0){
                    result = "-";
                }
                labelType.setText(result);
            }
        });

    } // end searchCard

    public void updateCard(){
        JFrame window = new JFrame("Pokedeck");
        window.setSize (650, 250);
        window.setLocationRelativeTo(null);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));
        JComboBox comboCardType = new JComboBox();
        JLabel label2 = new JLabel("Type:");
        comboCardType.setPreferredSize(new Dimension(100, 20));
        comboCardType.addItem("feu");
        comboCardType.addItem("eau");
        comboCardType.addItem("électrique");
        comboCardType.addItem("plante");
        comboCardType.addItem("sol");
        comboCardType.addItem("vol");
        comboCardType.addItem("insecte");
        comboCardType.addItem("poison");
        comboCardType.addItem("fée");
        comboCardType.addItem("normal");
        comboCardType.addItem("autre");

        JLabel labelStage = new JLabel("Stade:");
        JComboBox comboStage = new JComboBox();
        comboStage.setPreferredSize(new Dimension(100, 20));
        comboStage.addItem("base");
        comboStage.addItem("niveau1");
        comboStage.addItem("niveau2");

        JLabel labelHP = new JLabel("HP:");
        JTextField textFieldHP = new JTextField();
        textFieldHP.setPreferredSize(new Dimension(40, 20));

        JLabel labelEvolution = new JLabel("Evolué de :");
        JComboBox comboEvolution = new JComboBox();
        comboEvolution.setPreferredSize(new Dimension(130, 20));
        comboEvolution.addItem("aucun");

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        String name = (String) combo.getSelectedItem();

        for (int i = 0; i < cardList.size(); i++) {

            if( cardList.get(i).getName() != combo.getSelectedItem()){
                comboEvolution.addItem(cardList.get(i).getName());
            }
            if (name.equals(cardList.get(i).getName())) {
                String type = cardList.get(i).getPokemonType();
                comboCardType.setSelectedItem(type);
                String stage = cardList.get(i).getStage();
                comboStage.setSelectedItem(stage);
                String HP = cardList.get(i).getHP();
                textFieldHP.setText(HP);
                String evolution = cardList.get(i).getEvolvesFrom();
                comboEvolution.setSelectedItem(evolution);
            }

        }

        combo.addActionListener (new ActionListener () { // change attributes when an other pokemon is selected
            public void actionPerformed(ActionEvent e) {

                String name = (String) combo.getSelectedItem();
                comboEvolution.removeAllItems();
                comboEvolution.addItem("aucun");

                for (int i = 0; i < cardList.size(); i++) {
                    if( cardList.get(i).getName() != combo.getSelectedItem()){
                        comboEvolution.addItem(cardList.get(i).getName());
                    }
                    if (name.equals(cardList.get(i).getName())) {
                        String type = cardList.get(i).getPokemonType();
                        comboCardType.setSelectedItem(type);
                        String stage = cardList.get(i).getStage();
                        comboStage.setSelectedItem(stage);
                        String HP = cardList.get(i).getHP();
                        textFieldHP.setText(HP);
                        String evolution = cardList.get(i).getEvolvesFrom();
                        comboEvolution.setSelectedItem(evolution);
                    }
                }
            }
        });

        JButton exit = new JButton("Quitter");
        JButton update = new JButton("Mettre à jour");

        exit.addActionListener(new Close());

        window.setLayout(new FlowLayout ());
        window.add(label);
        window.add(combo);
        window.add(label2);
        window.add(comboCardType);
        window.add(labelStage);
        window.add(comboStage);
        window.add(labelHP);
        window.add(textFieldHP);
        window.add(labelEvolution);
        window.add(comboEvolution);
        window.add(update);
        window.add(exit);

        window.setVisible(true);

        update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                String name = (String) combo.getSelectedItem();
                String newPokemonType = (String) comboCardType.getSelectedItem();
                String newStage = (String) comboStage.getSelectedItem();
                String newHP = (String) textFieldHP.getText();
                String newEvolvesFrom = (String) comboEvolution.getSelectedItem();

                JOptionPane popError;
                String getHP = (String) textFieldHP.getText();
                String hp = getHP;
                int testHP = 0;
                for (int b = 0; b < hp.length(); b++) {
                    char ca = hp.charAt(b);
                    if (Character.isDigit(ca)){
                        testHP = 1;
                    }
                }
                if (testHP !=1) {
                    popError = new JOptionPane();
                    popError.showMessageDialog(null, "Veuillez rentrer au moins un chiffre pour les points de vie de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);

                }
                else {
                    for (int i = 0; i < cardList.size(); i++) {

                        if (name.equals(cardList.get(i).getName())) {
                            cardList.remove(cardList.get(i));
                            cardList.add(new Card(name,newPokemonType, newStage, newHP, newEvolvesFrom));
                        }
                        //System.out.println(cardList.get(i).getName()+" "+cardList.get(i).getPokemonType()+" "+cardList.get(i).getStage()+" "+cardList.get(i).getEvolvesFrom()); // Verify
                    }
                }
            }
        }); // end update

    } // end updateCard

    public void consultCollection(){
        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 200);
        window.setLocationRelativeTo(null);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir le Pokemon à visualiser:");
        combo.setPreferredSize(new Dimension(100, 20));

        JLabel labelType = new JLabel("Type:");
        JLabel labelStage = new JLabel("Stade:");
        JLabel labelHP = new JLabel("PV:");
        JLabel labelEvolution = new JLabel("Evolué de :");
        JLabel labelType2 = new JLabel("");
        JLabel labelStage2 = new JLabel("");
        JLabel labelHP2 = new JLabel("");
        JLabel labelEvolution2 = new JLabel("");


        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        String name = (String) combo.getSelectedItem();

        for (int i = 0; i < cardList.size(); i++) {
            if (name.equals(cardList.get(i).getName())) {
                String type = cardList.get(i).getPokemonType();
                labelType2.setText(type);
                String stage = cardList.get(i).getStage();
                labelStage2.setText(stage);
                String HP = cardList.get(i).getHP();
                labelHP2.setText(HP);
                String evolution = cardList.get(i).getEvolvesFrom();
                labelEvolution2.setText(evolution);

            }
        }

        combo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {

                String name = (String) combo.getSelectedItem();

                for (int i = 0; i < cardList.size(); i++) {
                    if (name.equals(cardList.get(i).getName())) {
                        String type = cardList.get(i).getPokemonType();
                        labelType2.setText(type);
                        String stage = cardList.get(i).getStage();
                        labelStage2.setText(stage);
                        String HP = cardList.get(i).getHP();
                        labelHP2.setText(HP);
                        String evolution = cardList.get(i).getEvolvesFrom();
                        labelEvolution2.setText(evolution);
                    }
                }
            }
        });

        JButton exit = new JButton("Quitter");

        exit.addActionListener(new Close());

        window.setLayout(new FlowLayout ());
        window.add(label);
        window.add(combo);
        window.add(labelType);
        window.add(labelType2);
        window.add(labelStage);
        window.add(labelStage2);
        window.add(labelHP);
        window.add(labelHP2);
        window.add(labelEvolution);
        window.add(labelEvolution2);
        window.add(exit);

        window.setVisible(true);
    } // end ConsultCollection

}
