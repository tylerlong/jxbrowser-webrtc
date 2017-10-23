package com.ringcentral;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class RingCentralWebWidget {
    public static void main(String[] args) {
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame("RingCentral Java desktop demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(350, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL("https://ringcentral.github.io/ringcentral-web-widget/app.html");
    }
}
