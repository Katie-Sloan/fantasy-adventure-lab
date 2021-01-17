package behaviour;
import Player.PlayerController;

public class Move implements IAction {

    PlayerController controller;
    private int positionX;
    private int positionY;
    public Move(PlayerController controller) {
        this.controller = controller;
        positionX = 50;
        positionY = 50;
    }

    public void setAction() {
        controller.setCurrentAction(this);
    }

    public void stopAction() {

    }

    public void moveUp() {
        if(positionY == 100) return;
        positionY++;
    }
    public void moveDown() {
        if(positionY == 0) return;
        positionY--;
    }
    public void moveRight() {
        if(positionX == 100) return;
        positionX++;
    }
    public void moveLeft() {
        if(positionX == 0) return;
        positionX--;
    }
}
//    x,y
// 0,0 0,1 0,2
// 1,0 1,1 1,2
// 2,0 2,1 2,2
//
//
//
//
//
//
//
//
