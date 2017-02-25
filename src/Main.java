
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
        cardList.add(new Card("Salamèche","feu", "base", "50", "aucun"));
        cardList.add(new Card("Reptincel","feu", "niveau1", "90", "Salamèche"));
        cardList.add(new Card("Pikachu","électrique", "base", "60", "aucun"));
        cardList.add(new Card("Goupix","feu", "base", "60", "aucun"));


        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 500);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.lightGray);

        JButton buttonAdd = new JButton("Ajouter une carte");
        JButton buttonRemove = new JButton("Supprimer une carte");
        JButton buttonUpdate = new JButton("Mettre à jour une carte");
        JButton buttonConsultCollection = new JButton("Voir sa collection");
        JButton exit = new JButton("Quitter");

        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(buttonAdd);
        window.add(buttonUpdate);
        window.add(buttonConsultCollection);
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

        buttonUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                UpdateCard update = new UpdateCard(cardList);

            }

        });

        buttonConsultCollection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                ConsultCollection consult = new ConsultCollection(cardList);
            }
        });
    }
}