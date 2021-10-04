package ui;

import javax.swing.*;
import java.awt.*;

public class BasicCalcPanel extends JPanel {

    public BasicCalcPanel() {
        setLayout(new FlowLayout());

        TextField display = new TextField();
        display.setText("");
        display.setColumns(18);

        Font calcFont=new Font("Monospaced", Font.BOLD, 20);
        display.setFont(calcFont);


        add(display);
        add(new JButton("Calc"));

        JTextArea jTextArea = new JTextArea(7,18);
        jTextArea.setFont(calcFont);
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jTextArea);
    }


}
