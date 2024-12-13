package com.roumaysae.implementations;

import com.roumaysae.interfaces.VGA;

public class VGADisplay implements VGA {
    @Override
    public void show(String content) {
        System.out.println("Affichage VGA : " + content);
    }
}
