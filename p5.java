import java.util.Scanner;  
import java.io.*;
public class p5
{  
    public static void main(String[] args) throws Exception 
    {  
        int n;  
        Scanner sc=new Scanner(System.in);  
        n=sc.nextInt();  
        int[] arr = new int[n];  
        for(int i=0; i<n; i++)  
        {  
            arr[i]=sc.nextInt();  
        }  
        FileWriter writer = new FileWriter("input.txt");
        int len = arr.length;
        for (int i = 0; i < len; i++) 
        {
            writer.write(arr[i]);
        }
        writer.close();
        FileReader reader = new FileReader("input.txt");
        int nu;
        int s=0;
        for (int i = 0; i < len; i++) 
        {
            nu=reader.read();
            if(nu>s){s=nu;}
        }
        System.out.print(s);
        reader.close();
    }  
}
