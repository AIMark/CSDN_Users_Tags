//�ҵ�850���û���Ӧ��42����ǩ�ļ�
package gather_data;

import java.util.*;
//import com.hankcs.hanlp.HanLP;
import java.io.*;

public class gather{
	private static Map<String, String> blogmap = new HashMap<>();
	private static Map<String, String> postmap = new HashMap<>();
	private static String [] bloline = new String[1000002];
	private static int pathinnum = 3;//����·����Ŀ
	// private static int pathoutnum = 2;
	private static String []  pathin = new String[pathinnum];//·����ַ
	private static String path = "E:\\����ѵ��\\�û�����\\tag42\\";//42����ǩ�ĵ��ĵ�ַ
	private static String Blogpath = "E:\\����ѵ��\\�û�����\\wen\\blogGB2312.txt";//100�򲩿͵�ַ
	private static String []  tag = { "web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
			"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
			"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
			"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };//42����ǩ
	//private static int [] tagshu =new int[42];
	private static String []  filename = new String[42];//42����ǩ�ĵ����Ƶ�ַ
	private static int tagnum = 42;//42����ǩ

	//����42����ǩ�ĵ�·������
	public static void tagpath(String[] tag, String[] filename, int num) {
		for (int i = 0; i < num; i++) {
			filename[i] = path + tag[i] + ".txt";// �ļ�·��+����+�ļ�����
		}
	}
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
	public static void getContent()throws IOException {
        try  {
        	FileReader filemap = null;
			BufferedReader mapscan = null;
			filemap = new FileReader("E:\\����ѵ��\\�û�����\\testwen\\map.txt");
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
		pathin[1] = "E:\\����ѵ��\\�û�����\\SMPCUP2017����2ѵ����\\SMPCUP2017_TrainingData_Task2.txt";//100���û���Ȥ����
		pathin[2] = "E:\\����ѵ��\\�û�����\\SMPCUP2017���ݼ�\\2_Post.txt";//�û��Ͳ��Ͷ�Ӧ�ļ�2_post.txt

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
		
		PrintWriter[] filewrite1 = new PrintWriter[tagnum];//42����ǩ�ļ�д��

		try {
			fileTask = new FileInputStream(pathin[1]);//1000�û���Ȥ����
			Taskscan = new Scanner(fileTask, "UTF-8");//1000�û���Ȥ����

			for (int i3 = 0; i3 < tagnum; i3++) {
				filewrite1[i3] = new PrintWriter(filename[i3]);//����42����ǩд���ļ�
			}
			String Taskline=null, postline=null;//
			int i = 0;//�ȶ�ȡ10���û�����Ȥ����
			//int nu=0;
			while ((++i<851) &&  (Taskline = Taskscan.nextLine()) != null  ) {//��ȡ�û�������Ȥ
				//i++;
				String[] Taskline1 = Taskline.split("");//��/001 �ָ���������
					for (int j = 0; j < tagnum; j++) {
						if (Taskline1[1].equals(tag[j])) {//���û���һ����Ȥ�ȽϺ�42�еڼ�����Ȥһ��
							//��ȡ�û��Ͳ��Ͷ�Ӧ�ļ�2_post.txt
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
										filewrite1[j].println(Taskline1[0]+""+blogmap.get(postline1[postinu])+""+postline1[postinu]+""+blogline);//д������һ����Ȥ�ĵ�
								//map.put(blogline1[0], blogline)
								//tagshu[j]++;//ͳ�ƴ���Ȥ��Ŀ
								for (int t2 = 0; t2< tagnum; t2++) {
									if(Taskline1[2].equals(tag[t2])) {//д�����ڶ�����Ȥ�ĵ�
										//tagshu[t2]++;//ͳ�ƴ���Ȥ��Ŀ
										filewrite1[t2].println(Taskline1[0]+""+blogmap.get(postline1[postinu])+""+postline1[postinu]+""+blogline);													
										break;
									}
								}
								for (int t3 = 0; t3< tagnum; t3++) {//д������������Ȥ�ĵ�
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
									filewrite1[j].println(Taskline1[0]+""+blogmap.get(postline)+""+postline+""+blogline);//д������һ����Ȥ�ĵ�
									//map.put(blogline1[0], blogline)
									//tagshu[j]++;//ͳ�ƴ���Ȥ��Ŀ
									for (int t2 = 0; t2< tagnum; t2++) {
										if(Taskline1[2].equals(tag[t2])) {//д�����ڶ�����Ȥ�ĵ�
											//tagshu[t2]++;//ͳ�ƴ���Ȥ��Ŀ
											filewrite1[t2].println(Taskline1[0]+""+blogmap.get(postline)+""+postline+""+blogline);													
											break;
										}
									}
									for (int t3 = 0; t3< tagnum; t3++) {//д������������Ȥ�ĵ�
										if(Taskline1[3].equals(tag[t3])) {
											filewrite1[t3].println(Taskline1[0]+""+blogmap.get(postline)+""+postline+""+blogline);
											//tagshu[t3]++;//
											
											break;
										}
									}
							}
							}
					/*		while ( (++postnum < 1000001 )&&((postline = postscan.nextLine()) != null) ) {//��ȡ�û��Ͳ��Ͷ�Ӧ�ļ�2_post.txt
								//postnum++;
								//�ָ�Ϊ������ �û���źͲ��ͱ��
								
								if((Taskline1[0].equals(postline1[0]))&&((blogline =bloline[Integer.valueOf(blogmap.get(postline1[1]))])!=null)) {//�û���ź�post�û���űȽ�									
										//if(map.get(blogline.substring(0, 8))!=null)	{																
										filewrite1[j].println(Taskline1[0]+""+postline1[0]+""+blogmap.get(postline1[1])+""+postline1[1]+""+blogline);//д������һ����Ȥ�ĵ�
										//map.put(blogline1[0], blogline)
										//tagshu[j]++;//ͳ�ƴ���Ȥ��Ŀ
										for (int t2 = 0; t2< tagnum; t2++) {
											if(Taskline1[2].equals(tag[t2])) {//д�����ڶ�����Ȥ�ĵ�
												//tagshu[t2]++;//ͳ�ƴ���Ȥ��Ŀ
												filewrite1[t2].println(Taskline1[0]+""+postline1[0]+""+blogmap.get(postline1[1])+""+postline1[1]+""+blogline);													
												break;
											}
										}
										for (int t3 = 0; t3< tagnum; t3++) {//д������������Ȥ�ĵ�
											if(Taskline1[3].equals(tag[t3])) {
												filewrite1[t3].println(Taskline1[0]+""+postline1[0]+""+blogmap.get(postline1[1])+""+postline1[1]+""+blogline);
												//tagshu[t3]++;//
												
												break;
											}
										}
										//}	
										else {
											filewrite1[j].println(postline1[1]+""+map.get(postline1[1]));//д������һ����Ȥ�ĵ�
											//map.put(blogline1[0], blogline)
											//tagshu[j]++;//ͳ�ƴ���Ȥ��Ŀ
											for (int t2 = 0; t2< tagnum; t2++) {
												if(Taskline1[2].equals(tag[t2])) {//д�����ڶ�����Ȥ�ĵ�
													//tagshu[t2]++;//ͳ�ƴ���Ȥ��Ŀ
													filewrite1[t2].println(postline1[1]+""+map.get(postline1[1]));													
													break;
												}
											}
											for (int t3 = 0; t3< tagnum; t3++) {//д������������Ȥ�ĵ�
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


