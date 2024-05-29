package fighters;

import javax.swing.ImageIcon;

public class Enemy extends Fighter{

    private String name;

    public Enemy(String name, int level, int maxhealth, int damage, ImageIcon icon) {
        super(level, maxhealth, damage, icon);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
