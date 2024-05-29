package lab5;

import fighters.Enemy;
import fightActions.Debuff;
import fightActions.FightAction;
import fightActions.Hit;
import fightActions.Heal;
import fightActions.Block;
import fighters.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fight {

    Mediator mediator;
    Player player;
    Enemy enemy;
    public Location location = new Location();
    public ArrayList<FightAction> actionsList = new ArrayList<>() {
        {
            add(new Hit());
            add(new Block());
            add(new Debuff());
            add(new Heal());
        }
    };

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public void playerMove(FightAction enemyAction, FightAction playerAction) {
        mediator.setActionLabels(enemy, player, enemyAction, playerAction);
        playerAction.realisation(player, enemy, enemyAction.getType());
    }

    public void enemyMove(FightAction enemyAction, FightAction playerAction) {
        mediator.setActionLabels(player, enemy, enemyAction, playerAction);
        playerAction.realisation(enemy, player, enemyAction.getType());
    }

    public void checkDebuff() {
        if (!enemy.isDebuffed()) {
            mediator.setDebuffLabel(enemy, false);
        }
        if (enemy.isDebuffed()) {
            mediator.setDebuffLabel(enemy, true);
            enemy.loseDebuffTurn();
        }
        if (!player.isDebuffed()) {
            mediator.setDebuffLabel(player, false);
        }
        if (player.isDebuffed()) {
            mediator.setDebuffLabel(enemy, true);
            player.loseDebuffTurn();
        }

    }

    public void hit(int a, ArrayList<Result> results, int locationsNumber, Enemy[] enemiesList) {
        GameActions action = new GameActions();
        FightAction enemyAction = action.chooseEnemyAction(enemy, new ArrayList<>(actionsList));
        switch (a) {
            case 0 -> {
                playerMove(enemyAction,
                        actionsList.get(1));
                if (enemy.getHealth() > 0) {
                    enemyMove(actionsList.get(1), enemyAction);
                }
            }
            case 1 -> {
                playerMove(enemyAction, actionsList.get(0));
                if (enemy.getHealth() > 0) {
                    enemyMove(actionsList.get(0),
                            enemyAction);
                }
            }
            case 2 -> {
                playerMove(enemyAction, actionsList.get(2));
                if (enemy.getHealth() > 0) {
                    enemyMove(actionsList.get(2),
                            enemyAction);
                }
            }
        }
        mediator.setRoundTexts(player, enemy);
        checkDebuff();
        mediator.setHealthBar(player);
        mediator.setHealthBar(enemy);
        checkDeath(results, locationsNumber, enemiesList);
    }

    public void checkDeath(ArrayList<Result> results, int locationsNumber, Enemy[] enemiesList) {
        if (player.getHealth() <= 0 & player.getItems()[2].getCount() > 0) {
            player.setHealth((int) (player.getMaxHealth() * 0.05));
            player.getItems()[2].setCount(-1);
            mediator.setHealthBar(player);
            mediator.revive(player, player.getItems());
        }
        if (player.getHealth() <= 0 | enemy.getHealth() <= 0) {
            if (location.getCurrentLocation() == locationsNumber & "Lord Islam Maximov".equals(enemy.getName())) {
                location.resetLocation(false, 1);
                endFinalRound(results, enemiesList);
            } else {
                endRound(enemiesList);
            }
        }
    }

    public void endRound(Enemy[] enemiesList) {
        GameActions action = new GameActions();
        mediator.setEndFightDialog();
        if (player.getHealth() > 0) {
            mediator.setRoundEndText("You win");
            mediator.setGIF(true);
            if ("Lord Islam Maximov".equals(enemy.getName())) {
                action.addItems(38, 23, 8, player.getItems());
                action.addPointsBoss(player);
                location.resetLocation(true, player.getLevel());
            } else {
                action.addItems(25, 15, 5, player.getItems());
                action.addPoints(player);
            }
        } else {
            reset(enemiesList);
            mediator.setRoundEndText(enemy.getName() + " win");
            mediator.setGIF(false);

        }
    }

    public void reset(Enemy[] enemiesList) {
        GameActions action = new GameActions();
        player.setDamage(16);
        player.setHealth(80);
        player.setMaxHealth(80);
        action.resetEnemies(enemiesList);
        player.setLevel(0);
        player.setPoints(0);
        player.setExperience(0);
        player.setNextLevelExperience(40);
        location.setFullEnemiesList(enemiesList);
        location.resetLocation(false, player.getLevel());
    }

    public void endFinalRound(ArrayList<Result> results, Enemy[] enemiesList) {
        GameActions action = new GameActions();
        action.resetEnemies(enemiesList);
        String text = "Победа не на вашей стороне";
        if (player.getHealth() > 0) {
            action.addPoints(player);
            text = "Победа на вашей стороне";
        }
        boolean top = false;
        if (results == null) {
            top = true;
        } else {
            int a = 0;
            for (int j = 0; j < results.size(); j++) {
                if (player.getPoints() < results.get(j).getPoints()) {
                    a++;
                }
            }
            if (a < 10) {
                top = true;
            }
        }
        mediator.gameEnding(text, top);
    }

    public void newRound() {
        mediator.setPlayerMaxHealthBar(player);
        mediator.setEnemyMaxHealthBar(enemy);
        player.setHealth(player.getMaxHealth());
        enemy.setHealth(enemy.getMaxHealth());
        mediator.setHealthBar(player);
        mediator.setHealthBar(enemy);
    }

}
