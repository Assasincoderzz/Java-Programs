import java.util.*;  
import java.io.*;
public class Main 
{  
    public static void main(String[] args) throws Exception 
    {  
        int n1;  
        Scanner sc=new Scanner(System.in);  
        n1=sc.nextInt();  
        int[] arr = new int[n1];  
        for(int i=0; i<n1; i++)  
        {  
            arr[i]=sc.nextInt();  
        }
        Arrays.stream(arr).filter(o -> o % 2 == 0).forEach(System.out::println);
    }
}
