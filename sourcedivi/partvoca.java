package sourcedivi;//������Ը��ĵ��ִ�
import java.util.*;
import com.hankcs.hanlp.HanLP;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
public class partvoca {
	/*private static String []  tag = { "web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
			"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
			"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
			"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };//42����ǩ
	private static String []  filename = new String[42];//�洢Ҫ��ȡ��42����ǩ�ĵ���ַ
	private static String []  filenameout = new String[42];//�洢Ҫд����42����ǩ�ĵ����Ƶ�ַ
	private static String path = "E:\\����ѵ��\\�û�����\\tag42\\";//��ȡ42����ǩ�ĵ��ĸ���ַ
	private static String pathout = "E:\\����ѵ��\\�û�����\\testwen\\tag42�ִ�\\";//���42����ǩ�ĵ��ĸ���ַ
	*/
		public static void main(String[] args) throws IOException {
			//
			FileInputStream inputStream = null;
			Scanner sc = null;
			
			PrintWriter fw = null;
			//���������ļ�·��
			/*for (int i = 0; i < 42; i++) {
				filename[i] = path + tag[i] + ".txt";// ��ȡ�ļ���·��+����+�ļ����� 
				filenameout[i] = pathout + tag[i] + ".txt";// д���ļ���·��+����+�ļ�����
			}*/
			
			//��42���ĵ��ִ�
			//for (int i = 0; i < 42; i++) {
				try
				{
					inputStream = new FileInputStream("E:\\����ѵ��\\�û�����\\wen\\���Լ�\\U0126906_�������_�Ƽ���_web����.txt");
					sc = new Scanner(inputStream, "GB2312");
					fw = new PrintWriter("E:\\����ѵ��\\�û�����\\wen\\�����ĵ��ִ�\\U0126906_�������_�Ƽ���_web����.txt");
					while (sc.hasNextLine()) {//�жϻ���û����һ��
						fw.println(HanLP.segment(sc.nextLine()));
					}
					//if (sc.ioException() != null) {
						//throw sc.ioException();
					//}
				}
				finally{
					
				}
			//}
			inputStream.close();
			sc.close();
			fw.close();							
		//}
		
}
}





