/*package gather_data;
import java.util.*;
import java.io.*;

	public class Condprob {
		public static int V = 190879;//词汇表大小
		public static int N = 27352;//训练集合中的文档总数
		private static double [] prior = new double [42];//prior[i]=Nc/N先验概率
		private static String []  filename11 = new String[42];//42个文件地址
		private static String pathwrt = "E:\\科研训练\\用户画像\\testwen\\42文档词数\\";
		private static String []  tag = {"web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
				"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
				"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
				"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };
		
		private static HashMap<Object,Integer> four_tag_map= new HashMap<>();//42个文档读取存入的hash
		private static HashMap<Object,Integer> vocall_map= new HashMap<>();//总词数存入的hash
			
		private static int []  Nc = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
				311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
				1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
				465, 142,270, 223,14, 787, 116 };//42个标签文档的行数 共27352行
		private static int [] tag_num = new int[42];//42个文档的 词数
		
		public static void main (String [] args) throws Exception {
			String [] beiylab = new String[190880];

			PrintWriter fw = null;
			FileInputStream inputStream = null;
			Scanner sc = null;
			
			FileInputStream inputSt = null;
			Scanner scc = null;

			for(int i=0;i<42;i++) {
				prior[i] = Nc[i] / N ;
			}
			for (int i = 0; i < 42; i++) {
				filename11[i] = pathwrt + tag[i] + ".txt";// 读取文件父路径+名称+文件类型 
				
			}
			 // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
	             String tag_vocd_numname = "E:\\科研训练\\用户画像\\testwen\\42tag_vocd_num.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
	             File filename = new File(tag_vocd_numname); // 要读取以上路径的txt文件  
	             InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
	             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	             String line = "";  

	             for(int i=0;i<42;i++){  
	                 line = br.readLine(); // 一次读入一行数据  
	                 String [] linne = line.split("\\|");
	                 tag_num[i] = Integer.valueOf(linne[1]);       
	             }
	             reader.close();
	             br.close();
	             
	             //写入总文件数到hashmap

			     inputStream = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\vocdmap.txt");
				 sc = new Scanner(inputStream, "GB2312");
				 
				 
			     while (sc.hasNextLine()) {//判断还有没有下一句
						String[] linelab = sc.nextLine().split("\\|");

						vocall_map.put(linelab[0],Integer.valueOf(linelab[1]));				
							}
			     
			     inputStream.close();
			     sc.close();
			     //写入分文件数到 Hashmap
	             for (int tagnu = 0; tagnu < 42; tagnu++) {
	            	
	             inputStream = new FileInputStream(filename11[tagnu]);
					sc = new Scanner(inputStream, "GB2312");
					
					while (sc.hasNextLine()) {//判断还有没有下一句
						String[] linelab = sc.nextLine().split("\\|");

						four_tag_map.put(linelab[0],Integer.valueOf(linelab[1]));	
					}

					int kk=0;
					double nudum=0.0;
					double acnu =0.0;
					inputSt = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\vocdmap.txt");
				    scc = new Scanner(inputSt, "GB2312");
					fw = new PrintWriter("E:\\科研训练\\用户画像\\testwen\\condprob.txt");

					while(scc.hasNextLine()) {
						String[] linelaab = scc.nextLine().split("\\|");
						if((four_tag_map.get(linelaab[0]))!=null)
						{
						nudum = four_tag_map.get(linelaab[0]);
						}
						acnu = (nudum+1)/(Nc[tagnu]+190879);
						
						if((beiylab[kk]!=null)) {
						fw.println(beiylab[kk]+"|"+acnu);
						beiylab[kk] = beiylab[kk]+"|"+acnu;
						}
	
						else {
							fw.println(linelaab[0]+"|"+acnu);
							beiylab[kk] = linelaab[0]+"|"+acnu;

						}
						kk++;
					}

					four_tag_map.clear();
					
	             inputStream.close();
	             sc.close();
	             
	             inputSt.close();
	             scc.close();	                
	             fw.close();
		}
		
	}	
}

*/
package gather_data;
//计算42文档相对概率
	import java.util.*;
	import java.io.*;
	public class Condprob {
		public static int V = 190868;//词汇表大小
		public static int N = 27352;//训练集合中的文档总数
		private static double [] prior = new double [42];//prior[i]=Nc/N先验概率
		private static String []  filename11 = new String[42];//42个文件地址
		private static String []  writfilename11 = new String[42];//写的42个文件地址
		private static String pathwrt = "E:\\科研训练\\用户画像\\testwen\\42文档词数\\";
		private static String wrtpath = "E:\\科研训练\\用户画像\\testwen\\42文档先验概率\\";
		private static String []  tag = {"web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
				"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
				"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
				"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };
		
		private static HashMap<Object,Integer> four_tag_map= new HashMap<>();//42个文档读取存入的hash
		private static HashMap<Object,Integer> vocall_map= new HashMap<>();//总词数存入的hash
			
		private static int []  Nc = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
				311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
				1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
				465, 142,270, 223,14, 787, 116 };//42个标签文档的行数 共27352行
		private static int [] tag_num = new int[42];//42个文档的 词数
		
		public static void main (String [] args) throws Exception {
			PrintWriter fw = null;
			FileInputStream inputStream = null;
			Scanner sc = null;
			FileInputStream inputSt = null;
			Scanner scc = null;
			for(int i=0;i<42;i++) {
				prior[i] = Nc[i] / N ;
			}
			for (int i = 0; i < 42; i++) {
				filename11[i] = pathwrt + tag[i] + ".txt";// 读取文件父路径+名称+文件类型 
				writfilename11[i] = wrtpath + tag[i] + ".txt";
				
			}
			 // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
 
	             String tag_vocd_numname = "E:\\科研训练\\用户画像\\testwen\\42tag_vocd_num.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径  
	             File filename = new File(tag_vocd_numname); // 要读取以上路径的txt文件  
	             InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
	             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
	             String line = "";  
	             //line = br.readLine();  
	             for(int i=0;i<42;i++){  
	                 line = br.readLine(); // 一次读入一行数据  
	                 String [] linne = line.split("\\|");
	                 tag_num[i] = Integer.valueOf(linne[1]);       
	             }
	             reader.close();
	             br.close();
	             
	             //写入总文件数到hashmap

			     inputStream = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\vocdmap.txt");
				 sc = new Scanner(inputStream);
				 
				 
			     while (sc.hasNextLine()) {//判断还有没有下一句
						String[] linelab = sc.nextLine().split("\\|");
						//System.out.println(linelab[0]+"|"+Integer.valueOf(linelab[1]));
						vocall_map.put(linelab[0],Integer.valueOf(linelab[1]));				
							}
			     
			     inputStream.close();
			     sc.close();
			     //写入分文件数到 Hashmap
	             for (int tagnu = 0; tagnu < 42; tagnu++) {
	            	
	             inputStream = new FileInputStream(filename11[tagnu]);
					sc = new Scanner(inputStream);
					
					while (sc.hasNextLine()) {//判断还有没有下一句
						String[] linelab = sc.nextLine().split("\\|");
						four_tag_map.put(linelab[0],Integer.valueOf(linelab[1]));	
					}
					
					double nudum=0.0;
					double acnu =0.0;
					inputSt = new FileInputStream("E:\\科研训练\\用户画像\\testwen\\vocdmap.txt");
				    scc = new Scanner(inputSt);
					fw = new PrintWriter(writfilename11[tagnu]);
					
					while(scc.hasNextLine()) {
						String[] linelaab = scc.nextLine().split("\\|");
						if((four_tag_map.get(linelaab[0]))!=null)
						{
						nudum = four_tag_map.get(linelaab[0]);
						acnu = (nudum+1)/(Nc[tagnu]+190879);
						}
							else {
								acnu=0;
							}
						
						fw.println(linelaab[0]+"+"+acnu);
					}

					four_tag_map.clear();
					
	             inputStream.close();
	             sc.close();         	             
	             inputSt.close();
	             scc.close();

	             
	             fw.close();
            	             
		}
	
	}
	}

