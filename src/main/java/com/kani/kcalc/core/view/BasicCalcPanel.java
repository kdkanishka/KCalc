package com.kani.kcalc.core.view;


import com.kani.kcalc.core.engine.BasicExpression;
import com.kani.kcalc.core.engine.CalcExpressionEvaluator;
import com.kani.kcalc.core.engine.Expression;
import com.kani.kcalc.core.engine.exceptions.InvalidExpressionException;
import com.kani.kcalc.core.engine.exceptions.UnsupportedOperatorException;

import javax.swing.*;
import java.awt.*;

public class BasicCalcPanel extends JPanel {

    public BasicCalcPanel() {
        setLayout(new FlowLayout());

        add(new JLabel("Expression"));

        TextField expressionField = new TextField();
        expressionField.setText("");
        expressionField.setColumns(18);

        Font calcFont = new Font("Monospaced", Font.BOLD, 20);
        Font resultFont = new Font("Monospaced", Font.BOLD, 16);
        expressionField.setFont(calcFont);


        add(expressionField);
        JButton clearButton = new JButton("Clear");
        JButton calcButton = new JButton("Evaluate");
        add(calcButton);
        add(clearButton);

        JTextArea resultsTextArea = new JTextArea(7, 22);
        resultsTextArea.setFont(resultFont);
        resultsTextArea.setForeground(Color.BLUE);
        resultsTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JScrollPane scrollBar = new JScrollPane(resultsTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollBar);


        //add click event for clear
        clearButton.addActionListener(e -> {
            expressionField.setText("");
        });

        //add click event for evaluation
        calcButton.addActionListener(e -> {
            try {
                String expression = expressionField.getText();
                Expression basicExpression = new BasicExpression(expression);
                CalcExpressionEvaluator evaluator = new CalcExpressionEvaluator();
                double result = evaluator.evaluate(basicExpression);
                expressionField.setText("");

                resultsTextArea.append(expression + "=" + result + "\n");
            } catch (InvalidExpressionException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Evaluation Failure",
                        JOptionPane.WARNING_MESSAGE);
            } catch (UnsupportedOperatorException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Unsupported Operator in Expression",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }


}
