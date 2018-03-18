package sourcedivi;

//用NB进行验证集测试
import java.util.*;
import com.hankcs.hanlp.HanLP;

import java.io.*;
public class te180318 {
	private static Map<String, String> postmap = new HashMap<>();//存储用户对应发表的博客编号HashMap
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
	}
	public static void main(String [] args)throws IOException {
		//satbitmap();
		//satpostmap();
		//读取验证集
		FileInputStream traindatainpu = null;
		Scanner traindataout = null;
		PrintWriter fw =  new PrintWriter("E:\\科研训练\\用户画像\\testwen\\tes.txt","UTF-8");
		traindatainpu = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\字节Map\\BitMap1.txt");
		traindataout = new Scanner(traindatainpu);
		//读取测试集并查找对应博客，处理比较
		//String blogline =null;
		//String strlin =null;
		long lineStart=0;
		long lineEnd =0;
		long zhongjain =0;
		int num = 0;
		//int i = 0;
		//while(traindataout.hasNextLine()&&i<1) {
			
			//String [] argsblogli = traindataout.nextLine().split("");//验证集用户加上三个兴趣
			//if(postmap.get(argsblogli[0])==null) {
			//	System.out.println("文档中无用户编号为"+argsblogli[0]+"发表的博客，所以无法预测此用户兴趣");
			//}
			//else {
			//System.out.println(blogline);
		while(++num<10000) {
		  ////blogline = traindataout.nextLine();
			String [] split = traindataout.nextLine().split("_");//用户发表的所有博客
			//for(int postnum=0;postnum<strpostnu.length;postnum++) {
				//String[] split = (bittmap.get("D0098736")).split("_");
				lineStart = Long.parseLong(split[1]);
		        lineEnd = Long.parseLong(split[2]);
		        zhongjain =lineEnd - lineStart;
		        try (RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\科研训练\\用户画像\\SMPCUP2017数据集\\1_BlogContent.txt", "r")) {
		            randomAccessFile.seek(lineStart);
		            //System.out.println(lineStart);
		            byte[] bytes = new byte[(int) (zhongjain + 1)];
		            for (int niui = 0; niui < bytes.length; niui++) {
		                bytes[niui] = randomAccessFile.readByte();
		            }
		            //new String(randomAccessFile.readline().getBytes("ISO-8859-1", "utf-8")
		            //strlin += new String(bytes);
		            //System.out.println(new String(bytes));
		            String linsd = new String(bytes);
		            //linsd.getBytes(),"utf-8");
		            //fw.println(linsd);
		           fw.println(new String(linsd.getBytes(),"UTF-8"));
		           //System.out.println(1);"开始"+lineStart+"结束"+lineEnd+"距离"+zhongjain+"文章"+
		        } 
		        
			//}
			//strlin = String.valueOf(HanLP.segment(strlin));
			
			//}
			//i++;
		}
	     // find label in map
      
      
      
    
		fw.close();
		traindatainpu.close();
		traindataout.close();
		
	}
}

