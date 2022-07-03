package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.action.Action;
import sk.stuba.fei.uim.oop.game.Render;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class Logic extends UniversalAdapter {

    private JPanel sideMenu;
    private Render render;
    private JLabel labelOfAngleAndStep;
    private JLabel labelOFColor;

    private JComboBox comboBox;

    private Color color;

    private Color[] colors;
    private int colorCounter;

    private int angle;
    private int step;
    public Logic(JPanel sideMenu, JComboBox comboBox) {
        this.sideMenu = sideMenu;
        this.comboBox = comboBox;
        this.colors = new Color[]{Color.RED,Color.BLUE,Color.GREEN};
        this.color = colors[0];
        this.render = new Render(color,270,step);
        this.labelOfAngleAndStep = new JLabel();
        this.labelOFColor = new JLabel("Color");
        this.angle = 45;
        this.step = 10;
        this.updateLabel();
    }

    private void updateLabel() {
        this.labelOfAngleAndStep.setText("Angle:"+this.angle+" Step:"+this.step);
        this.labelOFColor.setForeground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Action.COLOR.toString())){
            this.turnColor();
            this.updateLabel();
        }else if(e.getActionCommand().equals(Action.MOVE.toString())){
            this.render.moveTurtle(angle,step,color);
        }
    }

    private void turnColor() {
        colorCounter++;
        colorCounter%=3;
        color = colors[colorCounter];
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            this.render.moveTurtle(step,color);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.render.moveTurtleBack(step,color);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            this.render.turnLeftTurtle(angle);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.render.turnRightTurtle(angle);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.step = ((JSlider) e.getSource()).getValue();
        this.updateLabel();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    if(e.getSource() == comboBox){
        this.angle = Integer.parseInt(comboBox.getSelectedItem().toString());
    }
        this.updateLabel();
    }
}
