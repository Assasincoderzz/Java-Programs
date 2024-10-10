import java.io.*;
import java.util.*;
public class Main
{
   public static void main(String[] args) throws IOException 
   {
      String[] words=null;   
      String n =new String();  
      Scanner sc=new Scanner(System.in);  
      n=sc.nextLine();  
      FileWriter writer = new FileWriter("input.txt");
      writer.write(n);
      writer.close();
      String line;  
      int count = 0,count1 = 0;  
      FileReader file = new FileReader("input.txt"); 
      BufferedReader br = new BufferedReader(file);   
      String s;
      int flag=0; 
      while((s=br.readLine())!=null)
      {
         words=s.split(" ");   
         for(int i=0;i<words.length;i++)
         {
            for(int j=0;j<words[i].length();j++)
            {
               char ch=words[i].charAt(j);   
               if(ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' || ch == 'u')   
               {
                      flag=1; 
                 }
            }
            if(flag==1)
            {
               System.out.println(words[i]);  
            }
            flag=0;
         }
      }
   }
}