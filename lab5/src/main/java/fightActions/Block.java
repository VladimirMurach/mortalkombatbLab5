package fightActions;

import fighters.Enemy;
import fighters.Player;

public class Block extends FightAction {

    @Override
    public String getType() {
        return "Block";
    }

    @Override
    public void realisation(Player player, Enemy enemy, String enemyActionType) {
        
    }
}
