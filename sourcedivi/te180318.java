package sourcedivi;

//测试 收集测试集 文档 的测试程序
import java.util.*;
import java.io.*;
public class te180318 {
	/*private static Map<String, String> postmap = new HashMap<>();//存储用户对应发表的博客编号HashMap
	private static Map<String, String> bittmap = new HashMap<>();//存储句首和句尾位置的HashMap
	
	//建立存储句首和句尾的HashMap
	public static void satbitmap() throws IOException{
		try {
			String bittmapline;
			FileInputStream bittmapblog = null;
			Scanner bittmapscan = null;
			bittmapblog = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\字节Map\\BitMap1.txt");
			bittmapscan = new Scanner(bittmapblog);
			int num=0;
			while (((++num <1000001)  &&((bittmapline = bittmapscan.nextLine()) != null)  ) ) {					
				if(bittmap.get(bittmapline.substring(0, 8))==null) {
					bittmap.put(bittmapline.substring(0, 8),bittmapline.substring(9, bittmapline.length()));	
				}
			}			
			bittmapblog.close();
			bittmapscan.close();
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
							
		}
	}
	
	//建立存储存储用户对应发表的博客编号HashMap(一个用户对应多篇文档)
	public static void satpostmap() throws IOException{
		try {
			String postmapline;
			FileInputStream postmapblog = null;
			Scanner postmapscan = null;
			postmapblog = new FileInputStream("E:\\科研训练\\用户画像\\SMPCUP2017数据集\\2_Post.txt");
			postmapscan = new Scanner(postmapblog);
			int num=0;
			while (((++num <1000001)  &&((postmapline = postmapscan.nextLine()) != null)  ) ) {					
				if(postmap.get(postmapline.substring(0, 8))==null) {
					postmap.put(postmapline.substring(0, 8),postmapline.substring(9, 17));	
				}
				else {
					postmap.put(postmapline.substring(0, 8), postmap.get(postmapline.substring(0, 8))+","+postmapline.substring(9, 17));
				}
				
				
			}			
			postmapblog.close();
			postmapscan.close();
		}catch (Exception e) {
			
				e.printStackTrace();
			} finally {
							
		}
	}*/
	public static void main(String [] args)throws IOException {

		FileInputStream traindatainpu = null;
		Scanner traindataout = null;
		
		traindatainpu = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\字节Map\\BitMap1.txt");
		traindataout = new Scanner(traindatainpu);
		//读取测试集并查找对应博客，处理比较

		long lineStart=0;
		long lineEnd =0;
		long zhongjain =0;
		int num = 0;
		//File file = new File("E:\\科研训练\\用户画像\\SMPCUP2017数据集\\1_BlogContent.txt");
		//BufferedReader reader = new BufferedReader(new FileReader(file));
		//BufferedReader有一个skip()方法，
		//reader.mark((int)file.length()+1);
		PrintWriter fw =  new PrintWriter("E:\\科研训练\\用户画像\\testwen\\tes11.txt","utf-8");
		while(++num<6) {
			//traindataout.nextLine();
			
			String [] split = traindataout.nextLine().split("_");//用户发表的所有博客
			
				lineStart = Long.parseLong(split[1]);
		        lineEnd = Long.parseLong(split[2]);
		        zhongjain =lineEnd - lineStart;
		        try (RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\科研训练\\用户画像\\SMPCUP2017数据集\\1_BlogContent.txt", "r")) {
		            randomAccessFile.seek(lineStart);
		            //System.out.println(lineStart);
		           //String[] bytes = new String[(int) (zhongjain + 1)];
		           byte[] bytes = new byte[(int) (zhongjain + 1)];
		          for (int niui = 0; niui < bytes.length; niui++) {		            	
		                //bytes[niui] = randomAccessFile.readUTF();
		            	bytes[niui] = randomAccessFile.readByte();
		               // System.out.println(String.valueOf(bytes[niui]));
		            }
		           //reader.skip(lineStart);
		           //fw.println(reader.readLine());
		           //reader.reset();
		           //String kik =   reader.readLine();
		           //kik=kik.getBytes("ISO-8859-1"),"utf-8"));
		           //System.out.println(kik);
		           //reader.reset();
		        
		            String linsd = new String(bytes);
		            //String kkk = new String(linsd.getBytes("ISO-8859-1"),"utf-8");
		            //System.out.println(String.valueOf(bytes));
		            
		            		//bytes.toString();  
		           // System.out.println(new String(linsd.getBytes("ISO-8859-1"),"utf-8"));
		         
		            fw.println(new String(linsd));
		          //System.out.println(new String(linsd.getBytes("ISO-8859-1"),"utf-8"));
		          //System.out.println(kkk);
		           
		           //fw.printf(new String(randomAccessFile.readLine().getBytes("8859-1"),"utf-8"));

		        } 

		
	     // find label in map
      
      
      
   // reader.close();
		
		
		
	}
		fw.close();
		traindatainpu.close();
		traindataout.close();
}
}
