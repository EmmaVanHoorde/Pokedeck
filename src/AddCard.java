import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddCard {

    private List<Card> cardList;

    public AddCard(List<Card> cardListP){

        cardList = cardListP;

        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 500);
        window.setLocationRelativeTo(null);

        JComboBox combo = new JComboBox();
        combo.setPreferredSize(new Dimension(100, 20));

        JButton exit = new JButton("Quitter");

        JLabel labelAdd = new JLabel("<html><body><u>Ajouter un Pokemon:</u></body></html>");
        JLabel labelName = new JLabel("Nom:");
        JTextField textField = new JTextField();
        textField.setText("Nom");
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
        comboCardType.addItem("autre");

        JComboBox comboStage = new JComboBox();
        comboStage.setPreferredSize(new Dimension(100, 20));
        comboStage.addItem("base");
        comboStage.addItem("niveau1");
        comboStage.addItem("niveau2");

        JLabel labelHP = new JLabel("PV:");
        JTextField textFieldHP = new JTextField();
        textFieldHP.setPreferredSize(new Dimension(40, 20));
        textFieldHP.setText("50");

        JLabel labelEvolution = new JLabel("Evolué de :");

        JComboBox comboEvolution = new JComboBox();
        comboEvolution.setPreferredSize(new Dimension(130, 20));
        comboEvolution.addItem("aucun");
        for(int i = 0; i < cardList.size(); i++) {
            comboEvolution.addItem(cardList.get(i).getName());
        }

        JButton add = new JButton("Ajouter");

        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(labelAdd);
        window.add(labelName);
        window.add(textField);
        window.add(comboCardType);
        window.add(comboStage);
        window.add(labelHP);
        window.add(textFieldHP);
        window.add(labelEvolution);
        window.add(comboEvolution);
        window.add(add);
        window.setVisible(true);

        exit.addActionListener(new Close());

        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                String getCardType = (String) comboCardType.getSelectedItem();
                String getStage = (String) comboStage.getSelectedItem();
                String getEvolvesFrom = (String) comboEvolution.getSelectedItem();
                int test1 = 1;
                String getName = textField.getText();
                String getHP = textFieldHP.getText();

                JOptionPane pop1, pop2, popError;
                String t = getName;
                String hp = getHP;

                int test2 = 0;
                int testHP = 0;
                for (int a = 0; a < t.length(); a++) {
                    char c = t.charAt(a);
                    if (Character.isLetter(c)) {
                        test2 = 1;
                    }
                }
                for (int b = 0; b < hp.length(); b++) {
                    char ca = hp.charAt(b);
                    if (Character.isDigit(ca)){
                        testHP = 1;
                    }
                }

                if (test2 != 1){
                    popError = new JOptionPane();
                    popError.showMessageDialog(null, "Veuillez rentrer au moins une lettre pour le nom de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                else if (testHP !=1) {
                    popError = new JOptionPane();
                    popError.showMessageDialog(null, "Veuillez rentrer au moins un chiffre pour les points de vie de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);

                }
                else{
                    for (int i = 0; i < cardList.size(); i++) {
                        if (getName.equals(cardList.get(i).getName())) {
                            test1++;
                        }
                    }
                    if (test1 == 1){
                        cardList.add(new Card(getName, getCardType, getStage, getHP, getEvolvesFrom));
                        combo.addItem(getName);
                        pop1 = new JOptionPane();
                        pop1.showMessageDialog(null, getName+" a été ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        pop2 = new JOptionPane();
                        pop2.showMessageDialog(null, "Action impossible, ce nom de pokemon est déjà utilisé", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }); // end add
    } // end AddCard
}
