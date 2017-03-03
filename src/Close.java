
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Close implements ActionListener {

    public void actionPerformed ( ActionEvent e) {
        FileOutputStream f = null;
        try {
            f = new FileOutputStream("tmp.data");
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject(Main.cardList);
            s.flush();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.exit(0);
    }
}
