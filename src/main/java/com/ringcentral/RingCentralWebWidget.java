package com.ringcentral;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class RingCentralWebWidget {
    public static void main(String[] args) {
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);

        JPanel panel = new JPanel();
        JButton button = new JButton("Call");
        JTextField textField = new JTextField("Replace me with a phone number", 20);
        panel.add(button, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);

        JFrame frame = new JFrame("RingCentral Java desktop demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(browserView, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(350, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL("https://ringcentral.github.io/ringcentral-web-widget/app.html");
    }
}
