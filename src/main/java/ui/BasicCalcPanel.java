package ui;

import core.CalcExpression;
import core.CalcExpressionEvaluator;
import core.InvalidExpressionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalcPanel extends JPanel {

    public BasicCalcPanel() {
        setLayout(new FlowLayout());

        TextField display = new TextField();
        display.setText("");
        display.setColumns(18);

        Font calcFont=new Font("Monospaced", Font.BOLD, 20);
        display.setFont(calcFont);


        add(display);
        JButton calcButton = new JButton("Calc");
        add(calcButton);

        JTextArea jTextArea = new JTextArea(7,18);
        jTextArea.setFont(calcFont);
        jTextArea.setForeground(Color.BLUE);
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(jTextArea);

        //add click events
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String expression = display.getText();
                    System.out.println(expression);
                    CalcExpression calcExpression = new CalcExpression(expression);
                    CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
                    double result = evaluator.evaluate(calcExpression);
                    display.setText("");

                    jTextArea.append(expression+ " = " +result+"\n");
                }catch (InvalidExpressionException ex){
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Evaluation Failure",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }


}
