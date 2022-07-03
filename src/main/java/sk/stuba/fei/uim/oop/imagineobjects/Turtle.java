package sk.stuba.fei.uim.oop.imagineobjects;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.imagineobjects.Line;

import java.awt.*;
import java.util.List;

@Getter
@Setter
public class Turtle {
    private double positionX;
    private double positionY;
    private Color color;
    private int angle;
    private int step;


    public Turtle(double positionX, double positionY, Color color, int step, int angle) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
        this.step = step;
        this.angle = angle;
    }

    public void draw(Graphics g) {
        double turtleArmor = 30.0;
        double head = 10.0;
        g.setColor(new Color(0,100,0));
        g.fillOval((int) (positionX-(turtleArmor/2.0)), (int) (positionY-(turtleArmor/2.0)),(int)turtleArmor,(int)turtleArmor);
        g.setColor(Color.pink);
        double angleRadian = this.angleToRadian();
        double positionHeadX = (Math.cos(angleRadian)*(turtleArmor/2.0))+positionX;
        double positionHeadY = (Math.sin(angleRadian)*(turtleArmor/2.0))+positionY;
        g.fillOval((int) (positionHeadX-(head/2.0)), (int) (positionHeadY-(head/2.0)),(int)head,(int)head);
    }

    private double angleToRadian() {
        return ((angle/180.0)*Math.PI);
    }

    public void moveAndTurn(List<Line> lines, int angle, int step) {
        this.angle+=angle;
        this.move(lines, step);
    }

    public void move(List<Line> lines, int step) {
        double angleRadian = this.angleToRadian();
        double endX = positionX+(Math.cos(angleRadian)*step);
        double endY = positionY+(Math.sin(angleRadian)*step);
        Line line = new Line(color,positionX,positionY, endX,endY);
        lines.add(line);
        positionX = endX;
        positionY = endY;
    }

    public void turnLeftTurtle(int angle) {
        this.angle -= angle;
    }

    public void turnRightTurtle(int angle) {
        this.angle += angle;
    }
}
