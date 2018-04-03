package sourcedivi;
//排除42个 词频文档 中的 不可用数据
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class te180312 {
	private static String pathwrt = "E:\\科研训练\\用户画像\\testwen\\42文档词数\\";
	private static HashMap<Object,Integer> four_tag_map= new HashMap<>();
	private static String []  tag = {"web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
			"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
			"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
			"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };
	private static String []  filename11 = new String[42];//42个文件地址
	public static void main(String[] args) {
		for (int i = 0; i < 42; i++) {
			filename11[i] = pathwrt + tag[i] + ".txt";// 读取文件父路径+名称+文件类型 
			
		}
		FileInputStream inputStream = null;
		Scanner sc = null;
		 for (int tagnu = 0; tagnu < 42; tagnu++) {
             try {
				inputStream = new FileInputStream(filename11[tagnu]);
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
				sc = new Scanner(inputStream);
				
				while (sc.hasNextLine()) {//判断还有没有下一句
					String[] linelab = sc.nextLine().split("\\|");
					//System.out.println(linelab[0]+"|"+Integer.valueOf(linelab[1])+"   "+tag[tagnu]);
					four_tag_map.put(linelab[0],Integer.valueOf(linelab[1]));	
				}
				sc.close();
	}
}
}
