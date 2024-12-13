package com.roumaysae.implementations;

import com.roumaysae.interfaces.HDMI;
import com.roumaysae.interfaces.VGA;

public class VGAtoHDMIAdapter implements HDMI {
    private VGA vgaDisplay;

    public VGAtoHDMIAdapter(VGA vgaDisplay) {
        this.vgaDisplay = vgaDisplay;
    }

    @Override
    public void display(String content) {
        vgaDisplay.show(content);
    }
}
