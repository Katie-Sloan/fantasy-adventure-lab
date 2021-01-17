package rooms;

import Entity.Entity;
import Entity.Enums.HealItem;
import behaviour.IMythicalCreature;
import org.omg.CORBA.IMP_LIMIT;

import java.util.ArrayList;

public class Room {

    String name;
    ArrayList<IMythicalCreature> enemies;
    ArrayList<HealItem> healItems;
    ArrayList<Integer> gems;
    boolean completed;
    RoomController controller;
    Entity player;
    String message = "Default Message";

    public Room(String name, ArrayList<IMythicalCreature> enemies, ArrayList<HealItem> healItems,
                ArrayList<Integer> gems, RoomController controller) {
        this.name = name;
        setInitialEnemies(enemies);
        setInitialHealItems(healItems);
        setInitialGems(gems);
        this.completed = false;
        this.controller = controller;
    }


    public void addEnemy(IMythicalCreature enemy) {
        this.enemies.add(enemy);
        enemy.setRoom(this);
    }

    public void addGemPile(Integer gems) {
        this.gems.add(gems);
    }

    public void addHealItem(int index, HealItem element) {
        this.healItems.add(index, element);
    }

    public void addHealItem(HealItem element) {
        this.healItems.add(element);
    }

    public HealItem removeHealItem(int index) {
        if (index >= (this.healItems.size())) return null;
        HealItem healItem = this.healItems.remove(index);
        if(isCompleted()) {
            setCompleted(true);
        }
        return healItem;
    }

    public IMythicalCreature removeEnemy(int index) {
        if (index >= (this.enemies.size())) return null;
        IMythicalCreature enemy = this.enemies.remove(index);
        if(isCompleted()) {
            setCompleted(true);
        }
        return enemy;
    }
    public void removeEnemy(IMythicalCreature enemy) {
        if (enemies.indexOf(enemy) >= (this.enemies.size())) return;
        int indexOfThing = enemies.indexOf(enemy);
        this.enemies.remove(indexOfThing);
        if(isCompleted()) {
            setCompleted(true);
        }
    }

    public Integer removeGem(int index) {
        if (index >= (this.gems.size())) return null;
        Integer gem = this.gems.remove(index);
        if(isCompleted()) {
            setCompleted(true);
        }
        return gem;
    }

    private boolean isCompleted() {
        return healItems.size() == 0 && enemies.size() == 0 && gems.size() == 0;
    }

    private void setInitialEnemies(ArrayList<IMythicalCreature> enemies) {
        if (enemies == null) {
            this.enemies = new ArrayList<IMythicalCreature>();
        } else {
            this.enemies = enemies;
        }
    }

    private void setInitialHealItems(ArrayList<HealItem> healItems) {
        if (healItems == null) {
            this.healItems = new ArrayList<HealItem>();
        } else {
            this.healItems = healItems;
        }
    }

    private void setInitialGems(ArrayList<Integer> gems) {
        if (gems == null) {
            this.gems = new ArrayList<Integer>();
        } else {
            this.gems = gems;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
        this.controller.changeRoom(this);
    }

    public IMythicalCreature getEnemy(int indexPosition) {
        if (indexPosition >= (this.enemies.size())) return null;
        return this.enemies.get(indexPosition);
    }
    public Integer getGemPile(int indexPosition) {
        if (indexPosition >= (this.gems.size())) return null;
        return this.gems.get(indexPosition);
    }

    public HealItem getHealItem(int indexPosition) {
        if (indexPosition >= (this.healItems.size())) return null;
        return this.healItems.get(indexPosition);
    }

    public int getGemCount() {
        return this.gems.size();
    }

    public int getEnemyCount() {
        return this.enemies.size();
    }

    public void addPlayer(Entity player) {
        this.player = player;
    }
    public void removePlayer() {
        this.player = null;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
