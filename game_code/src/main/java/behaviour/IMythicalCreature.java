package behaviour;

import Entity.Magic;
import rooms.Room;

public interface IMythicalCreature  {

    void takeDamage(int attackPoints);

    void setAsPet(Magic magic);

    void setRoom(Room room);

    void removeSelfFromRoom();
}
