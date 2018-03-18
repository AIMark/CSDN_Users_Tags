package sourcedivi;
//博客 贝叶斯算法
	import java.util.ArrayList;
	import java.util.Map.Entry;
	import java.util.TreeMap;
	class Node{                         
	    ArrayList<String> V;
	    double[] prior;
	    double[][] condprob;
	    Node(){
	        V=new ArrayList<String>();
	    }
	}
	public class nb180311 {
	      public static Node trainMultinomialNB(ArrayList<String> classSet, TreeMap<String,String> trainingSet){
	          // 单词出现多次，只算一个，ExtractVocabulary(D),计算词汇表大小
	          ArrayList<String> V=new ArrayList<String>();
	          for(int i=0;i<trainingSet.size();i++){
	              for(Entry<String, String> entry:trainingSet.entrySet()){
	                 String str=entry.getKey();
	                 String[] strs=str.split(" ");        //根据空格切割字符串
	                 for(String word:strs){
	                     if(!V.contains(word)){
	                      V.add(word);
	                     }
	                 }
	              }
	          }
	          //countDoc，计算训练集合中的文档总数
	          double N=trainingSet.size();
	          double[] prior=new double[classSet.size()];
	          double[][] condprob=new double[V.size()][classSet.size()];
	          int i=0;
	          for(String c:classSet){
	              //CountDocsInClass,计算Nc，Nc为训练集合中c 类所包含的文档数目
	              double Nc=0;
	              String text="";
	              for(Entry<String, String> entry:trainingSet.entrySet()){
	                  if(entry.getValue().equals(c)){
	                      Nc++;
	                      text+=entry.getKey();     //将类别c下的文档连接成一个大字符串,concatenatetextofalldocinclass
	                      text+=" ";
	                  } 
	              }
	              prior[i]=Nc/N;                       //计算先验概率
	              String[] texts=text.split(" ");     //根据空格切割字符串
	              double[] Tct=new double[V.size()];      
	              int j=0;
	              // 计算类c下单词t的出现次数Tct,CountTokenOfTerms
	              for(String t:V){
	                  double count=0;
	                  for(String word:texts){     
	                      if(t.equals(word)){        //注意，不能使用==            
	                          count++;   
	                      }
	                  }
	                  Tct[j]=count;
	                  j++;
	              }     
	              //计算条件概率 的估计值为t在c 类文档中出现的相对频率
	              double Sigma=0;
	              for(int x=0;x<Tct.length;x++){
	                  Sigma+=Tct[x];       
	              }     
	              for(int t=0;t<V.size();t++){
	                  condprob[t][i]=(Tct[t]+1)/(Sigma+V.size());
	              }  
	              i++;
	          }  
	          Node node=new Node();           //用结构体返回多个结果
	          node.V=V;
	          node.prior=prior;
	          node.condprob=condprob;  
	          return node;               //返回类node
	      }
	      public static double[] applyMultinomialNB(ArrayList<String> classSet,ArrayList<String> V,double[] prior,
	                                     double[][]condprob,ArrayList<String> testingSet){  
	          double[] scores=new double[classSet.size()];  
	          for(int i=0;i<testingSet.size();i++){               //遍历测试集
	              ArrayList<String> W=new ArrayList<String>();
	              // EXTRACTOKENSFROMDoc,将文档d中的单词抽取出来，允许重复，如果单词是全新的，在全局单词表V中都没出现过，则忽略掉
	              String str=testingSet.get(i);       
	              String[] strs=str.split(" ");        //根据空格切割字符串  
	              for(String word:strs){
	                 if(V.contains(word)){
	                     W.add(word);
	                 }
	              }
	            //计算后验概率        
	              int index=0;
	              scores=new double[classSet.size()];   
	              for(int j=0;j<classSet.size();j++){
	                  scores[j]=Math.log(prior[j]);           
	                  for(String t:W){
	                      for(String word:V){
	                          if(t.equals(word)){                
	                             index=V.indexOf(word);
	                          }
	                      }
	                      scores[j]+=Math.log(condprob[index][j]);      
	                  }
	              }
	              if(scores[0]>scores[1]){                      //比较两个最大后验概率，
	                  System.out.println("测试集属于类yes");
	              }else{
	                  System.out.println("测试集属于类no");
	              }
	          }   
	          return scores;
	      }
	      public static void main(String[] args){
	          ArrayList<String> doc=new ArrayList<String>();
	          ArrayList<String> testingSet=new ArrayList<String>();
	          ArrayList<String> classSet=new ArrayList<String>();
	          //初始化训练集
	          doc.add("Chinese Beijing Chinese");          //属于类别China
	          doc.add("Chinese Chinese Shanghai");         //属于类别China
	          doc.add("Chinese Macao");                    //属于类别China
	          doc.add("Tokyo Japan Chinese");              //不属于类别China
	          TreeMap<String,String> trainingSet=new TreeMap<String,String>();
	          for(int i=0;i<doc.size()-1;i++){
	              trainingSet.put(doc.get(i),"yes");
	          }
	          trainingSet.put(doc.get(doc.size()-1),"no");
	          //初始化测试集
	          testingSet.add("Chinese Chinese Chinese Tokyo Japan");    
	          //初始化类别集合
	          classSet.add("yes");
	          classSet.add("no");
	          Node node=new Node();
	          node=trainMultinomialNB(classSet,trainingSet);
	          double[] scores;
	          scores=applyMultinomialNB(classSet,node.V,node.prior,node.condprob,testingSet);
	          //输出结果
	          for(double score:scores){
	              System.out.println(score);
	          }  
	      }
	}

