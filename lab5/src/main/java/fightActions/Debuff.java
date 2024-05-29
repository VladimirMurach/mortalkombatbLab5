package fightActions;

import lab5.Enemy;
import lab5.Player;

public class Debuff extends FightAction {

    @Override
    public String getType() {
        return "Debuff";
    }

    @Override
    public void realisation(Player player, Enemy enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit" -> {
            }
            case "Block" -> {
                if (Math.random()<0.75){
                    enemy.setMovesWithDebuff(enemy.getLevel());
                }
            }
            case "Debuff" -> {
            }
            case "Heal" -> {
            }
        }
    }
}