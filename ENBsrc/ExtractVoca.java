package gather_data;
//ͳ���ܴ���
import java.io.*;
import java.util.*;

public class ExtractVoca {
	private static Map<String, Integer> vocdmap = new HashMap<>();//�洢�ʺ�Ƶ��
	private static String pathread = "E:\\����ѵ��\\�û�����\\testwen\\tag42�ִ�\\";//��ȡ�ļ��ĸ���ַ
	private static String []  filename = new String[42];//Ҫ��ȡ��42����ǩ�ĵ���ַ
	private static String []  tag = { "web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
			"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
			"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
			"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };//42����ǩ
	//private static int []  tagnum = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
			//311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
		//	1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
			//465, 142,270, 223,14, 787, 116 };//42����ǩ�ĵ������� ��27352��
	public static void main(String[] args) throws IOException {
		//
		FileInputStream inputStream = null;
		Scanner sc = null;
		
		PrintWriter fw = null;
		//���������ļ�·��
		for (int i = 0; i < 42; i++) {
			filename[i] = pathread + tag[i] + ".txt";// ��ȡ�ļ���·��+����+�ļ����� 
			
		}
		
		//��42���ĵ���ȡ����
		for (int tagnu = 0; tagnu < 42; tagnu++) {
			try
			{
				inputStream = new FileInputStream(filename[tagnu]);
				sc = new Scanner(inputStream, "GB2312");
				fw = new PrintWriter("E:\\����ѵ��\\�û�����\\testwen\\vocdmap.txt");
				while (sc.hasNextLine()) {//�жϻ���û����һ��
					String[] linelab = sc.nextLine().split("\\,");
					
					
			
					/*for (int linenu= 8; linenu < linelab.length; linenu++) {
						System.out.println(linelab[linenu]);
					}
			
		}
	}
}*/

					for (int linenu= 8; linenu < linelab.length; linenu++) {
						if((linelab[linenu].length()==0)||(linelab[linenu].indexOf("w")>0)) {
							//System.out.println(linelab[linenu]);
							//linenu++;
						}
						else {
							if((vocdmap.get(linelab[linenu])==null)) {
								vocdmap.put(linelab[linenu],1);	
							}
							else {
								vocdmap.put(linelab[linenu],vocdmap.get(linelab[linenu])+1);	
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
	      }
		inputStream.close();
		sc.close();
		fw.close();							
	}
	
}