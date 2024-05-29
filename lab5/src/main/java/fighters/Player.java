package fighters;

import java.util.HashMap;
import javax.swing.ImageIcon;

public class Player extends Fighter {
    
    private int points;
    private int experience;
    private int nextLevelExperience;
    private HashMap<String, Integer> items;

    public Player(int level, int maxhealth, int damage, ImageIcon icon) {
        super(level, maxhealth, damage, icon);
        points = 0;
        experience = 0;
        nextLevelExperience = 40;
        items = new HashMap<>();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getNextLevelExperience() {
        return nextLevelExperience;
    }

    public void setNextLevelExperience(int nextLevelExperience) {
        this.nextLevelExperience = nextLevelExperience;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

}
