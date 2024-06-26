package Logic;

import Units.Unit;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private int armorUp;
    private int attackUp;
    private int healthUp;
    private float moveUp;
    private float fineUp;
    transient ArrayList<Unit> Units = new ArrayList<>();
    Player() {
        armorUp = 0;
        attackUp = 0;
        healthUp = 0;
        moveUp = 0;
        fineUp = 0;
    }
    public void init()
    {
        Units = new ArrayList<>();
    }
    public void remUp(int num) {
        switch (num) {
            case 0: { //Lab
                healthUp = 0;
                break;
            }
            case 1: { //Tavern
                moveUp = 0;
                fineUp = 0;
                break;
            }
            case 2: {  //Forge
                armorUp = 0;
                break;
            }
            case 3: { //Arsenal
                attackUp = 0;
                break;
            }
            default: {
                break;
            }
        }
    }
    public void addUnit(Unit unt)
    {
        Units.add(unt);
    }
    public ArrayList<Unit> getUnits() {
        return Units;
    }

    public int getArmorUp() {
        return armorUp;
    }
    public int getAttackUp() {
        return attackUp;
    }
    public int getHealthUp() {
        return healthUp;
    }
    public float getMoveUp() {
        return moveUp;
    }
    public float getFineUp() {
        return fineUp;
    }

    public void setArmorUp(int armorUp) {
        this.armorUp = armorUp;
    }
    public void setAttackUp(int attackUp) {
        this.attackUp = attackUp;
    }
    public void setHealthUp(int healthUp) {
        this.healthUp = healthUp;
    }
    public void setMoveUp(float moveUp) {
        this.moveUp = moveUp;
    }
    public void setFineUp(float fineUp) {
        this.fineUp = fineUp;
    }
}
