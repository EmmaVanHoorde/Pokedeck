
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    static List<Card> cardList;

    public static void main(String[] args) throws IOException {

        cardList = new ArrayList<Card>();
//        cardList.add(new Card("Salamèche","feu", "base", "50", "aucun"));
//        cardList.add(new Card("Reptincel","feu", "niveau1", "90", "Salamèche"));
//        cardList.add(new Card("Pikachu","électrique", "base", "60", "aucun"));
//        cardList.add(new Card("Goupix","feu", "base", "60", "aucun"));



        FileInputStream in = new FileInputStream("tmp.data");
        ObjectInputStream s = new ObjectInputStream(in);

        try {
            cardList = (List<Card>) s.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        JFrame window = new JFrame("Pokedeck");
        window.setSize (600, 300);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.lightGray);

        JButton buttonAdd = new JButton("Ajouter une carte");
        JButton buttonRemove = new JButton("Supprimer une carte");
        JButton buttonUpdate = new JButton("Mettre à jour une carte");
        JButton buttonConsultCollection = new JButton("Voir sa collection");
        JButton buttonSearch = new JButton("Rechercher une carte");
        JButton exit = new JButton("Quitter");

        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(buttonAdd);
        window.add(buttonUpdate);
        window.add(buttonConsultCollection);
        window.add(buttonRemove);
        window.add(buttonSearch);
        window.setVisible(true);

        exit.addActionListener(new Close());

        List<Card> finalCardList1 = cardList;
        buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                AddCard add = new AddCard(finalCardList1);
            }

        });

        List<Card> finalCardList = cardList;
        buttonRemove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                DeleteCard remove = new DeleteCard(finalCardList);
            }

        });

        List<Card> finalCardList2 = cardList;
        buttonUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                UpdateCard update = new UpdateCard(finalCardList2);
            }

        });

        List<Card> finalCardList3 = cardList;
        buttonConsultCollection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                ConsultCollection consult = new ConsultCollection(finalCardList3);
            }
        });

        List<Card> finalCardList4 = cardList;
        buttonSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                SearchCard search = new SearchCard(finalCardList4);
            }
        });
    }
}