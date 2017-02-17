import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCard {

    private List<Card> cardList;

    public UpdateCard(List<Card> cardListP) {

        cardList = cardListP;

        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 500);
        window.setLocationRelativeTo(null);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));

        JComboBox comboCardType = new JComboBox();
        JLabel label2 = new JLabel("Type:");
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

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());

        }

        combo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {

                String name = (String) combo.getSelectedItem();

                for (int i = 0; i < cardList.size(); i++) {
                    if (name.equals(cardList.get(i).getName())) {
                        String type = cardList.get(i).getPokemonType();
                        comboCardType.setSelectedItem(type);
                    }
                }
            }
        });

        JButton exit = new JButton("Quitter");
        JButton update = new JButton("Mettre à jour");

        exit.addActionListener(new Close());

        window.setLayout(new FlowLayout ());
        window.add(label);
        window.add(combo);
        window.add(label2);
        window.add(comboCardType);
        window.add(update);
        window.add(exit);

        window.setVisible(true);

        update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {

            String name = (String) combo.getSelectedItem();
            String newPokemonType = (String) comboCardType.getSelectedItem();
                
                for (int i = 0; i < cardList.size(); i++) {
                    if (name.equals(cardList.get(i).getName())) {

                        cardList.remove(cardList.get(i));
                        cardList.add(new Card(name,newPokemonType));

                    }
                    System.out.println(cardList.get(i).getName()+" "+cardList.get(i).getPokemonType()); // Verify

                }
            }

        }); // end update



    }
}
