
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

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        JButton exit = new JButton("Quitter");
        JButton remove = new JButton("Supprimer");

        JLabel labelAdd = new JLabel("<html><body><u>Ajouter un Pokemon:</u></body></html>");
        JLabel labelName = new JLabel("Nom:");
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
        comboCardType.addItem("normal");
        JButton add = new JButton("Ajouter");


        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(label);
        window.add(combo);
        window.add(remove);
        window.add(labelAdd);
        window.add(labelName);
        window.add(textField);
        window.add(comboCardType);
        window.add(add);

        window.setVisible(true);

        exit.addActionListener(new Close());

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                String name = (String) combo.getSelectedItem();

                if (cardList.size() < 1){
                    System.out.println("o");
                    JOptionPane popNone;
                    popNone = new JOptionPane();
                    popNone.showMessageDialog(null, "Il ne reste plus aucun pokémon", "Information", JOptionPane.INFORMATION_MESSAGE);

                }

                JOptionPane jop = new JOptionPane();

                int option = jop.showConfirmDialog(null, "Etes vous sûr de vouloir supprimer "+name+"?", "Arrêt de l'animation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);


                if(option == JOptionPane.NO_OPTION && option != JOptionPane.CLOSED_OPTION){

                System.out.println("ok");
                }
                if(option == JOptionPane.YES_OPTION) {
                    for(int i = 0; i < cardList.size(); i++) {

                        if (combo.getSelectedItem() == cardList.get(i).getName()){
                            cardList.remove(cardList.get(i)); // Remove from the array
                            combo.removeItem(combo.getSelectedItem()); // Remove from the ComboBox
                            JOptionPane popRemove;
                            popRemove = new JOptionPane();
                            popRemove.showMessageDialog(null, name+" a été supprimé", "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    // Verify removal and add
                    for(int i = 0; i < cardList.size(); i++) {
                        System.out.println(cardList.get(i).getName());
                    }
                }
            }
        }); // fin remove

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                String getCardType = (String) comboCardType.getSelectedItem();
                int flag = 1;
                String getName = textField.getText();
                JOptionPane pop1, pop2, popErreur;
                String t = getName;
                int flag2 = 0;

                for (int a = 0; a < t.length(); a++) {
                    char c = t.charAt(a);
                    if (Character.isLetter(c)){
                        flag2 = 1;
                    }
                }
                if (flag2 == 1){
                    for (int i = 0; i < cardList.size(); i++) {
                        if (getName.equals(cardList.get(i).getName())) {
                            flag++;
                        }
                    }
                    if (flag == 1){
                        cardList.add(new Card(getName, getCardType));
                        combo.addItem(getName);
                        pop1 = new JOptionPane();
                        pop1.showMessageDialog(null, getName+" a été ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        pop2 = new JOptionPane();
                        pop2.showMessageDialog(null, "Acion imossible, ce nom de pokemon est déjà utilisé", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else {
                    popErreur = new JOptionPane();
                    popErreur.showMessageDialog(null, "Veuillez rentrer au moins une lettre pour le nom de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
        }); // fin add
    }
}