
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;

import static java.lang.System.exit;
import static javax.swing.JFrame.*;

public class Main {

	public static void main(String[] args) {


        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 500);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE );
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.lightGray);
        JPanel  pannel = new JPanel(new FlowLayout ());
        JButton addCard = new JButton("Ajouter carte");
        pannel.add(addCard);
        JButton removeCard = new JButton("Supprimer carte");
        pannel.add(removeCard);
        JButton exit = new JButton("Quitter");
        pannel.add(exit);

        window.setLayout(new FlowLayout ());
        window.add(addCard);
        window.add(removeCard);
        window.add(exit);
        window.setVisible(true);
        // Actions click
        addCard.addActionListener(new AddCard());
        removeCard.addActionListener(new DeleteCard());
        exit.addActionListener(new Close());
        
        // Cards
        Card C1 = new Card("Charmander","fire");
        Card C2 = new Card("Vulpix","fire");


        // Show
        System.out.println("Exemples:");
        System.out.println("Name: "+C1.getName());
        System.out.println("Pokemon Type: "+C1.getPokemonType());
        System.out.println("Name: "+C2.getName());
        System.out.println("Pokemon Type: "+C2.getPokemonType());




    }


}
