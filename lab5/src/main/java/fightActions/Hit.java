package fightActions;

import lab5.Enemy;
import lab5.Player;

public class Hit extends FightAction {

    @Override
    public String getType() {
        return "Hit";
    }

    @Override
    public void realisation(Player player, Enemy enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit" -> {
                if (enemy.isDebuffed() & player.isDebuffed()){
                    enemy.setHealth((int) (-player.getDamage()*1.25/2) + enemy.getHealth());
                }
                if (enemy.isDebuffed() & !player.isDebuffed()){
                    enemy.setHealth((int) (-player.getDamage()*1.25) + enemy.getHealth());
                }
                if (!enemy.isDebuffed() & player.isDebuffed()){
                    enemy.setHealth((int) (-player.getDamage()/2) + enemy.getHealth());
                }
                if (!enemy.isDebuffed() & !player.isDebuffed()){
                    enemy.setHealth((int) (-player.getDamage()) + enemy.getHealth());
                }
            }
            case "Block" -> {
                if (Math.random() < 0.5) {
                    enemy.setHealth(-player.getDamage() / 2 + enemy.getHealth());
                }
            }
            case "Debuff" -> {
                enemy.setHealth((int) (-player.getDamage()*1.15) + enemy.getHealth());
            }
            case "Heal" -> {
                enemy.setHealth(-player.getDamage()*2 + enemy.getHealth());
            }
        }
    }
}
