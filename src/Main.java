
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
        try {
            FileInputStream in = new FileInputStream("tmp.data");
            ObjectInputStream s = new ObjectInputStream(in);
            cardList = (List<Card>) s.readObject();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Event events = new Event(cardList);

        JFrame window = new JFrame("Pokedeck");
        window.setSize (600, 300);
        window.setLocationRelativeTo(null);

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

        buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                events.addCard();
            }
        });

        buttonRemove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                events.removeCard();
            }
        });

        buttonUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                events.updateCard();
            }
        });

        buttonConsultCollection.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                events.consultCollection();
            }
        });

        buttonSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                events.searchCard();
            }
        });
    }
}