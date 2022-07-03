package sk.stuba.fei.uim.oop.imagineobjects;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Line {
    private Color color;
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Line(Color color, double startX, double startY, double endX, double endY) {
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine((int)startX,(int)startY,(int)endX,(int)endY);
    }
}
