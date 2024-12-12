package it.unibo.es3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final List<JButton> cells = new ArrayList<>();
    
    public GUI(int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);
        
        ActionListener al = e -> {
            var jb = (JButton)e.getSource();
        	jb.setText(String.valueOf(cells.indexOf(jb)));
        };
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
            	var pos = new Pair<>(j,i);
                final JButton jb = new JButton();
                jb.enableInputMethods(false);
                this.cells.add(jb);
                //jb.addActionListener(al);
                panel.add(jb);
            }
        }
        JPanel button = new JPanel(new BorderLayout());
        JButton action = new JButton(">");
        button.add(action);
        this.getContentPane().add(button, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
}