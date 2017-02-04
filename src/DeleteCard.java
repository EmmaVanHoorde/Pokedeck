import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JOptionPane;


public class DeleteCard {

    private List<Card> cardList;

    public DeleteCard(List<Card> cardListP){

        cardList = cardListP;

        JFrame window = new JFrame("Pokedeck");
        window.setSize (800, 500);
        window.setLocationRelativeTo(null);

        JComboBox combo = new JComboBox();
        JLabel label = new JLabel("Choisir un Pokemon:");
        combo.setPreferredSize(new Dimension(100, 20));

        for(int i = 0; i < cardList.size(); i++) {
            combo.addItem(cardList.get(i).getName());
        }

        JButton exit = new JButton("Quitter");
        JButton remove = new JButton("Supprimer");

        window.setLayout(new FlowLayout ());
        window.add(exit);
        window.add(label);
        window.add(combo);
        window.add(remove);

        window.setVisible(true);

        exit.addActionListener(new Close());

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {


                String name = (String) combo.getSelectedItem();

                if (cardList.size() < 1){
                    JOptionPane popNone;
                    popNone = new JOptionPane();
                    popNone.showMessageDialog(null, "Il ne reste plus aucun pokémon", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane jop = new JOptionPane();
                    int option = jop.showConfirmDialog(null, "Etes vous sûr de vouloir supprimer "+name+"?", "Arrêt de l'animation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if(option == JOptionPane.YES_OPTION) {
                        for(int i = 0; i < cardList.size(); i++) {

                            if (name == cardList.get(i).getName()){
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
            }
        }); // end remove

    }


}
