import java.util.Scanner;
import java.io.BufferedReader;  
import java.io.*;
public class p4
{  
    public static void main(String[] args) throws Exception 
    {  
        String n =new String();  
        Scanner sc=new Scanner(System.in);  
        n=sc.nextLine();  
        FileWriter writer = new FileWriter("input.txt");
        writer.write(n);
        n=sc.nextLine();
        writer.write("\n");
        writer.write(n);
        writer.close();
        String line;  
        FileReader file = new FileReader("input.txt");  
        BufferedReader br = new BufferedReader(file); 
        while((line = br.readLine()) != null) 
        {  
            System.out.println(line);
        }  
        br.close(); 
    }  
}