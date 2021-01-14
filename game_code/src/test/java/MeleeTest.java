import Player.Enums.CharacterClass;
import Player.Enums.Weapon;
import Player.Melee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeleeTest {
    Melee dwarf;

    @Before
    public void setUp() {
        dwarf = new Melee("Jeff", Weapon.AXE, 5, CharacterClass.DWARF, Weapon.BIG_AXE);
    }

    // test constructor
    @Test
    public void canGetName() {
        assertEquals("Jeff", dwarf.getName());
    }
    @Test
    public void canGetRightHandWeapon() {
        assertEquals(Weapon.AXE, dwarf.getRightHandWeapon());
    }
    @Test
    public void canGetLeftHandWeapon() {
        assertEquals(Weapon.BIG_AXE, dwarf.getLeftHandWeapon());
    }
    @Test
    public void canGetHealthPoints() {
        assertEquals(5, dwarf.getHealthPoints());
    }
    @Test
    public void isDwarfClass() {
        assertEquals(CharacterClass.DWARF, dwarf.getCharacterClass());
    }

    // weapon true and false
    @Test
    public void canEquipWeaponLeftHand__true() {
        dwarf.setLeftHandWeapon(Weapon.AXE);
        assertEquals(Weapon.AXE, dwarf.getLeftHandWeapon());
    }

    @Test
    public void canEquipWeaponLeftHand__false() {
        dwarf.setLeftHandWeapon(Weapon.STAFF);
        assertEquals(Weapon.BIG_AXE, dwarf.getLeftHandWeapon());
    }

    @Test
    public void canEquipWeaponRightHand__true() {
        dwarf.setRightHandWeapon(Weapon.BIG_AXE);
        assertEquals(Weapon.BIG_AXE, dwarf.getLeftHandWeapon());
    }
    @Test
    public void canEquipWeaponRightHand__false() {
        dwarf.setRightHandWeapon(Weapon.STAFF);
        assertEquals(Weapon.AXE, dwarf.getRightHandWeapon());
    }
    // test attack points
    @Test
    public void canCalculateAttackPoints() {
        assertEquals(9, dwarf.getAttackPoints());
    }

}
