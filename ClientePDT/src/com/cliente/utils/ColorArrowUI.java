package com.cliente.utils;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ColorArrowUI extends BasicComboBoxUI {

	public static ComboBoxUI createUI(JComponent c) {
        return new ColorArrowUI();
    }

    @Override protected JButton createArrowButton() {
        return new BasicArrowButton(
            BasicArrowButton.SOUTH,
            Color.DARK_GRAY, Color.DARK_GRAY,
            Color.WHITE, Color.DARK_GRAY);
    }
	
   
    
}
