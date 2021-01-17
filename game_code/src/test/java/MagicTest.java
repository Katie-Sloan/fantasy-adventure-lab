import Player.Enums.CharacterClass;
import Player.Enums.SpellType;
import Player.Enums.Weapon;
import Player.Magic;
import Player.Melee;
import behaviour.Spell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicTest {

    Magic juan;
    Magic zsolt;

    //has spell
    //get spell
    // add spell
    @Before
    public void setUp() {
        juan = new Magic("Juan", Weapon.BIG_STAFF, 4, CharacterClass.WARLOCK, null);
        zsolt = new Magic("Zsolt", Weapon.BIG_STAFF, 20, CharacterClass.WARLOCK, null);
    }

    @Test
    public void canAddSpell() {
        juan.addSpell(SpellType.EXPELLIARMUS);
        assertEquals(1, juan.spellCount());
    }

    @Test
    public void canGetSpell() {
        juan.addSpell(SpellType.EXPELLIARMUS);
        assertEquals(SpellType.EXPELLIARMUS, juan.getSpell(0));
    }

    @Test
    public void hasSpell__true() {
        juan.addSpell(SpellType.EXPELLIARMUS);
        assertEquals(SpellType.EXPELLIARMUS, juan.hasSpell(SpellType.EXPELLIARMUS));
    }
    @Test
    public void hasSpell__false() {
        assertEquals(null, juan.hasSpell(SpellType.EXPELLIARMUS));
    }

    @Test
    public void canCalculateHpAfterHit() {
        juan.addSpell(SpellType.WINGARDIUM_LEVIOSA);
        SpellType spell = juan.getSpell(0);
        juan.spell.startCastingSpell(spell, zsolt);
        assertEquals(15, zsolt.getHealthPoints());
    }
    @Test
    public void canCalculateHpAfterHit_dead() {
        zsolt.addSpell(SpellType.WINGARDIUM_LEVIOSA);
        SpellType spell = zsolt.getSpell(0);
        zsolt.spell.startCastingSpell(spell, juan);
        assertEquals(0, juan.getHealthPoints());
    }
}
