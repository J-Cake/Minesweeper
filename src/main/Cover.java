package main;

import java.awt.*;

public class Cover extends GameObject {
    public int x, y;
    public ID id;
    public boolean coversBomb;

    private boolean hovering = false;
    private boolean hidden = false;
    private int index;
    private int bombs;

    private Handler h;

    public Cover(int x, int y, ID id, int index, Handler h) {
        super(x, y, id);

        this.x = x;
        this.y = y;
        this.id = id;

        this.index = index;

        this.coversBomb = false;

        this.h = h;
    }

    public void setCoversBomb() {
        this.coversBomb = true;
    }
    public boolean getCoversBomb() {
        return this.coversBomb;
    }

    public void countBombs() {
//        try { if (this.h.object.get(this.index - 1).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        try { if (this.h.object.get(this.index + 1).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        try { if (this.h.object.get(this.index + (Game.HEIGHT / Game.SCL)).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        try { if (this.h.object.get(this.index - (Game.HEIGHT / Game.SCL)).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        // diagonals
//        try { if (this.h.object.get(this.index + (Game.HEIGHT / Game.SCL) + 1).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        try { if (this.h.object.get(this.index - (Game.HEIGHT / Game.SCL) + 1).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        try { if (this.h.object.get(this.index + (Game.HEIGHT / Game.SCL) - 1).coversBomb) { this.bombs++; } } catch (Exception e) {}
//        try { if (this.h.object.get(this.index - (Game.HEIGHT / Game.SCL) - 1).coversBomb) { this.bombs++; } } catch (Exception e) {}
        int i;

        i = this.index - 1;
//        System.out.println("1: " + i);
        if (i > 0) {
            System.out.println(h.object.get(i).coversBomb);
            if (h.object.get(i).coversBomb) this.bombs++;
        }

        i = this.index + 1;
//        System.out.println("2: " + i);
        if (i < Game.WIDTH / Game.SCL) {
            if (h.object.get(i).coversBomb) this.bombs++;
        }

        i = this.index - (Game.WIDTH / Game.SCL);
//        System.out.println("3: " + i);
        if (i > 0) {
            if (h.object.get(i).coversBomb) this.bombs++;
        }

        i = this.index + (Game.WIDTH / Game.SCL);
//        System.out.println("4: " + i);
        if (i < Game.WIDTH / Game.SCL) {
            if (h.object.get(i).getCoversBomb()) this.bombs++;
        }

        i = this.index - (Game.WIDTH / Game.SCL) - 1;
//        System.out.println("5: " + i);
        if (i > 0) {
            if (h.object.get(i).getCoversBomb()) this.bombs++;
        }

        i = this.index + (Game.WIDTH / Game.SCL) - 1;
//        System.out.println("6: " + i);
        if (i < Game.WIDTH / Game.SCL) {
            if (h.object.get(i).getCoversBomb()) this.bombs++;
        }

        i = this.index - (Game.WIDTH / Game.SCL) + 1;
//        System.out.println("7: " + i);
        if (i > 0) {
            if (h.object.get(i).getCoversBomb()) this.bombs++;
        }

        i = this.index + (Game.WIDTH / Game.SCL) + 1;
//        System.out.println("8: " + i);
        if (i < Game.WIDTH / Game.SCL) {
            if (h.object.get(i).getCoversBomb()) this.bombs++;
        }
    }

    public void tick() {
        if (Game.mouseCoords.x > this.x && Game.mouseCoords.x < this.x + Game.SCL) {
            if (Game.mouseCoords.y > this.y && Game.mouseCoords.y < this.y + Game.SCL) {
                this.hovering = true;
            } else {
                this.hovering = false;
            }
        } else {
            this.hovering = false;
        }
    }

    public void render(Graphics g) {
        if (!this.hidden) {
            g.setColor(Color.darkGray);
            g.drawRect(this.x, this.y, Game.SCL, Game.SCL);

            if (this.hovering) g.setColor(new Color(220, 220, 220));
            else g.setColor(new Color(180, 180, 180));

            g.fillRect(this.x, this.y, Game.SCL - 1, Game.SCL - 1);
        } else {
            g.setColor(Color.WHITE);
            g.drawString("" + this.bombs, this.x + (Game.SCL / 4), this.y + (Game.SCL / 4));
        }
    }

    public void click() {
        if (this.hovering) {
            this.hidden = true;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, Game.SCL, Game.SCL);
    }
}
