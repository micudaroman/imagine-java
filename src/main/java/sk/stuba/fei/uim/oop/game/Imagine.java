package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.action.Action;
import sk.stuba.fei.uim.oop.controls.Logic;

import javax.swing.*;
import java.awt.*;

public class Imagine {
    public Imagine(){
        JFrame frame = new JFrame("Imagine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.requestFocus();

        Integer angles[] = {0,5,10,45,90,180};
        JComboBox comboBox = new JComboBox(angles);
        comboBox.setSelectedItem(45);
        comboBox.setFocusable(false);

        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new GridLayout(2,3));
        Logic logic = new Logic(sideMenu,comboBox);

        comboBox.addItemListener(logic);

        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,10);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(10);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFocusable(false);
        slider.addChangeListener(logic);

        JButton moveButton = new JButton(Action.MOVE.toString());
        moveButton.addActionListener(logic);
        moveButton.setFocusable(false);
        JButton colorButton = new JButton(Action.COLOR.toString());
        colorButton.addActionListener(logic);
        colorButton.setFocusable(false);

        sideMenu.add(comboBox);
        sideMenu.add(slider);
        sideMenu.add(moveButton);
        sideMenu.add(logic.getLabelOfAngleAndStep());
        sideMenu.add(colorButton);
        sideMenu.add(logic.getLabelOFColor());


        frame.addKeyListener(logic);
        frame.add(logic.getRender(),BorderLayout.CENTER);
        frame.add(sideMenu,BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
