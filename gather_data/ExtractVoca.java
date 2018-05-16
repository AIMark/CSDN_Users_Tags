package gather_data;
//统计总词数
import java.io.*;
import java.util.*;

public class ExtractVoca {
	private static Map<String, Integer> vocdmap = new HashMap<>();//存储词和频率
	private static Map<String, Integer> tycmap = new HashMap<>();//停用词Map
	private static String pathread = "E:\\科研训练\\用户画像\\testwen\\tag42分词\\";//读取文件的父地址
	private static String []  filename = new String[42];//要读取的42个标签文档地址
	private static String []  tag = { "web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
			"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
			"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
			"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };//42个标签
	//private static int []  tagnum = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
			//311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
		//	1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
			//465, 142,270, 223,14, 787, 116 };//42个标签文档的行数 共27352行
	public static void puttymap() throws IOException {
		FileInputStream inputStream = new FileInputStream("F:\\软件安全下载目录\\idocdown-v3.2.1\\Fish-v321\\kpdf\\哈工大停用词表fen.txt");
		Scanner sc = new Scanner(inputStream, "GB2312");
		
		while(sc.hasNextLine()) {
			String [] linline =sc.nextLine().split(",");
			for(int i=0;i<linline.length;i++) {
				tycmap.put(linline[i], 1);
			}
		}
		tycmap.put("/nx", 1);
		sc.close();
	}
	public static void main(String[] args) throws IOException {
		puttymap();
		FileInputStream inputStream = null;
		Scanner sc = null;
		//File file = new File("F:\\软件安全下载目录\\idocdown-v3.2.1\\Fish-v321\\kpdf\\哈工大停用词表fen.txt");
		
		//BufferedReader reader = new BufferedReader (new FileReader(file));
		PrintWriter fw = null;
		//创建保存文件路径
		for (int i = 0; i < 42; i++) {
			filename[i] = pathread + tag[i] + ".txt";// 读取文件父路径+名称+文件类型 
			
		}
		long zongnu =0;
		long zongnu1=0;
		//对42个文档读取次数
		for (int tagnu = 0; tagnu < 42; tagnu++) {
			try
			{
				inputStream = new FileInputStream(filename[tagnu]);
				sc = new Scanner(inputStream);
				fw = new PrintWriter("E:\\科研训练\\用户画像\\testwen\\vocdmap.txt");
				while (sc.hasNextLine()) {//判断还有没有下一句
					String[] linelab = sc.nextLine().split("\\,");
					
					
			
					/*for (int linenu= 8; linenu < linelab.length; linenu++) {
						System.out.println(linelab[linenu]);
					}
			
		}
	}
}*/

					for (int linenu= 8; linenu < linelab.length; linenu++) {
						if((linelab[linenu].length()==0)||(linelab[linenu].indexOf("w")>0)||(tycmap.get(linelab[linenu])!=null)) {
							//System.out.println(linelab[linenu]);
							//linenu++;
						}
						else {
							if((vocdmap.get(linelab[linenu])==null)) {
								vocdmap.put(linelab[linenu],1);	
								zongnu++;
							}
							else {
								vocdmap.put(linelab[linenu],vocdmap.get(linelab[linenu])+1);	
								//zongnu++;
							}
						}
						
					}
					//fw.println(HanLP.segment(sc.nextLine()));
				//}
				//if (sc.ioException() != null) {
					//throw sc.ioException();
				//}
			}
			}
			finally{
				
			}
		}
		Iterator ii = vocdmap.keySet().iterator();
	      while (ii.hasNext()) {
	        String word = ii.next().toString();
	        int num =vocdmap.get(word);
	        fw.println(word + "|" + num);
	        zongnu1++;
	      }
	      System.out.println("总数1："+zongnu);
	      System.out.println("Hasmap："+zongnu1);
		inputStream.close();
		sc.close();
		fw.close();							
	}
	
}