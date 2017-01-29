
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {

        List<Card> cardList;
        cardList = new ArrayList<Card>();
        cardList.add(new Card("Salamèche","feu"));
        cardList.add(new Card("Goupix","feu"));
        cardList.add(new Card("Pikachu","électrique"));

        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 500);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.lightGray);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        JButton exit = new JButton("Quitter");
        JButton remove = new JButton("Supprimer");


        JLabel labelAdd = new JLabel("Ajouter un Pokemon:");
        JTextField textField = new JTextField();
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
        JButton add = new JButton("Ajouter");


        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(label);
        window.add(combo);
        window.add(remove);
        window.add(labelAdd);
        window.add(textField);
        window.add(comboCardType);
        window.add(add);

        window.setVisible(true);

        exit.addActionListener(new Close());

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for(int i = 0; i < cardList.size(); i++) {
                    String name = (String) combo.getSelectedItem();
                    if (combo.getSelectedItem() == cardList.get(i).getName()){
                        cardList.remove(cardList.get(i)); // Remove from the array
                        combo.removeItem(combo.getSelectedItem()); // Remove from the ComboBox
                        window.add( new JLabel (name+" a été supprimé"));
                    }
                }
                for(int i = 0; i < cardList.size(); i++) { // Verify removal and add
                    System.out.println(cardList.get(i).getName());
                }
            }
        }); // fin remove

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                String getName = textField.getText();

                String getCardType = (String) comboCardType.getSelectedItem();
                cardList.add(new Card(getName,getCardType));
                combo.addItem(getName);

            }
        }); // fin add
    }
}