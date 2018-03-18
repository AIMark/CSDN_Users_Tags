package sourcedivi;
//高亭学长写的代码
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author INotWant.
 */
public class HashMap180318 {

    public static String FILE_PATH = "data/largeFile.txt";


    /**
     * every find start again
     */
   /* public static class OrderFind implements Find {

        @Override
        public String findContent(String label) {
            String content = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] split = line.split("\u0001");
                    if (label.equals(split[0]))
                        return split[1];
                    line = reader.readLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        }
    }*/

    public static class FindUseMap implements Find {

        private Map<String, String> map = new HashMap<>();
        private final static String OBJECT_FILE = "data/map";

        //@SuppressWarnings("unchecked")
        //@Override
        public String findContent(String label) {
            // if size of map equal 0, initialize map
            // map save the start byte of line and the end byte of line for label
            File objectFile = new File(OBJECT_FILE);
            if (objectFile.exists() && map.size() == 0) {
                //long startTime = System.currentTimeMillis();
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile))) {
                    map = (Map<String, String>) ois.readObject();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //long endTime = System.currentTimeMillis();
                //System.out.println("load ::" + (endTime - startTime) / 1000.);
            }
            if (map.size() == 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
                     ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OBJECT_FILE))) {
                    String line = reader.readLine();
                    long lineStart = 0;
                    while (line != null) {
                        long lineEnd = lineStart + line.getBytes().length - 1;
                        String[] split = line.split("\u0001");
                        map.put(split[0], String.valueOf(lineStart) + "_" + String.valueOf(lineEnd));
                        lineStart = lineEnd + 3;
                        line = reader.readLine();
                    }
                    oos.writeObject(map);
                  
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            // find label in map
            String[] split = map.get(label).split("_");
            long lineStart = Long.parseLong(split[0]);
            long lineEnd = Long.parseLong(split[1]);
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_PATH, "r")) {
                randomAccessFile.seek(lineStart);
                byte[] bytes = new byte[(int) (lineEnd - lineStart + 1)];
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = randomAccessFile.readByte();
                }
                return new String(bytes).split("\u0001")[1];
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

   }