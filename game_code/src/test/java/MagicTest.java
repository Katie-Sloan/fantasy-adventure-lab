import Entity.Enums.CharacterClass;
import Entity.Enums.SpellType;
import Entity.Enums.Weapon;
import Entity.Magic;
import Entity.mythicalcreatures.Ogre;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.memory.Space;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MagicTest {

    Magic juan;
    Magic zsolt;
    Ogre robert;

    @Before
    public void setUp() {
        juan = new Magic("Juan", Weapon.BIG_STAFF, 4, CharacterClass.WARLOCK, null, null);
        zsolt = new Magic("Zsolt", Weapon.BIG_STAFF, 20, CharacterClass.WARLOCK, null, null);
        robert = new Ogre("Robert", Weapon.CLUB, 20, CharacterClass.MONSTER, null);
    }

    @Test
    public void canAddSpell() {
        juan.spellCast.addSpell(SpellType.EXPELLIARMUS);
        assertEquals(1, juan.spellCast.spellCount());
    }

    @Test
    public void canGetSpell() {
        juan.spellCast.addSpell(SpellType.EXPELLIARMUS);
        assertEquals(SpellType.EXPELLIARMUS, juan.spellCast.getSpell(0));
    }

    @Test
    public void hasSpell__true() {
        juan.spellCast.addSpell(SpellType.EXPELLIARMUS);
        assertEquals(SpellType.EXPELLIARMUS, juan.spellCast.hasSpell(SpellType.EXPELLIARMUS));
    }
    @Test
    public void hasSpell__false() {
        assertNull(juan.spellCast.hasSpell(SpellType.EXPELLIARMUS));
    }

    @Test
    public void canCalculateHpAfterHit() {
        juan.spellCast.addSpell(SpellType.WINGARDIUM_LEVIOSA);
        SpellType spell = juan.spellCast.getSpell(0);
        juan.spellCast.startCastingSpell(spell, zsolt);
        assertEquals(15, zsolt.getHealthPoints());
    }
    @Test
    public void canCalculateHpAfterHit_dead() {
        zsolt.spellCast.addSpell(SpellType.WINGARDIUM_LEVIOSA);
        SpellType spell = zsolt.spellCast.getSpell(0);
        zsolt.spellCast.startCastingSpell(spell, juan);
        assertEquals(0, juan.getHealthPoints());
    }
    @Test
    public void canAddPet() {
        zsolt.setPet(robert);
        assertEquals(robert, zsolt.getPet());
    }
    @Test
    public void canRemovePet() {
        zsolt.setPet(robert);
        assertEquals(robert, zsolt.getPet());
        zsolt.removePet();
        assertNull(zsolt.getPet());
    }
    @Test
    public void removesPetWhenDead() {
        juan.spellCast.addSpell(SpellType.EXPELLIARMUS);
        zsolt.setPet(robert);
        for (int i = 0; i < 10; i++) {
            juan.spellCast.startCastingSpell(SpellType.EXPELLIARMUS, robert);
        }
        assertNull(zsolt.getPet());
    }
}
