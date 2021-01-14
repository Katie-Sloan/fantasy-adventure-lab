import Player.Enums.CharacterClass;
import Player.Enums.Spell;
import Player.Enums.Weapon;
import Player.Magic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicTest {

    Magic warlock;

    //has spell
    //get spell
    // add spell
    @Before
    public void setUp() {
        warlock = new Magic("Zsolt", Weapon.BIG_STAFF, 4, CharacterClass.WARLOCK, null);
    }

    @Test
    public void canAddSpell() {
        warlock.addSpell(Spell.EXPELLIARMUS);
        assertEquals(1, warlock.spellCount());
    }

    @Test
    public void canGetSpell() {
        warlock.addSpell(Spell.EXPELLIARMUS);
        assertEquals(Spell.EXPELLIARMUS, warlock.getSpell(0));
    }

    @Test
    public void hasSpell__true() {
        warlock.addSpell(Spell.EXPELLIARMUS);
        assertEquals(Spell.EXPELLIARMUS, warlock.hasSpell(Spell.EXPELLIARMUS));
    }
    @Test
    public void hasSpell__false() {
        assertEquals(null, warlock.hasSpell(Spell.EXPELLIARMUS));
    }
}
