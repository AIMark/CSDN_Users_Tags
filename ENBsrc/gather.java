//找到850个用户对应的42个标签文件
package gather_data;

import java.util.*;
//import com.hankcs.hanlp.HanLP;
import java.io.*;

public class gather{
	private static Map<String, String> blogmap = new HashMap<>();
	private static Map<String, String> postmap = new HashMap<>();
	private static String [] bloline = new String[1000002];
	private static int pathinnum = 3;//定义路径数目
	// private static int pathoutnum = 2;
	private static String []  pathin = new String[pathinnum];//路径地址
	private static String path = "E:\\科研训练\\用户画像\\tag42\\";//42个标签文档的地址
	private static String Blogpath = "E:\\科研训练\\用户画像\\wen\\blogGB2312.txt";//100万博客地址
	private static String []  tag = { "web开发", "并行及分布式计算", "大数据技术", "地理信息系统", "电子商务", "多媒体处理", "机器人", "机器学习", "计算机辅助工程",
			"计算机视觉", "企业信息化", "嵌入式开发", "人工智能", "人机交互", "人脸识别", "软件工程", "商业智能", "深度学习", "数据恢复", "数据可视化", "数据库", "数据挖掘",
			"算法", "图像处理", "推荐系统", "网络管理与维护", "网络与通信", "文字识别", "物联网", "系统运维", "项目管理", "信息安全", "虚拟化", "虚拟现实", "移动开发",
			"硬件", "游戏开发", "语音识别", "云计算", "增强现实", "桌面开发", "自然语言处理" };//42个标签
	//private static int [] tagshu =new int[42];
	private static String []  filename = new String[42];//42个标签文档名称地址
	private static int tagnum = 42;//42个标签

