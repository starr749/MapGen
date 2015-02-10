/**
 * Created by starr_000 on 10/10/2014.
 */
import java.util.ArrayList;
import java.util.Random;

public class Map {

    private final static int MAP_SIZE = 7;
    private int map[][];
    private Random numberGen;
    public ArrayList<Room> roomList = new ArrayList<Room>();

    public Map() {
        makeRooms();
        placeRooms();
    }

    public int[][] getMap() {
        return map;
    }

    private void placeRooms() {
        // Make sure roomList has been initialized
        if (roomList.size() == 0) {
            throw new IllegalArgumentException("roomList must have rooms");
        }
        // This is a nice cool square
        map = new int[MAP_SIZE][MAP_SIZE];

        for (Room room : roomList) {
            assignPosition(room);
        }
    }

    private void assignPosition(Room room) {
        int cord[] = randomCords(MAP_SIZE);
        if (map[cord[0]][cord[1]] == 0) {
            map[cord[0]][cord[1]] = room.getValue();
            room.setPosition(cord);
        } else {
            assignPosition(room);
        }
    }

    public void link_rooms() {

        // We want to pick a random room which will serve as a link to all the others
        numberGen = new Random();
        int index = numberGen.nextInt(roomList.size());
        int direction = numberGen.nextInt(2);
        Room linkRoom = roomList.get(index);

        for(Room destRoom: roomList) {
            draw_link(linkRoom.getPosition(), destRoom, direction);
        }
    }

    private void draw_link(int[] current_position, Room destination_room, int direction) {

        int[] dest_pos = destination_room.getPosition();
        // Get our x and y coordinates
        int x = current_position[0];
        int y = current_position[1];

        while( !((x == dest_pos[0]) && (y == dest_pos[1])) ) {
            if(map[x][y] == 0) {
                map[x][y] = 1;
            }
            // We can connect the rooms ones of two ways
            if(direction == 0) {
                if(x < dest_pos[0]) {
                    x += 1;
                }
                else if(x > dest_pos[0]) {
                    x -= 1;
                }
                else if(y < dest_pos[1]) {
                    y += 1;
                }
                else if(y > dest_pos[1]) {
                    y -= 1;
                }
            }
            else if (direction == 1) {
                if(y < dest_pos[1]) {
                    y += 1;
                }
                else if(y > dest_pos[1]) {
                    y -= 1;
                }
                else if(x > dest_pos[0]) {
                    x -= 1;
                }
                else if(x < dest_pos[0]) {
                    x += 1;
                }
            }
        }
    }


    private void makeRooms() {
        Room treasure = new Room(2, 'T');
        Room boss = new Room(3, 'B');
        Room key = new Room(4, 'K');
        Room start = new Room(5, 'S');

        roomList.add(treasure);
        roomList.add(boss);
        roomList.add(key);
        roomList.add(start);
    }

    public void printMap() {
        System.out.println('\n');
        for(int y = 0; y < MAP_SIZE; y++) {
            System.out.print("\n");
            for(int x = 0; x < MAP_SIZE; x++) {
                if (map[x][y] == 0) {
                    System.out.print(".   ");
                } else if(map[x][y] == 1) {
                    System.out.print("+   ");
                } else {
                    System.out.print(map[x][y] + "   ");
                }
            }
        }
    }

    public int[] randomCords(int max) {

        if (0 > max) {
            throw new IllegalArgumentException("Number must be larger than 0.");
        }

        int[] cord = new int[2];

        for (int i = 0; i < cord.length; i++) {
            Random random = new Random();
            long fraction = (long) (max * random.nextDouble());
            int randomNumber = (int) (fraction);
            cord[i] = randomNumber;
        }

        return cord;
    }

    public static int main() {
        return 1;
    }
}

