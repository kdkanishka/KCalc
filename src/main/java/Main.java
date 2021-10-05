import javax.swing.*;

import com.kani.kcalc.core.view.BasicCalcPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("KCalc");
        frame.add(new BasicCalcPanel());

        frame.setSize(240,320);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
