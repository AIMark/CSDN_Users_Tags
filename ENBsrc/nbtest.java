package gather_data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hankcs.hanlp.HanLP;

public class nbtest {
	private static Map<String, String> tagmap = new HashMap<>();//
	private static String []  tag = { "web����", "���м��ֲ�ʽ����", "�����ݼ���", "������Ϣϵͳ", "��������", "��ý�崦��", "������", "����ѧϰ", "�������������",
			"������Ӿ�", "��ҵ��Ϣ��", "Ƕ��ʽ����", "�˹�����", "�˻�����", "����ʶ��", "�������", "��ҵ����", "���ѧϰ", "���ݻָ�", "���ݿ��ӻ�", "���ݿ�", "�����ھ�",
			"�㷨", "ͼ����", "�Ƽ�ϵͳ", "���������ά��", "������ͨ��", "����ʶ��", "������", "ϵͳ��ά", "��Ŀ����", "��Ϣ��ȫ", "���⻯", "������ʵ", "�ƶ�����",
			"Ӳ��", "��Ϸ����", "����ʶ��", "�Ƽ���", "��ǿ��ʵ", "���濪��", "��Ȼ���Դ���" };//42����ǩ
	private static int []  Nc = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
			311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
			1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
			465, 142,270, 223,14, 787, 116 };
	private static double [] prior = new double [42];
	public static void jisuanpr() {
		for(int i=0;i<42;i++) {
			prior[i]=Nc[i]/27352;
		}
	}
	public static void sattagmap( String Strss) throws IOException{
		try {
			//String bittmapline=null;
			FileInputStream bittmapblog = null;
			Scanner bittmapscan = null;
			
			String linshil = "E:\\����ѵ��\\�û�����\\testwen\\42�ĵ����Ƶ��\\"+Strss+".txt";
			bittmapblog = new FileInputStream(linshil);
			bittmapscan = new Scanner(bittmapblog);
			String bittmapline = null;
			//int num=0;
			while (bittmapscan.hasNextLine() ) {	
				bittmapline=bittmapscan.nextLine();
				String [] arglin = bittmapline.split("\\+");
				//if(tagmap.get(arglin[0])==null) {
					tagmap.put(arglin[0],arglin[arglin.length-1]);	
				//}
			}			
			bittmapblog.close();
			bittmapscan.close();
		}catch (Exception e) {
				e.printStackTrace();
			} finally {
							
		}
	}
	public static void main(String [] args) throws IOException{
		jisuanpr();
		String [] gailv=new String[208];
		int innuga=0;
		//double [] prior = new double [42];
		PrintWriter fw = new PrintWriter("E:\\����ѵ��\\�û�����\\wen\\tegailv.txt");
		
		
		String blogli = null;
		double dougailv =0;
		//double doulins = 0;
		//String linshil = "E:\\����ѵ��\\�û�����\\testwen\\42�ĵ����Ƶ��\\"+Strss+".txt";
		
		
		for(int tagn=0;tagn<42;tagn++ ) {
			sattagmap( tag[tagn]);
			System.out.println(tagn);
			FileInputStream bittmapblog = new FileInputStream("E:\\����ѵ��\\�û�����\\testwen\\tesGB2312.txt");
			Scanner bittmapscan = new Scanner(bittmapblog);
			innuga=0;
			while(bittmapscan.hasNextLine()) {
				blogli=String.valueOf(HanLP.segment(bittmapscan.nextLine()));
				String [] argblogli = blogli.split(",");
				if(argblogli.length>2) {
				for(int kk=0;kk<argblogli.length;kk++) {
					if((argblogli[kk].indexOf("w")>0)){
						continue;
					}
					else {
						if(tagmap.get(argblogli[kk])!=null) {
							
							dougailv += Double.valueOf(tagmap.get(argblogli[kk]));
						}
					}
				}
				dougailv += prior[tagn];
				if(gailv[innuga]==null) {
					gailv[innuga]=String.valueOf(dougailv);
				}
				else {
					gailv[innuga]=gailv[innuga]+"_"+String.valueOf(dougailv);
				}
				dougailv =0;
				
					}
				else {
					if(gailv[innuga]==null) {
						gailv[innuga]=String.valueOf(0);
					}
					else {
						gailv[innuga]=gailv[innuga]+"_"+String.valueOf(0);
					}
				}
				innuga++;	
			}
			tagmap.clear();
			bittmapscan.close();
		}
		
		//int hhin=0;
		//bittmapscan = new Scanner(bittmapblog);
		for(int hhin=0;hhin<205;hhin++){
			fw.println(gailv[hhin]);
			//System.out.println(1);
			//hhin++;
		}
		fw.close();
		//bittmapscan.close();
		//bittmapblog.close();
		
		
	}
}
