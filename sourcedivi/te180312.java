package sourcedivi;
//�ų�42�� ��Ƶ�ĵ� �е� ����������
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class te180312 {
	private static String pathwrt = "E:\\����ѵ��\\�û�����\\testwen\\42�ĵ�����\\";
	private static HashMap<Object,Integer> four_tag_map= new HashMap<>();
	private static String []  tag = {"web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
			"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
			"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
			"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };
	private static String []  filename11 = new String[42];//42���ļ���ַ
	public static void main(String[] args) {
		for (int i = 0; i < 42; i++) {
			filename11[i] = pathwrt + tag[i] + ".txt";// ��ȡ�ļ���·��+����+�ļ����� 
			
		}
		FileInputStream inputStream = null;
		Scanner sc = null;
		 for (int tagnu = 0; tagnu < 42; tagnu++) {
             try {
				inputStream = new FileInputStream(filename11[tagnu]);
			} catch (FileNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
				sc = new Scanner(inputStream, "GB2312");
				
				while (sc.hasNextLine()) {//�жϻ���û����һ��
					String[] linelab = sc.nextLine().split("\\|");
					//System.out.println(linelab[0]+"|"+Integer.valueOf(linelab[1])+"   "+tag[tagnu]);
					four_tag_map.put(linelab[0],Integer.valueOf(linelab[1]));	
				}
				sc.close();
	}
}
}
