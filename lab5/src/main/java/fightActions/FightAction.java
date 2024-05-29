package fightActions;

import lab5.Enemy;
import lab5.Player;

public abstract class FightAction {
    public abstract String getType();
    public abstract void realisation(Player player, Enemy enemy, String enemyActionType);
}
