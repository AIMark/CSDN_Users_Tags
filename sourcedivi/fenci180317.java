package sourcedivi;
//武鹏艳的分词
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
 

public class fenci180317  {  
    public static void main(String[] args) throws IOException {  

      /** 
13.         * 为了提高写入的效率，使用了字符流的缓冲区。 
14.         * 创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联。 
         */  
Hashtable<String, Integer>  wordCount = new Hashtable<String, Integer>();
File fileIn= new File("G:\\U盘\\jiegou\\web开发.txt");

File fileOut= new File("C:\\Users\\Administrator\\Desktop\\作业\\qqq.txt");

 

InputStreamReader inStream = new InputStreamReader(new FileInputStream(fileIn), "GBK");

 

OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(fileOut),"GBK");
int count=0;
BufferedReader reader = new BufferedReader(inStream);

BufferedWriter Writer = new BufferedWriter(writerStream);
String s=null;
int c=0;
while ((s=reader.readLine())!=null) {
	
	String arry[] =s.split(" ");
	
    for (int i = 0; i < arry.length; i++) {
        if (!wordCount.containsKey(arry[i])) {
            wordCount.put(arry[i], Integer.valueOf(1));
            count++;
        } else {
            wordCount.put(arry[i], Integer.valueOf(wordCount.get(arry[i]).intValue() + 1));
            count++;
        }
    }
}
/*for (java.util.Map.Entry<String, Integer> j : wordCount.entrySet()) {
	String key = j.getKey();
    int value = j.getValue();
    Writer.append(key+" "+value+"\r\n");
}*/

//if the number of the word is 1,output the word and the number

//将map.entrySet()转换成list  
List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());  
Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
    //降序排序  
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
        //return o1.getValue().compareTo(o2.getValue());  
        return o2.getValue().compareTo(o1.getValue());  
    }  
});  

for (Map.Entry<String, Integer> mapping : list) {  
	 Writer.write(mapping.getKey() + ":" + mapping.getValue() ); 
	 Writer.newLine(); 
}  
     Writer.write(String.valueOf(count));
     Writer.flush();  
     //关闭缓冲区,同时关闭了流对象  
     Writer.close();
     
    }
}