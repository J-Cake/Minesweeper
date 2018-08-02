package main;

import java.awt.*;

public class Bomb extends GameObject {

    public int x, y;
    public ID id;

    private int index;

    public Bomb(int x, int y, ID id, Handler h) {
        super(x, y, id);

        this.x = (int)(Math.random() * (Game.WIDTH  / Game.SCL)) * Game.SCL;
        this.y = (int)(Math.random() * (Game.HEIGHT / Game.SCL)) * Game.SCL;

        this.id = id;

        this.index = (this.x / Game.SCL) * (Game.HEIGHT /Game.SCL);
        this.index += (this.y / Game.SCL);

        h.object.get(this.index).setCoversBomb();
    }

    public void setCoversBomb() {}
    public boolean getCoversBomb() {return false;}
    public void countBombs() {}
    // program only works if these function are here... dunno why

    public void tick() {

    }

    public void click() {

    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(this.x, this.y, Game.SCL, Game.SCL);
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, Game.SCL, Game.SCL);
    }
}
