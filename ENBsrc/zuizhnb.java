package gather_data;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class zuizhnb {
	private static String []  tag = { "web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
			"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
			"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
			"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };
	public static void main(String [] args) throws Exception{
		FileInputStream bittmapblog = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\tegailv.txt");
		Scanner bittmapscan = new Scanner(bittmapblog);
		String [][] hhStrings = new String[206][3];
		PrintWriter fw = new PrintWriter("E:\\����ѵ��\\�û�����\\wen\\zuizho.txt");
		String linshstr = null;
		
		//int [] hel = new int[42];
		int hwue =0;
		while (bittmapscan.hasNext()) {
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
			for(int i =j;i<41;i++) {
				 k=i;
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
			}
			hwue++;
		}
		bittmapblog.close();
		bittmapscan.close();
		FileInputStream mapblog = new FileInputStream("E:\\����ѵ��\\�û�����\\SMPCUP2017����2ѵ����\\SMPCUP2017_TrainingData_Task2��֤��.txt");
		Scanner tmapscan = new Scanner(mapblog);
		
		int hwri=0;
		while (tmapscan.hasNext()) {
			//System.out.println(hwri);
			linshstr = tmapscan.nextLine();
			String [] argshstr = linshstr.split("");
			String hhhh=null;
			for(int i=0;i<3;i++) {
				for(int j=1;j<4;j++) {
					if(hhStrings[hwri][i].equals(argshstr[j])) {
							hhhh = hhhh +"_"+argshstr[j];
					}
				}
			}
			fw.println(hhhh);

			hwri++;
		}
		mapblog.close();
		tmapscan.close();
		fw.close();
		
	}
}
