import Entity.Cleric;
import Entity.Enums.CharacterClass;
import Entity.Enums.SpellType;
import Entity.Enums.Weapon;
import Entity.Magic;
import Entity.Melee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Magic juan;
    Cleric john;
    Melee colin;

    @Before
    public void setUp(){
        juan = new Magic("Juan", Weapon.BIG_STAFF, 4, CharacterClass.WARLOCK, null, null);
        john = new Cleric("John", Weapon.STICK, 15, CharacterClass.CLERIC, null);
        colin = new Melee("Colin", Weapon.CRAP_AXE, 10, CharacterClass.BARBARIAN, Weapon.CRAP_AXE);
    }

    @Test
    public void canHealWithSpell(){
        john.spellCast.addSpell(SpellType.HEALIARMUS);
        john.startHitting(colin);
        john.startHitting(colin);
        assertEquals(4, colin.getHealthPoints());
        john.spellCast.startCastingSpell(SpellType.HEALIARMUS, colin);
        assertEquals(8, colin.getHealthPoints());
    }
}
