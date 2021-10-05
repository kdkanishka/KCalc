package com.kani.kcalc.core;

import javax.swing.*;

import com.kani.kcalc.core.view.BasicCalcPanel;

public class Main {
    public static void main(String[] args) {
        JFrame kCalcFrame = new JFrame("KCalc");
        kCalcFrame.add(new BasicCalcPanel());

        kCalcFrame.setSize(240,320);
        kCalcFrame.setLocationRelativeTo(null);
        kCalcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kCalcFrame.setResizable(false);
        kCalcFrame.setVisible(true);
    }
}
