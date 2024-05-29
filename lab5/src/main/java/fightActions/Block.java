package fightActions;

import lab5.Enemy;
import lab5.Player;

public class Block extends FightAction {

    @Override
    public String getType() {
        return "Block";
    }

    @Override
    public void realisation(Player player, Enemy enemy, String enemyActionType) {
        
    }
}
