import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultCollection {

    private List<Card> cardList;

    public ConsultCollection (List<Card> cardListP) {

        cardList = cardListP;

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


    }
}
