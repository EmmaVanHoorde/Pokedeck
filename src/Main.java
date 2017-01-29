
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



public class Main {

	public static void main(String[] args) {

        List<Card> cardList;
        cardList = new ArrayList<Card>();
        cardList.add(new Card("Salamèche","feu"));
        cardList.add(new Card("Goupix","feu"));
        cardList.add(new Card("Pikachu","électrique"));

        JFrame window = new JFrame("Pokedeck - Remove card");
        window.setSize (800, 500);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.lightGray);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon");
        combo.setPreferredSize(new Dimension(100, 20));

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        JPanel  pannel = new JPanel(new FlowLayout ());
        JButton exit = new JButton("Quitter");
        JButton ok = new JButton("Supprimer");
        pannel.add(exit);
        pannel.add(label);
        pannel.add(combo);
        pannel.add(ok);

        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(label);
        window.add(combo);
        window.add(ok);
        window.setVisible(true);

        exit.addActionListener(new Close());

        ok.addActionListener(new ActionListener() {
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
                for(int i = 0; i < cardList.size(); i++) { // Verify removal from the array
                    System.out.println(cardList.get(i));
                }
            }
        });


    }


}
