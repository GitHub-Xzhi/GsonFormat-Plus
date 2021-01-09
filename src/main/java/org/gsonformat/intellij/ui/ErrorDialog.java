package org.gsonformat.intellij.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ErrorDialog extends JFrame {

    private JPanel contentPane;
    private JTextPane editTP;
    private JButton okButton;
    private JScrollPane scrollPane;

    public ErrorDialog(String errorInfo) {
        setContentPane(contentPane);
        setTitle("错误信息");
        getRootPane().setDefaultButton(okButton);
        this.setAlwaysOnTop(true);
        editTP.setText(errorInfo);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        editTP.setCaretPosition(0);

    }
}
