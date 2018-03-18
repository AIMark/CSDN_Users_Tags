package sourcedivi;

import java.io.RandomAccessFile;

public class Seabit {
	public static void main (String [] args) {
		
	long fir = 3742435468;
	long end = 3742440537;
	long last= fir-end;
	try (RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\科研训练\\用户画像\\wen\\blogGB2312.txt", "r")) {
        randomAccessFile.seek(fir);
        byte[] bytes = new byte[(int) last + 1];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = randomAccessFile.readByte();
        }
        String str=new String(bytes);
        System.out.println(str);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
	}
