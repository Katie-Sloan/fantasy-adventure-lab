import Entity.Enums.CharacterClass;
import Entity.Enums.HealItem;
import Entity.Enums.Weapon;
import Entity.mythicalcreatures.Ogre;
import behaviour.Heal;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;

import static org.junit.Assert.*;

public class RoomTest {

    Room codeClan;
    Ogre robert;

    @Before
    public void setUp() {
        codeClan = new Room("CodeClan", null, null, null);
        robert = new Ogre("Robert", Weapon.CLUB, 20, CharacterClass.MONSTER, null);
    }

    @Test
    public void hasName() {
        assertEquals("CodeClan", this.codeClan.getName());
    }

    @Test
    public void canAddEnemiesToRoom() {
        codeClan.addEnemy(robert);
        assertEquals(robert, this.codeClan.getEnemy(0));
    }

    @Test
    public void canAddHealItemsToTreasure() {
        codeClan.addHealItem(0, HealItem.HERB);
        codeClan.addHealItem(HealItem.POTION);
        assertEquals(HealItem.HERB, this.codeClan.getHealItem(0));
        assertEquals(HealItem.POTION, this.codeClan.getHealItem(1));
    }

    @Test
    public void canAddGemPilesToRoom() {
        codeClan.addGemPile(3);
        assertEquals(1, this.codeClan.getGemCount());
    }

    @Test
    public void canRemoveEnemiesFromRoom() {
        codeClan.addEnemy(robert);
        assertEquals(robert, this.codeClan.getEnemy(0));
        codeClan.removeEnemy(0);
        assertNull(this.codeClan.getEnemy(0));
    }
    @Test
    public void canRemoveEnemiesFromRoom_() {
        codeClan.addEnemy(robert);
        codeClan.addEnemy(robert);
        codeClan.addEnemy(robert);
        assertEquals(robert, this.codeClan.getEnemy(0));
        codeClan.removeEnemy(2);
        assertEquals(2, this.codeClan.getEnemyCount());
        codeClan.removeEnemy(1);
        assertEquals(robert, this.codeClan.getEnemy(0));
        assertNull(codeClan.removeEnemy(1));
        assertEquals(1, this.codeClan.getEnemyCount());
        codeClan.removeEnemy(0);
        assertNull(this.codeClan.getEnemy(0));
    }

    @Test
    public void canRemoveHealItemsFromRoom() {
        codeClan.addHealItem(HealItem.HERB);
        assertEquals(HealItem.HERB, this.codeClan.getHealItem(0));
        codeClan.removeHealItem(0);
        assertNull(this.codeClan.getHealItem(0));
    }

    @Test
    public void canRemoveGemsFromRoom() {
        codeClan.addGemPile(4);
        assertEquals(1, this.codeClan.getGemCount());
        assertEquals(4, (long) this.codeClan.getGemPile(0));
        codeClan.removeGem(0);
        assertEquals(0, this.codeClan.getGemCount());
        assertNull(this.codeClan.getGemPile(0));
    }

    @Test
    public void canCompleteRoom() {
        codeClan.addEnemy(robert);
        codeClan.addGemPile(4);
        codeClan.addHealItem(HealItem.HERB);
        codeClan.addHealItem(HealItem.HERB);
        codeClan.removeEnemy(0);
        codeClan.removeGem(0);
        codeClan.removeHealItem(0);
        assertFalse(codeClan.getCompleted());
        codeClan.removeHealItem(0);
        assertTrue(codeClan.getCompleted());
    }

    @Test
    public void canCompleteRoom_() {
        codeClan.addEnemy(robert);
        codeClan.addHealItem(HealItem.HERB);
        codeClan.addGemPile(4);
        codeClan.addGemPile(4);
        codeClan.removeEnemy(0);
        codeClan.removeHealItem(0);
        codeClan.removeGem(0);
        assertFalse(codeClan.getCompleted());
        codeClan.removeGem(0);
        assertTrue(codeClan.getCompleted());
    }

    @Test
    public void canCompleteRoom__() {
        codeClan.addEnemy(robert);
        codeClan.addEnemy(robert);
        codeClan.addGemPile(4);
        codeClan.addHealItem(HealItem.HERB);
        codeClan.removeGem(0);
        codeClan.removeHealItem(0);
        codeClan.removeEnemy(0);
        assertFalse(codeClan.getCompleted());
        codeClan.removeEnemy(0);
        assertTrue(codeClan.getCompleted());
    }


}
