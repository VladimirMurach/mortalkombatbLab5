package fightActions;

import fighters.Enemy;
import fighters.Player;

public abstract class FightAction {
    public abstract String getType();
    public abstract void realisation(Player player, Enemy enemy, String enemyActionType);
}
