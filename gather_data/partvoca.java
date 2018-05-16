package gather_data;//本程序对单个文档分词
import java.util.*;
import com.hankcs.hanlp.HanLP;
import java.io.*;
public class partvoca {
	/*private static String []  tag = { "web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
			"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
			"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
			"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };//42个标签
	private static String []  filename = new String[42];//存储要读取的42个标签文档地址
	private static String []  filenameout = new String[42];//存储要写出的42个标签文档名称地址
	private static String path = "E:\\科研训练\\用户画像\\tag42\\";//读取42个标签文档的父地址
	private static String pathout = "E:\\科研训练\\用户画像\\testwen\\tag42分词\\";//输出42个标签文档的父地址
	*/
		public static void main(String[] args) throws IOException {
			//
			FileInputStream inputStream = null;
			Scanner sc = null;
			
			PrintWriter fw = null;
			//创建保存文件路径
			/*for (int i = 0; i < 42; i++) {
				filename[i] = path + tag[i] + ".txt";// 读取文件父路径+名称+文件类型 
				filenameout[i] = pathout + tag[i] + ".txt";// 写出文件父路径+名称+文件类型
			}*/
			
			//对42个文档分词
			//for (int i = 0; i < 42; i++) {
			//File file = new File("F:\\软件安全下载目录\\idocdown-v3.2.1\\Fish-v321\\kpdf\\哈工大停用词表.txt");
			//BufferedReader reader = new BufferedReader (new FileReader(file));
			fw = new PrintWriter("F:\\软件安全下载目录\\idocdown-v3.2.1\\Fish-v321\\kpdf\\哈工大停用词表fen.txt");
			
				//try
				//{
					inputStream = new FileInputStream("F:\\软件安全下载目录\\idocdown-v3.2.1\\Fish-v321\\kpdf\\哈工大停用词表.txt");
					sc = new Scanner(inputStream, "GB2312");
			//String li =null;
			//while ((li=reader.readLine())!=null) {
					//System.out.println(//reader.read());
			
					
					while (sc.hasNextLine()) {//判断还有没有下一句
						fw.println(HanLP.segment(sc.nextLine()));
			}
					//}
					//if (sc.ioException() != null) {
						//throw sc.ioException();
					//}
				//}
				//finally{
					
				//}
			//}
			inputStream.close();
			sc.close();
					//reader.close();
			fw.close();							
		//}
		
}
}






