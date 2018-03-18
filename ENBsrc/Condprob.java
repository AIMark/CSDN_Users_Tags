/*package gather_data;
import java.util.*;
import java.io.*;

	public class Condprob {
		public static int V = 190879;//�ʻ���С
		public static int N = 27352;//ѵ�������е��ĵ�����
		private static double [] prior = new double [42];//prior[i]=Nc/N�������
		private static String []  filename11 = new String[42];//42���ļ���ַ
		private static String pathwrt = "E:\\����ѵ��\\�û�����\\testwen\\42�ĵ�����\\";
		private static String []  tag = {"web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
				"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
				"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
				"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };
		
		private static HashMap<Object,Integer> four_tag_map= new HashMap<>();//42���ĵ���ȡ�����hash
		private static HashMap<Object,Integer> vocall_map= new HashMap<>();//�ܴ��������hash
			
		private static int []  Nc = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
				311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
				1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
				465, 142,270, 223,14, 787, 116 };//42����ǩ�ĵ������� ��27352��
		private static int [] tag_num = new int[42];//42���ĵ��� ����
		
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
				filename11[i] = pathwrt + tag[i] + ".txt";// ��ȡ�ļ���·��+����+�ļ����� 
				
			}
			 // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
	             String tag_vocd_numname = "E:\\����ѵ��\\�û�����\\testwen\\42tag_vocd_num.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
	             File filename = new File(tag_vocd_numname); // Ҫ��ȡ����·����txt�ļ�  
	             InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader  
	             BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
	             String line = "";  

	             for(int i=0;i<42;i++){  
	                 line = br.readLine(); // һ�ζ���һ������  
	                 String [] linne = line.split("\\|");
	                 tag_num[i] = Integer.valueOf(linne[1]);       
	             }
	             reader.close();
	             br.close();
	             
	             //д�����ļ�����hashmap

			     inputStream = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\vocdmap.txt");
				 sc = new Scanner(inputStream, "GB2312");
				 
				 
			     while (sc.hasNextLine()) {//�жϻ���û����һ��
						String[] linelab = sc.nextLine().split("\\|");

						vocall_map.put(linelab[0],Integer.valueOf(linelab[1]));				
							}
			     
			     inputStream.close();
			     sc.close();
			     //д����ļ����� Hashmap
	             for (int tagnu = 0; tagnu < 42; tagnu++) {
	            	
	             inputStream = new FileInputStream(filename11[tagnu]);
					sc = new Scanner(inputStream, "GB2312");
					
					while (sc.hasNextLine()) {//�жϻ���û����һ��
						String[] linelab = sc.nextLine().split("\\|");

						four_tag_map.put(linelab[0],Integer.valueOf(linelab[1]));	
					}

					int kk=0;
					double nudum=0.0;
					double acnu =0.0;
					inputSt = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\vocdmap.txt");
				    scc = new Scanner(inputSt, "GB2312");
					fw = new PrintWriter("E:\\����ѵ��\\�û�����\\testwen\\condprob.txt");

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
	import java.util.*;
	import java.io.*;
	public class Condprob {
		public static int V = 190872;//�ʻ���С
		public static int N = 27352;//ѵ�������е��ĵ�����
		private static double [] prior = new double [42];//prior[i]=Nc/N�������
		private static String []  filename11 = new String[42];//42���ļ���ַ
		private static String []  writfilename11 = new String[42];//д��42���ļ���ַ
		private static String pathwrt = "E:\\����ѵ��\\�û�����\\testwen\\42�ĵ�����\\";
		private static String wrtpath = "E:\\����ѵ��\\�û�����\\testwen\\42�ĵ��������\\";
		private static String []  tag = {"web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
				"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
				"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
				"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };
		
		private static HashMap<Object,Integer> four_tag_map= new HashMap<>();//42���ĵ���ȡ�����hash
		private static HashMap<Object,Integer> vocall_map= new HashMap<>();//�ܴ��������hash
			
		private static int []  Nc = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
				311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
				1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
				465, 142,270, 223,14, 787, 116 };//42����ǩ�ĵ������� ��27352��
		private static int [] tag_num = new int[42];//42���ĵ��� ����
		
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
				filename11[i] = pathwrt + tag[i] + ".txt";// ��ȡ�ļ���·��+����+�ļ����� 
				writfilename11[i] = wrtpath + tag[i] + ".txt";
				
			}
			 // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  
 
	             String tag_vocd_numname = "E:\\����ѵ��\\�û�����\\testwen\\42tag_vocd_num.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
	             File filename = new File(tag_vocd_numname); // Ҫ��ȡ����·����txt�ļ�  
	             InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader  
	             BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
	             String line = "";  
	             //line = br.readLine();  
	             for(int i=0;i<42;i++){  
	                 line = br.readLine(); // һ�ζ���һ������  
	                 String [] linne = line.split("\\|");
	                 tag_num[i] = Integer.valueOf(linne[1]);       
	             }
	             reader.close();
	             br.close();
	             
	             //д�����ļ�����hashmap

			     inputStream = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\vocdmap.txt");
				 sc = new Scanner(inputStream, "GB2312");
				 
				 
			     while (sc.hasNextLine()) {//�жϻ���û����һ��
						String[] linelab = sc.nextLine().split("\\|");
						//System.out.println(linelab[0]+"|"+Integer.valueOf(linelab[1]));
						vocall_map.put(linelab[0],Integer.valueOf(linelab[1]));				
							}
			     
			     inputStream.close();
			     sc.close();
			     //д����ļ����� Hashmap
	             for (int tagnu = 0; tagnu < 42; tagnu++) {
	            	
	             inputStream = new FileInputStream(filename11[tagnu]);
					sc = new Scanner(inputStream, "GB2312");
					
					while (sc.hasNextLine()) {//�жϻ���û����һ��
						String[] linelab = sc.nextLine().split("\\|");
						four_tag_map.put(linelab[0],Integer.valueOf(linelab[1]));	
					}
					
					double nudum=0.0;
					double acnu =0.0;
					inputSt = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\vocdmap.txt");
				    scc = new Scanner(inputSt, "GB2312");
					fw = new PrintWriter(writfilename11[tagnu]);
					
					while(scc.hasNextLine()) {
						String[] linelaab = scc.nextLine().split("\\|");
						if((four_tag_map.get(linelaab[0]))!=null)
						{
						nudum = four_tag_map.get(linelaab[0]);
						}
						acnu = (nudum+1)/(Nc[tagnu]+190879);

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

