import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCard {

    private List<Card> cardList;

    public UpdateCard(List<Card> cardListP) {

        cardList = cardListP;

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
            comboEvolution.addItem(cardList.get(i).getName());
        }

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        String name = (String) combo.getSelectedItem();

        for (int i = 0; i < cardList.size(); i++) {
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

                for (int i = 0; i < cardList.size(); i++) {

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

    }
}
