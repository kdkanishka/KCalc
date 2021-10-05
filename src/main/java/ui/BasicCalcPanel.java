package ui;

import core.CalcExpression;
import core.CalcExpressionEvaluator;
import core.InvalidExpressionException;

import javax.swing.*;
import java.awt.*;

public class BasicCalcPanel extends JPanel {

    public BasicCalcPanel() {
        setLayout(new FlowLayout());

        add(new JLabel("Expression"));

        TextField display = new TextField();
        display.setText("");
        display.setColumns(18);

        Font calcFont=new Font("Monospaced", Font.BOLD, 20);
        Font resultFont=new Font("Monospaced", Font.BOLD, 16);
        display.setFont(calcFont);


        add(display);
        JButton clearButton = new JButton("Clear");
        JButton calcButton = new JButton("Evaluate");
        add(calcButton);
        add(clearButton);

        JTextArea jTextArea = new JTextArea(7,22);
        jTextArea.setFont(resultFont);
        jTextArea.setForeground(Color.BLUE);
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JScrollPane scrollBar=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollBar);


        //add click event for clear
        clearButton.addActionListener(e -> {
            display.setText("");
        });

        //add click event for evaluation
        calcButton.addActionListener(e -> {
            try {
                String expression = display.getText();
                System.out.println(expression);
                CalcExpression calcExpression = new CalcExpression(expression);
                CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
                double result = evaluator.evaluate(calcExpression);
                display.setText("");

                jTextArea.append(expression+ "=" +result+"\n");
            }catch (InvalidExpressionException ex){
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Evaluation Failure",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }


}
