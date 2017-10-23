package com.ringcentral;

import javax.swing.JOptionPane;

public class JavaObject {
    public void onCallRing(String from) {
        JOptionPane.showMessageDialog(null, from + " is calling");
    }
}
