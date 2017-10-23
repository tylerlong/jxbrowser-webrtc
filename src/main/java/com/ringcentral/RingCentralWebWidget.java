package com.ringcentral;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RingCentralWebWidget {
    public static void main(String[] args) {
        new MainApp();
    }
}

class MainApp implements ActionListener {
    private JTextField textField = null;
    private Browser browser = null;

    MainApp() {
        browser = new Browser();
        BrowserView browserView = new BrowserView(browser);

        JPanel panel = new JPanel();
        JButton button = new JButton("Click to Dial");
        button.addActionListener(this);
        textField = new JTextField("Replace me with a phone number", 20);
        panel.add(button, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);

        JFrame frame = new JFrame("RingCentral Java desktop demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(browserView, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(400, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL("https://ringcentral.github.io/ringcentral-web-widget/app.html");
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        if (!text.matches("^\\d{4,}$")) {
            JOptionPane.showMessageDialog(null, "Please enter four or more digits");
            textField.setText("");
            textField.grabFocus();
            return;
        }
        browser.executeJavaScript("window.postMessage({"
            + "type: 'rc-adapter-new-call',"
            + "phoneNumber: '" + text + "',"
            + "toCall: true"
        + "}, '*');");
    }
}
