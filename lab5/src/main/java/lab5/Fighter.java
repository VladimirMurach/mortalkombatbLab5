package lab5;

import javax.swing.ImageIcon;

public abstract class Fighter {
    
    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private ImageIcon icon;
    private int movesWithDebuff;
    
    public Fighter(int level, int maxhealth, int damage, ImageIcon icon) {
        this.level = level;
        this.health = maxhealth;
        this.maxHealth = maxhealth;
        this.damage = damage;
        this.icon = icon;
        movesWithDebuff = 0;
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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
    
    public boolean isDebuffed() {
        return movesWithDebuff > 0;
    }
}