	//创建42个标签文档路径函数
	public static void tagpath(String[] tag, String[] filename, int num) {
		for (int i = 0; i < num; i++) {
			filename[i] = path + tag[i] + ".txt";// 文件路径+名称+文件类型
		}
	}
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
	public static void getContent()throws IOException {
        try  {
        	FileReader filemap = null;
			BufferedReader mapscan = null;
			filemap = new FileReader("E:\\科研训练\\用户画像\\testwen\\map.txt");
			mapscan = new BufferedReader(filemap);
            String line;
            while ( (line = mapscan.readLine())!= null  ) {           	             	
            	String[] lineLabel = line.split("\\.");           	
                //String content = line.substring(0, line.length());
                blogmap.put(lineLabel[0], lineLabel[1]);                     
            }
            filemap.close();
            mapscan.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }finally {			
		}
}
	public static void main(String[] args) throws IOException {
		tagpath(tag, filename, tagnum);
		pathin[1] = "E:\\科研训练\\用户画像\\SMPCUP2017任务2训练集\\SMPCUP2017_TrainingData_Task2.txt";//100万用户兴趣数据
		pathin[2] = "E:\\科研训练\\用户画像\\SMPCUP2017数据集\\2_Post.txt";//用户和博客对应文件2_post.txt

		getContent();
		satpostmap();
		String bloglie;
		
		FileInputStream fileblog = null;
		Scanner blogscan = null;
		fileblog = new FileInputStream(Blogpath);
		blogscan = new Scanner(fileblog,"GB2312");
		int blognum=0;
		while ( (++blognum <1000001)&& (( bloglie=blogscan.nextLine()) != null) ) {	
			//if(map.get(bloglie.substring(0, 8))!=null) {
				bloline[blognum] = bloglie;
			//}
			//else {
				//bloline[blognum]=bloglie.substring(0, 8)+"___nuuu";
			//}
				//System.out.println(bloline[blognum]);
		}
		fileblog.close();
		blogscan.close();
		
		FileInputStream fileTask = null;//
		Scanner Taskscan = null;//
		
		PrintWriter[] filewrite1 = new PrintWriter[tagnum];//42个标签文件写出

		try {
			fileTask = new FileInputStream(pathin[1]);//1000用户兴趣数据
			Taskscan = new Scanner(fileTask, "UTF-8");//1000用户兴趣数据

			for (int i3 = 0; i3 < tagnum; i3++) {
				filewrite1[i3] = new PrintWriter(filename[i3]);//创建42个标签写出文件
			}
			String Taskline=null, postline=null;//
			int i = 0;//先读取10个用户的兴趣数据
			//int nu=0;
			while ((++i<851) &&  (Taskline = Taskscan.nextLine()) != null  ) {//读取用户三个兴趣
				//i++;
				String[] Taskline1 = Taskline.split("");//以/001 分割三个部分
					for (int j = 0; j < tagnum; j++) {
						if (Taskline1[1].equals(tag[j])) {//此用户第一个兴趣比较和42中第几个兴趣一致
							//读取用户和博客对应文件2_post.txt
							//FileInputStream filepost = null;
							//Scanner postscan = null;
							//filepost = new FileInputStream(pathin[2]);
							//postscan = new Scanner(filepost,"UTF-8");
							//int postnum=0;
							String blogline=null ;
							postline=postmap.get(Taskline1[0]);
							if( postline!=null && postline.length()>8) {
								String[] postline1=postline.split("\\,");
								for(int postinu=0;postinu<postline1.length;postinu++) {
									if((blogline =bloline[Integer.valueOf(blogmap.get(postline1[postinu]))])!=null) {
										filewrite1[j].println(Taskline1[0]+""+blogmap.get(postline1[postinu])+""+postline1[postinu]+""+blogline);//写出到第一个兴趣文档
								//map.put(blogline1[0], blogline)
								//tagshu[j]++;//统计此兴趣数目
								for (int t2 = 0; t2< tagnum; t2++) {
									if(Taskline1[2].equals(tag[t2])) {//写出到第二个兴趣文档
										//tagshu[t2]++;//统计此兴趣数目
										filewrite1[t2].println(Taskline1[0]+""+blogmap.get(postline1[postinu])+""+postline1[postinu]+""+blogline);													
										break;
									}
								}
								for (int t3 = 0; t3< tagnum; t3++) {//写出到第三个兴趣文档
									if(Taskline1[3].equals(tag[t3])) {
										filewrite1[t3].println(Taskline1[0]+""+blogmap.get(postline1[postinu])+""+postline1[postinu]+""+blogline);
										//tagshu[t3]++;//
										
										break;
									}
								}
								}
							}
							}
							else {
								if(postline!=null && ((blogline =bloline[Integer.valueOf(blogmap.get(postline))])!=null)) {
									filewrite1[j].println(Taskline1[0]+""+blogmap.get(postline)+""+postline+""+blogline);//写出到第一个兴趣文档
									//map.put(blogline1[0], blogline)
									//tagshu[j]++;//统计此兴趣数目
									for (int t2 = 0; t2< tagnum; t2++) {
										if(Taskline1[2].equals(tag[t2])) {//写出到第二个兴趣文档
											//tagshu[t2]++;//统计此兴趣数目
											filewrite1[t2].println(Taskline1[0]+""+blogmap.get(postline)+""+postline+""+blogline);													
											break;
										}
									}
									for (int t3 = 0; t3< tagnum; t3++) {//写出到第三个兴趣文档
										if(Taskline1[3].equals(tag[t3])) {
											filewrite1[t3].println(Taskline1[0]+""+blogmap.get(postline)+""+postline+""+blogline);
											//tagshu[t3]++;//
											
											break;
										}
									}
							}
							}
					/*		while ( (++postnum < 1000001 )&&((postline = postscan.nextLine()) != null) ) {//读取用户和博客对应文件2_post.txt
								//postnum++;
								//分割为两部分 用户编号和博客编号
								
								if((Taskline1[0].equals(postline1[0]))&&((blogline =bloline[Integer.valueOf(blogmap.get(postline1[1]))])!=null)) {//用户编号和post用户编号比较									
										//if(map.get(blogline.substring(0, 8))!=null)	{																
										filewrite1[j].println(Taskline1[0]+""+postline1[0]+""+blogmap.get(postline1[1])+""+postline1[1]+""+blogline);//写出到第一个兴趣文档
										//map.put(blogline1[0], blogline)
										//tagshu[j]++;//统计此兴趣数目
										for (int t2 = 0; t2< tagnum; t2++) {
											if(Taskline1[2].equals(tag[t2])) {//写出到第二个兴趣文档
												//tagshu[t2]++;//统计此兴趣数目
												filewrite1[t2].println(Taskline1[0]+""+postline1[0]+""+blogmap.get(postline1[1])+""+postline1[1]+""+blogline);													
												break;
											}
										}
										for (int t3 = 0; t3< tagnum; t3++) {//写出到第三个兴趣文档
											if(Taskline1[3].equals(tag[t3])) {
												filewrite1[t3].println(Taskline1[0]+""+postline1[0]+""+blogmap.get(postline1[1])+""+postline1[1]+""+blogline);
												//tagshu[t3]++;//
												
												break;
											}
										}
										//}	
										else {
											filewrite1[j].println(postline1[1]+""+map.get(postline1[1]));//写出到第一个兴趣文档
											//map.put(blogline1[0], blogline)
											//tagshu[j]++;//统计此兴趣数目
											for (int t2 = 0; t2< tagnum; t2++) {
												if(Taskline1[2].equals(tag[t2])) {//写出到第二个兴趣文档
													//tagshu[t2]++;//统计此兴趣数目
													filewrite1[t2].println(postline1[1]+""+map.get(postline1[1]));													
													break;
												}
											}
											for (int t3 = 0; t3< tagnum; t3++) {//写出到第三个兴趣文档
												if(Taskline1[3].equals(tag[t3])) {
													filewrite1[t3].println(postline1[1]+""+map.get(postline1[1]));
													//tagshu[t3]++;//
													
													break;
												}
											}
										}
										//break;
									}																				
						}*/
							//filepost.close();
							//postscan.close();
							break;
						}
					}

				}										
			fileTask.close();
			Taskscan.close();
			
			for (int i3 = 0; i3 < tagnum; i3++) {
				filewrite1[i3].close();
			}			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileTask != null) {
				fileTask.close();
			}
			if (Taskscan != null) {
				Taskscan.close();
			}
			for (int i4 = 0; i4 < tagnum; i4++) {
				if ((filewrite1[i4]) != null) {
					filewrite1[i4].close();
				}
			}			
		}
	}
}


