package com.base.entities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounter implements ActionListener  {

    private int i = 0;
    private JLabel label;
    private JButton plus;
    private JButton moins;

    public JPanel getPanel() {
        JPanel panel = new JPanel();

        plus = new JButton("+");
        plus.addActionListener(this);
        panel.add(plus);

        moins = new JButton("-");
        moins.addActionListener(this);
        panel.add(moins);

        label = new JLabel("" + i);
        panel.add(label);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plus) {
            i++;
            label.setText("" + i);
        } else {
            i--;
            label.setText("" + i);
        }

        if (i > 4) {
            plus.setEnabled(false);
            moins.setEnabled(true);
        }
        if (i < 1) {
            moins.setEnabled(false);
            plus.setEnabled(true);
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}