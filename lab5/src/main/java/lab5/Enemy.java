package lab5;

import javax.swing.ImageIcon;

public class Enemy {

    private String name;
    private int level;
    private int health;
    private int maxhealth;
    private int damage;
    private ImageIcon icon;
    private int movesWithDebuff;

    public Enemy(String name, int level, int maxhealth, int damage, ImageIcon icon) {
        this.level = level;
        this.health = maxhealth;
        this.maxhealth = maxhealth;
        this.damage = damage;
        this.icon = icon;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getMovesWithDebuff() {
        return movesWithDebuff;
    }

    public void setMovesWithDebuff(int movesWithDebuff) {
        this.movesWithDebuff = movesWithDebuff;
    }

}
