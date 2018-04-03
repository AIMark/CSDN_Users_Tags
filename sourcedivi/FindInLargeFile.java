package sourcedivi;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//高亭学长写的代码
public class FindInLargeFile {

    public static String FILE_PATH = "E:\\科研训练\\用户画像\\SMPCUP2017数据集\\1_BlogContent.txt";

    public static void main(String[] args) {
        //FindInLargeFile.FILE_PATH = "data/blogContent.txt";
       Map<String, String> map = new HashMap<>();
      String OBJECT_FILE = "E:\\科研训练\\用户画像\\testwen\\字节Map\\BitMapgaot.txt";


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
            String[] split = map.get("D0777585").split("_");
            long lineStart = Long.parseLong(split[0]);
            long lineEnd = Long.parseLong(split[1]);
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_PATH, "r")) {
                randomAccessFile.seek(lineStart);
                byte[] bytes = new byte[(int) (lineEnd - lineStart + 1)];
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = randomAccessFile.readByte();
                }
                System.out.println(new String(bytes).split("\u0001")[2]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }


