package fightActions;

import fighters.Enemy;
import fighters.Player;

public class Heal extends FightAction {

    @Override
    public String getType() {
        return "Heal";
    }

    @Override
    public void realisation(Player player, Enemy enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit" -> {
            }
            case "Block" -> {
                player.setHealth((player.getMaxHealth() - player.getHealth()) / 2 + player.getHealth());
            }
            case "Debuff" -> {
            }
            case "Heal" -> {
            }
        }
    }
}
