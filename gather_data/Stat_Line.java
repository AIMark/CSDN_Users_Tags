package gather_data;
//计算 总行数
public class Stat_Line {
	private static int []  tagnum = { 2064, 232, 534, 73, 670, 52, 81, 625, 207,
			311, 148, 346, 832, 715, 80, 3233, 278, 1474, 331, 180, 1235,439,
			1092, 277, 253, 791, 1175,155, 56,582, 940, 1337, 436, 148, 3953,
			465, 142,270, 223,14, 787, 116 };//42个标签文档的行数
	public static void main (String [] args) {
		int num=0;
		for(int i=0;i<tagnum.length;i++) {
			num=num+tagnum[i];
		}
		System.out.println(num);
	}
}
