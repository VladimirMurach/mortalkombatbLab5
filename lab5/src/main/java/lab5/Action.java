package lab5;

public abstract class Action {
    public abstract String getType();
    public abstract void realisation(Player player, Player enemy, String enemyActionType);
}
