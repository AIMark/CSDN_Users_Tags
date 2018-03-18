package sourcedivi;
//���� ��Ҷ˹�㷨
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
	          // ���ʳ��ֶ�Σ�ֻ��һ����ExtractVocabulary(D),����ʻ���С
	          ArrayList<String> V=new ArrayList<String>();
	          for(int i=0;i<trainingSet.size();i++){
	              for(Entry<String, String> entry:trainingSet.entrySet()){
	                 String str=entry.getKey();
	                 String[] strs=str.split(" ");        //���ݿո��и��ַ���
	                 for(String word:strs){
	                     if(!V.contains(word)){
	                      V.add(word);
	                     }
	                 }
	              }
	          }
	          //countDoc������ѵ�������е��ĵ�����
	          double N=trainingSet.size();
	          double[] prior=new double[classSet.size()];
	          double[][] condprob=new double[V.size()][classSet.size()];
	          int i=0;
	          for(String c:classSet){
	              //CountDocsInClass,����Nc��NcΪѵ��������c �����������ĵ���Ŀ
	              double Nc=0;
	              String text="";
	              for(Entry<String, String> entry:trainingSet.entrySet()){
	                  if(entry.getValue().equals(c)){
	                      Nc++;
	                      text+=entry.getKey();     //�����c�µ��ĵ����ӳ�һ�����ַ���,concatenatetextofalldocinclass
	                      text+=" ";
	                  } 
	              }
	              prior[i]=Nc/N;                       //�����������
	              String[] texts=text.split(" ");     //���ݿո��и��ַ���
	              double[] Tct=new double[V.size()];      
	              int j=0;
	              // ������c�µ���t�ĳ��ִ���Tct,CountTokenOfTerms
	              for(String t:V){
	                  double count=0;
	                  for(String word:texts){     
	                      if(t.equals(word)){        //ע�⣬����ʹ��==            
	                          count++;   
	                      }
	                  }
	                  Tct[j]=count;
	                  j++;
	              }     
	              //������������ �Ĺ���ֵΪt��c ���ĵ��г��ֵ����Ƶ��
	              double Sigma=0;
	              for(int x=0;x<Tct.length;x++){
	                  Sigma+=Tct[x];       
	              }     
	              for(int t=0;t<V.size();t++){
	                  condprob[t][i]=(Tct[t]+1)/(Sigma+V.size());
	              }  
	              i++;
	          }  
	          Node node=new Node();           //�ýṹ�巵�ض�����
	          node.V=V;
	          node.prior=prior;
	          node.condprob=condprob;  
	          return node;               //������node
	      }
	      public static double[] applyMultinomialNB(ArrayList<String> classSet,ArrayList<String> V,double[] prior,
	                                     double[][]condprob,ArrayList<String> testingSet){  
	          double[] scores=new double[classSet.size()];  
	          for(int i=0;i<testingSet.size();i++){               //�������Լ�
	              ArrayList<String> W=new ArrayList<String>();
	              // EXTRACTOKENSFROMDoc,���ĵ�d�еĵ��ʳ�ȡ�����������ظ������������ȫ�µģ���ȫ�ֵ��ʱ�V�ж�û���ֹ�������Ե�
	              String str=testingSet.get(i);       
	              String[] strs=str.split(" ");        //���ݿո��и��ַ���  
	              for(String word:strs){
	                 if(V.contains(word)){
	                     W.add(word);
	                 }
	              }
	            //����������        
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
	              if(scores[0]>scores[1]){                      //�Ƚ�������������ʣ�
	                  System.out.println("���Լ�������yes");
	              }else{
	                  System.out.println("���Լ�������no");
	              }
	          }   
	          return scores;
	      }
	      public static void main(String[] args){
	          ArrayList<String> doc=new ArrayList<String>();
	          ArrayList<String> testingSet=new ArrayList<String>();
	          ArrayList<String> classSet=new ArrayList<String>();
	          //��ʼ��ѵ����
	          doc.add("Chinese Beijing Chinese");          //�������China
	          doc.add("Chinese Chinese Shanghai");         //�������China
	          doc.add("Chinese Macao");                    //�������China
	          doc.add("Tokyo Japan Chinese");              //���������China
	          TreeMap<String,String> trainingSet=new TreeMap<String,String>();
	          for(int i=0;i<doc.size()-1;i++){
	              trainingSet.put(doc.get(i),"yes");
	          }
	          trainingSet.put(doc.get(doc.size()-1),"no");
	          //��ʼ�����Լ�
	          testingSet.add("Chinese Chinese Chinese Tokyo Japan");    
	          //��ʼ����𼯺�
	          classSet.add("yes");
	          classSet.add("no");
	          Node node=new Node();
	          node=trainMultinomialNB(classSet,trainingSet);
	          double[] scores;
	          scores=applyMultinomialNB(classSet,node.V,node.prior,node.condprob,testingSet);
	          //������
	          for(double score:scores){
	              System.out.println(score);
	          }  
	      }
	}

