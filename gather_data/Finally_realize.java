package gather_data;
//多项式贝叶斯最终测试
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Finally_realize {
	private static String []  tag = { "web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
			"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
			"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
			"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };
	public static void main(String [] args) throws Exception{
		FileInputStream bittmapblog = new FileInputStream("E:\\科研训练\\用户画像\\wen\\tegailv.txt");
		Scanner bittmapscan = new Scanner(bittmapblog);
		String [][] hhStrings = new String[206][3];
		PrintWriter fw = new PrintWriter("E:\\科研训练\\用户画像\\wen\\zuizho.txt");
		String linshstr = null;
		
		//int [] hel = new int[42];
		int hwue =0;
		//int nnnmnm =0;
		while (bittmapscan.hasNext() ) {
			//System.out.println(hwue);
			linshstr = bittmapscan.nextLine();
			String [] arglinshstr = linshstr.split("_");
			double [][] woc = new double [42][2];
			for(int i=0;i<42;i++) {
				woc[i][0] = Double.valueOf(arglinshstr[i]);
				woc[i][1] = i;
				
			}
			int k =0;
			for(int j=0;j<41;j++) {
				k=j;
			for(int i =j;i<41;i++) {
				 
				if(woc[k][0]<woc[i+1][0]) {
					k=i+1;
					}
				}
			double temp1=woc[j][1];
			double temp =woc[j][0];
			woc[j][1]=woc[k][1];
			woc[j][0]=woc[k][0];
			woc[k][1]=temp1;
			woc[k][0]= temp;
			}
			for(int i=0;i<3;i++) {
				hhStrings[hwue][i]=tag[(int)(woc[i][1])];
				//System.out.println(hhStrings[hwue][i]);
				System.out.println(woc[i][0]);
			}
			hwue++;
		}
		bittmapblog.close();
		bittmapscan.close();
		FileInputStream mapblog = new FileInputStream("E:\\科研训练\\用户画像\\SMPCUP2017任务2训练集\\SMPCUP2017_TrainingData_Task2验证集.txt");
		Scanner tmapscan = new Scanner(mapblog,"utf-8");
		double pingce =0;
		int hwri=0;
		while (tmapscan.hasNext()) {
			//System.out.println(hwri);
			linshstr = tmapscan.nextLine();
			String [] argshstr = linshstr.split("");
			String hhhh=null;
			for(int i=0;i<3;i++) {
				for(int j=1;j<4;j++) {
					System.out.println(hhStrings[hwri][i]+"_"+argshstr[j]);
					if(hhStrings[hwri][i].equals(argshstr[j])) {
						pingce++;
						if(hhhh==null) {
							hhhh = argshstr[j];
						}
						else {
							hhhh = hhhh +"_"+argshstr[j];
						}
							
					}
				}
			}
			fw.println(hhhh);

			hwri++;
		}
		mapblog.close();
		tmapscan.close();
		fw.close();
		//System.out.println(pingce);
		System.out.println(pingce/((205-28)*3));
		
	}
}
