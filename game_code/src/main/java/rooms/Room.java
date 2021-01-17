package rooms;

import Entity.Enums.HealItem;
import Entity.mythicalcreatures.Ogre;
import behaviour.Heal;
import behaviour.IMythicalCreature;

import java.util.ArrayList;

public class Room {

    String name;
    ArrayList<IMythicalCreature> enemies;
    ArrayList<HealItem> healItems;
    ArrayList<Integer> gems;
    boolean completed;

    public Room(String name, ArrayList<IMythicalCreature> enemies, ArrayList<HealItem> healItems, ArrayList<Integer> gems) {
        this.name = name;
        setInitialEnemies(enemies);
        setInitialHealItems(healItems);
        setInitialGems(gems);
        this.completed = false;
    }

    public void addEnemy(IMythicalCreature enemy) {
        this.enemies.add(enemy);
    }

    public IMythicalCreature removeEnemy(int index) {
        return this.enemies.remove(index);
    }

    public void addGemPile(int index, Integer element) {
        this.gems.add(index, element);
    }


    public Integer removeGemPile(int index) {
        return this.gems.remove(index);
    }

    public void addHealItem(int index, HealItem element) {
        this.healItems.add(index, element);
    }

    public void addHealItem(HealItem element) {
        this.healItems.add(element);
    }

    public HealItem removeHealItem(int index) {
        return this.healItems.remove(index);
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public IMythicalCreature getEnemy(int indexPosition) {
        return this.enemies.get(indexPosition);
    }

    public HealItem getHealItem(int indexPosition) {
        return this.healItems.get(indexPosition);
    }
}
