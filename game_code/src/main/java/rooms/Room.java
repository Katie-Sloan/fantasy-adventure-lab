package rooms;

import Entity.Enums.HealItem;
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
}
