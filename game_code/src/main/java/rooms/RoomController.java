package rooms;

import Entity.Entity;

import java.util.ArrayList;

public class RoomController {
    int currentRoomIndex;
    private ArrayList<Room> rooms;
    Entity player;
    public Room currentRoom;
    private boolean allLevelsCompleted;

    public RoomController(Entity player) {
        allLevelsCompleted = false;
        this.player = player;
        currentRoomIndex = 0;
        this.rooms = new ArrayList<Room>();
    }

    public void start() {
        if (!(this.rooms.size() > 0)) return;
        rooms.get(0).addPlayer(player);
        currentRoom = rooms.get(0);
        System.out.println(currentRoom.message);
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentRoomIndex() {
        return this.rooms.indexOf(currentRoom);
    }

    public int getRoomCount() {
        return this.rooms.size();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public Room getRoom(int indexPosition) {
        if (indexPosition >= (this.rooms.size())) return null;
        return this.rooms.get(indexPosition);
    }
    public void changeRoom(Room room) {
        if(rooms.size() == rooms.indexOf(room) + 1) {
            System.out.println("Well done, you've completed the Potter Cave");
            allLevelsCompleted = true;
            return;
        }
        currentRoomIndex = rooms.indexOf(room) + 1;
        rooms.get(rooms.indexOf(room)).removePlayer();
        setPlayersNewRoom(currentRoomIndex);
        currentRoom = rooms.get(currentRoomIndex);
        System.out.println(currentRoom.message);
        //get the index of the room passed in
    }

    private void setPlayersNewRoom(int currentRoomIndex) {
        rooms.get(currentRoomIndex).addPlayer(player);
    }

    public boolean areAllLevelsCompleted() {
        return this.allLevelsCompleted;
    }
}
