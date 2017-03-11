import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class SearchCard {

    private List<Card> cardList;

    public SearchCard (List<Card> cardListP) {

        cardList = cardListP;

        JFrame window = new JFrame("Pokedeck");
        window.setSize (580, 300);
        window.setLocationRelativeTo(null);

        JComboBox comboStage = new JComboBox();
        comboStage.setPreferredSize(new Dimension(120, 20));
        comboStage.addItem("sélectionner");
        comboStage.addItem("base");
        comboStage.addItem("niveau1");
        comboStage.addItem("niveau2");

        window.setLayout(new FlowLayout ());
        window.add ( new JLabel (" Chercher par niveau: "));
        window.add(comboStage);
        window.setVisible(true);
        JLabel label = new JLabel("--- ");


        window.add ( new JLabel (" pokemon(s) correspondant(s): "));
        window.add(label);

        JComboBox comboCardType = new JComboBox();
        comboCardType.setPreferredSize(new Dimension(100, 20));
        comboCardType.addItem("sélectionner");
//        comboCardType.addItem("feu");
//        comboCardType.addItem("eau");
//        comboCardType.addItem("électrique");
//        comboCardType.addItem("plante");
//        comboCardType.addItem("sol");
//        comboCardType.addItem("vol");
//        comboCardType.addItem("insecte");
//        comboCardType.addItem("poison");
//        comboCardType.addItem("fée");
//        comboCardType.addItem("normal");
//        comboCardType.addItem("autre");


        List testList;
        testList = new ArrayList();

        for(int i = 0; i < cardList.size(); i++) {

            String item;
            int testItem = 0;
            item = cardList.get(i).getPokemonType();


            for(int a = 0; a < testList.size(); a++){

                if(item.equals(testList.get(a))){
                    testItem++;
                }
            }
            if(testItem == 0){
                comboCardType.addItem(item);
                testList.add(item);
            }

        }


        window.add ( new JLabel (" Chercher par type: "));
        window.add(comboCardType);
        JLabel labelType = new JLabel("---");
        window.add ( new JLabel (" pokemon(s) correspondant(s): "));
        window.add(labelType);

        comboStage.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String stage = (String) comboStage.getSelectedItem();
                String result = "";
                int test = 0;

                for (int i = 0; i < cardList.size(); i++) {
                    if (stage.equals(cardList.get(i).getStage())) {

                        if (test == 0){
                            test++;
                        }
                        String name = cardList.get(i).getName();
                        result = result + " "+name;
                    }

                }
                if(test == 0){
                    result = "aucun";
                }
                label.setText(result);
            }
        });

        comboCardType.addActionListener (new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String type = (String) comboCardType.getSelectedItem();
                String result = "";
                int test = 0;

                for (int i = 0; i < cardList.size(); i++) {
                    if (type.equals(cardList.get(i).getPokemonType())) {

                        if (test == 0){
                            test++;
                        }
                        String name = cardList.get(i).getName();
                        result = result + " "+name;
                    }

                }
                if(test == 0){
                    result = "-";
                }
                labelType.setText(result);
            }
        });
    }
}
