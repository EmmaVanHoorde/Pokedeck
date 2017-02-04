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
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));

        JButton exit = new JButton("Quitter");

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
        window.add(labelAdd);
        window.add(labelName);
        window.add(textField);
        window.add(comboCardType);
        window.add(add);
        window.setVisible(true);

        exit.addActionListener(new Close());

        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

                String getCardType = (String) comboCardType.getSelectedItem();
                int test1 = 1;
                String getName = textField.getText();
                JOptionPane pop1, pop2, popError;
                String t = getName;
                int test2 = 0;

                for (int a = 0; a < t.length(); a++) {
                    char c = t.charAt(a);
                    if (Character.isLetter(c)){
                        test2 = 1;
                    }
                }
                if (test2 == 1){
                    for (int i = 0; i < cardList.size(); i++) {
                        if (getName.equals(cardList.get(i).getName())) {
                            test1++;
                        }
                    }
                    if (test1 == 1){
                        cardList.add(new Card(getName, getCardType));
                        combo.addItem(getName);
                        pop1 = new JOptionPane();
                        pop1.showMessageDialog(null, getName+" a été ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        pop2 = new JOptionPane();
                        pop2.showMessageDialog(null, "Action imossible, ce nom de pokemon est déjà utilisé", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else {
                    popError = new JOptionPane();
                    popError.showMessageDialog(null, "Veuillez rentrer au moins une lettre pour le nom de ce pokemon", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        }); // end add
    } // end AddCard
}
