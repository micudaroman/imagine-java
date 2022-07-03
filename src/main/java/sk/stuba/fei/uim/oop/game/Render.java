package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.imagineobjects.Line;
import sk.stuba.fei.uim.oop.imagineobjects.Turtle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Render extends JPanel {

    private List<Line> lines;
    private Turtle turtle;
    public Render(Color color, int angle, int step){
        this.setBackground(Color.WHITE);
        lines = new ArrayList<>();
        turtle = new Turtle(350.0,250.0,color,step,angle);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.lines.forEach(line -> line.draw(g));
        turtle.draw(g);
        this.repaint();
    }

    public void moveTurtle(int angle, int step, Color color) {
        this.turtle.setColor(color);
        this.turtle.moveAndTurn(lines,angle,step);
    }

    public void moveTurtle(int step, Color color) {
        this.turtle.setColor(color);
        this.turtle.move(lines,step);
    }

    public void turnLeftTurtle(int angle) {
        this.turtle.turnLeftTurtle(angle);
    }

    public void turnRightTurtle(int angle) {
        this.turtle.turnRightTurtle(angle);
    }

    public void moveTurtleBack(int step, Color color) {
        this.turtle.setColor(color);
        this.turtle.move(lines,(-1*step));
    }
}
