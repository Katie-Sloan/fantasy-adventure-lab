import Entity.Enums.CharacterClass;
import Entity.Enums.HealItem;
import Entity.Enums.Weapon;
import Entity.mythicalcreatures.Ogre;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room codeClan;
    Ogre robert;

    @Before
    public void setUp() {
        codeClan = new Room ("CodeClan", null, null, null);
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
    public void canAddGemsPilesToGems() {
        assertEquals("CodeClan", this.codeClan.getName());
    }
}
