import java.util.Scanner;
import java.io.BufferedReader;  
import java.io.*;
public class p3
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
            String words[] = line.split(" ");
            count = count + words.length;
        }  
        br.close(); 
        FileReader file1 = new FileReader("input.txt");  
        BufferedReader br1 = new BufferedReader(file1); 
        while((line = br1.readLine()) != null) 
        {  
            String words1[] = line.split("\\.");
            count1 = count1 + words1.length;
        }  
        br.close(); 
        System.out.println(count+" "+count1);  
         
    }  
}