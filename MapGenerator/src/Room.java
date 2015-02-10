import java.io.Serializable;

/**
 * Created by starr_000 on 10/10/2014.
 */

public class Room implements java.io.Serializable{
    private int value;
    private char key;
    private int[] position;

    public Room(int value, char key) {
        this.value = value;
        this.key = key;
    }

//    Instantiating it without params will create a 'Normal' Room
    public Room() {
        this.value = 1;
        this.key = 'N';
    }

    public void setValue(int val) {
        value = val;
    }
    public void setKey(char k) {
        key = k;
    }
    public void setPosition(int[] pos) { position = pos; }
    public int getValue() {
        return value;
    }
    public char getKey() {
        return key;
    }
    public int[] getPosition() { return position; }
}
