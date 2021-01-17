package Entity.mythicalcreatures;

import Entity.Enums.CharacterClass;
import Entity.Enums.Weapon;
import Entity.Magic;
import Entity.Melee;
import behaviour.IMythicalCreature;
import rooms.Room;

public class Ogre extends Melee implements IMythicalCreature {

    Magic owner;
    Room room;

    public Ogre(String name, Weapon rightHandWeapon, int healthPoints, CharacterClass characterClass, Weapon leftHandWeapon) {
        super(name, rightHandWeapon, healthPoints, characterClass, leftHandWeapon);
    }

    public void setAsPet(Magic magic) {
        this.owner = magic;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void removeSelfFromRoom() {
        if(this.room != null)
        this.room.removeEnemy(this);
    }

    @Override
    public void takeDamage(int attackPoints) {
        if (this.healthPoints - attackPoints > 0) {
            this.healthPoints -= attackPoints;
        } else {
            this.healthPoints = 0;
            if(owner != null) {
                this.owner.removePet();
            }
            removeSelfFromRoom();
        }
    }
}
