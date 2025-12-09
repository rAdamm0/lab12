package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(panel);
        Logics logics = new LogicsImpl(width);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final JButton button = new JButton();
                this.cells.add(button);
                button.addActionListener(e -> {
                    logics.hit();
                    refresh(logics, width);
                    if(logics.toQuit()){
                        this.dispose();
                    }
                });
                panel.add(button);
            }
        }
        refresh(logics, width);
        pack();
        this.setVisible(true);
    }

    private void refresh(Logics logics, int width){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                this.cells.get(i*width+j).setText(logics.values()[i][j] ? "*" : "");
            }
        }
    }
}
