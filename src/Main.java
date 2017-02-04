
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
import javax.swing.JOptionPane;

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

        JButton buttonAdd = new JButton("Ajouter un pokemon");
        JButton buttonRemove = new JButton("Supprimer un pokemon");
        JButton exit = new JButton("Quitter");

        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(buttonAdd);
        window.add(buttonRemove);
        window.setVisible(true);

        exit.addActionListener(new Close());

        buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                AddCard add = new AddCard(cardList);
            }

        }); // end buttonAdd

        buttonRemove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                DeleteCard remove = new DeleteCard(cardList);
            }

        }); // end buttonRemove

    }
}