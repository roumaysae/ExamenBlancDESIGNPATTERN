package com.roumaysae.implementations;

import com.roumaysae.interfaces.HDMI;

public class ImplementationHDMI implements HDMI {
    @Override
    public void display(String content) {
        System.out.println("HDMI: " + content);
    }
}
