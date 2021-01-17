import Entity.Enums.CharacterClass;
import Entity.Enums.HealItem;
import Entity.Enums.Weapon;
import Entity.mythicalcreatures.Ogre;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        System.out.println(this.codeClan.getEnemyCount());
        codeClan.addEnemy(robert);
        System.out.println(this.codeClan.getEnemyCount());
        assertEquals(robert, this.codeClan.getEnemy(0));
        codeClan.removeEnemy(0);
        System.out.println(this.codeClan.getEnemyCount());
        assertNull(this.codeClan.getEnemy(0));
    }
}