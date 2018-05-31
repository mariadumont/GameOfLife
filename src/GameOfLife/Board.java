/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfLife;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author alu20482156n
 */
public class Board extends javax.swing.JPanel implements ActionListener {

    private Universe universe;
    private Timer timer;

    
    public Board() {
        initComponents();
        initMyComponents();
    }
    
     private void initMyComponents() {
        ConfigSingleton cs = ConfigSingleton.getInstance();
        universe = new Universe();
        timer = new Timer(cs.getDeltaTime(), this);
        
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(102, 204, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int col = evt.getPoint().x / squareWidth();
        int row = evt.getPoint().y / squareHeight();
        universe.createCell(row, col);
        repaint();
    }//GEN-LAST:event_formMouseClicked

   

    public Timer getTimer() {
        return timer;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        universe.tick();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintUniverse(g);
    }

    private void paintUniverse(Graphics g) {
        ConfigSingleton cs = ConfigSingleton.getInstance();
        boolean[][] matrix = universe.getMatrix();
        for (int i = 0; i < cs.getNumRows(); i++) {
            for (int j = 0; j < cs.getNumCols(); j++) {
                Util.drawSquare(g, matrix[i][j], i, j, squareWidth(), squareHeight());
            }
        }
    }

    private int squareWidth() {
        return getWidth() / ConfigSingleton.getInstance().getNumCols();
    }

    private int squareHeight() {
        return getHeight() / ConfigSingleton.getInstance().getNumRows();
    }

    public void startGame() {
        timer.start();
    }

    public void stopGame() {
        timer.stop();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
