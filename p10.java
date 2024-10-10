import java.util.Scanner;
import java.io.BufferedReader;  
import java.io.*;
public class Main 
{  
    public static void main(String[] args) throws Exception 
    {  
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
        while((line = br.readLine()) != null) 
        {  
            String words[] = line.split("");
            int nl= words.length;
            for(int j=0;j<nl;j++)
            {
                if(Character.isDigit(line.charAt(j)))
                {
                    count++;
                }
            }
        }  
        br.close(); 

        System.out.println(count);  
         
    }  
}