import Player.Enums.CharacterClass;
import Player.Enums.HealItem;
import Player.Enums.Weapon;
import Player.Melee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealTest {

    private Melee zsolt;
    private Melee roosa;

    @Before
    public void setUp() {
        zsolt = new Melee("Zsolt", Weapon.AXE, 20, CharacterClass.DWARF, Weapon.BIG_AXE);
        roosa = new Melee("Roosa", Weapon.CRAP_AXE, 30, CharacterClass.KNIGHT, Weapon.BIG_AXE);
    }

    @Test
    public void canHeal() {
        zsolt.startHitting(roosa);
        assertEquals(21, roosa.getHealthPoints());
        roosa.heal.startHealing(HealItem.POTION);
        assertEquals(23, roosa.getHealthPoints());
    }

}
