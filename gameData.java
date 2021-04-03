import java.io.*;

/**
 * Including reading new board, load game, save game
 * Save under /data/
 * Space, 0 available move, 1-4 players 1-4,5 barricade, 9 goal
 */
public class gameData {

    public static char[][] map = new char[16][17];
    public static String[] playerColor = new String[4];
    public static String[] playerShape = new String[4];
    public static int currentPlayer;

    private static String mapPath = gameData.class.getResource("/data/map.txt").getPath();

    /**
     * read new game
     */
    public static void newGame(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(mapPath)));
            int row = 0;
            String str;
            while ((str=reader.readLine())!=null) {
                for (int i = 0; i < map[0].length; i++) {
                    map[row][i] = str.charAt(i);
                }
                row ++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] colors = {"BLUE","RED","GREEN","YELLOW"};
        for (int i = 0; i < colors.length; i++) {
            playerColor[i] = colors[i];
        }
        String[] shapes = {"King","Knight","Rook","Bishop"};
        for (int i = 0; i < shapes.length; i++) {
            playerShape[i] = shapes[i];
        }
        currentPlayer = 1;
    }

    /**
     * load game save from file(default in data/save.txt)
     * @return true if read file and resolve data correctly
     */
    public static boolean loadGameData(){

        String savePath = mapPath.replace("map.txt", "save.txt");
        File loadFile = new File(savePath);
        if(!loadFile.exists()){
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(loadFile));
            for (int i = 0; i < map.length; i++) {
                String rowString = reader.readLine();
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = rowString.charAt(j);
                }
            }
            String[] colors = reader.readLine().split(",");
            for (int i = 0; i < colors.length; i++) {
                playerColor[i] = colors[i];
            }
            String[] shapes = reader.readLine().split(",");
            for (int i = 0; i < shapes.length; i++) {
                playerShape[i] = shapes[i];
            }
            currentPlayer = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (Exception e) {//resolve data file occur error
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * save game
     * @return true if save done, return false when error occurs
     */
    public static boolean saveGameData(){
        try {
            String savePath = mapPath.replace("map.txt", "save.txt");
            File saveFile = new File(savePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    writer.write(map[i][j]);
                }
                writer.write('#');
                writer.write('\n');
            }
            writer.write(String.join("," ,playerColor) + "\n");
            writer.write(String.join("," ,playerShape) + "\n");
            writer.write(currentPlayer + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
