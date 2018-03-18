package gather_data;
//��NB������֤�������ĵ��ռ�
import java.util.*;
import com.hankcs.hanlp.HanLP;

import java.io.*;
public class gather_test_date {
	private static Map<String, String> postmap = new HashMap<>();//�洢�û���Ӧ����Ĳ��ͱ��HashMap
	private static Map<String, String> bittmap = new HashMap<>();//�洢���׺;�βλ�õ�HashMap
	//private static Map<String, String> tagvactmap = new HashMap<>();//
	
	
	//�����洢���׺;�β��HashMap
	public static void satbitmap() throws IOException{
		try {
			String bittmapline;
			FileInputStream bittmapblog = null;
			Scanner bittmapscan = null;
			bittmapblog = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\�ֽ�Map\\BitMap1.txt");
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
	
	//�����洢�洢�û���Ӧ����Ĳ��ͱ��HashMap(һ���û���Ӧ��ƪ�ĵ�)
	public static void satpostmap() throws IOException{
		try {
			String postmapline;
			FileInputStream postmapblog = null;
			Scanner postmapscan = null;
			postmapblog = new FileInputStream("E:\\����ѵ��\\�û�����\\SMPCUP2017���ݼ�\\2_Post.txt");
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
		satbitmap();
		satpostmap();
		//��ȡ��֤��
		FileInputStream traindatainpu = null;
		Scanner traindataout = null;
		PrintWriter fw =  new PrintWriter("E:\\����ѵ��\\�û�����\\testwen\\tes.txt","utf-8");
		traindatainpu = new FileInputStream("E:\\����ѵ��\\�û�����\\SMPCUP2017����2ѵ����\\SMPCUP2017_TrainingData_Task2��֤��.txt");
		traindataout = new Scanner(traindatainpu);
		//��ȡ���Լ������Ҷ�Ӧ���ͣ�����Ƚ�
		//String blogline =null;
		String strlin =null;
		String linsd = null;
		long lineStart=0;
		long lineEnd =0;
		long zhongjain =0;
		//int i = 0;
		while(traindataout.hasNextLine()) {
			
			String [] argsblogli = traindataout.nextLine().split("");//��֤���û�����������Ȥ
			if(postmap.get(argsblogli[0])==null) {
				System.out.println("�ĵ������û����Ϊ"+argsblogli[0]+"����Ĳ��ͣ������޷�Ԥ����û���Ȥ");
				fw.println("noblog");
			}
			else {
			//System.out.println(blogline);
			String [] strpostnu = postmap.get(argsblogli[0]).split(",");//�û���������в���
			for(int postnum=0;postnum<strpostnu.length;postnum++) {
				String[] split = (bittmap.get(strpostnu[postnum])).split("_");
				lineStart = Long.parseLong(split[0]);
		        lineEnd = Long.parseLong(split[1]);
		        zhongjain =lineEnd - lineStart;
		        try (RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\����ѵ��\\�û�����\\SMPCUP2017���ݼ�\\1_BlogContent.txt", "r")) {
		            randomAccessFile.seek(lineStart);
		            //System.out.println(lineStart);
		            byte[] bytes = new byte[(int) (zhongjain + 1)];
		            for (int niui = 0; niui < bytes.length; niui++) {
		                bytes[niui] = randomAccessFile.readByte();
		            }
		             linsd = new String(bytes);
		             if(strlin!=null) {
		            strlin += new String(linsd.getBytes(),"UTF-8");
		             }
		             else {
		            	 strlin = new String(linsd.getBytes(),"UTF-8");
		             	}
		             }
		           //fw.println("��ʼ"+lineStart+"����"+lineEnd+"����"+zhongjain+"����"+linshil);
		           //System.out.println(1);
		        } 
		        
			
			strlin = argsblogli[0]+""+strlin;
			fw.println(strlin);
			strlin =null;
		}
			//i++;
		}
	     // find label in map
        
        
        
      
		fw.close();
		traindatainpu.close();
		traindataout.close();
		
	}
}
