import Player.Cleric;
import Player.Enums.CharacterClass;
import Player.Enums.SpellType;
import Player.Enums.Weapon;
import Player.Magic;
import Player.Melee;
import org.junit.Before;
import org.junit.Test;

public class ClericTest {

    Magic juan;
    Cleric john;
    Melee colin;

    @Before
    public void setUp(){
        juan = new Magic("Juan", Weapon.BIG_STAFF, 4, CharacterClass.WARLOCK, null);
        john = new Cleric("John", Weapon.STICK, 15, CharacterClass.CLERIC, null);
        colin = new Melee("Colin", Weapon.CRAP_AXE, 10, CharacterClass.BARBARIAN, Weapon.CRAP_AXE);
    }

    @Test
    public void canHealWithSpell(){
        john.spellCast.addSpell(SpellType.HEALIARMUS);

    }

}
