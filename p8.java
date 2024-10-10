import java.util.Scanner;
import java.io.*;
interface Concatt{  
    void con(String a, String b);  
}
public class Main 
{  
    public static void main(String[] args) 
    {  
        String str1 =new String();
        String str2 =new String();
        Scanner sc=new Scanner(System.in);  
        str1=sc.nextLine();  
        str2=sc.nextLine();
        Concatt conc=(a, b)->{
			 System.out.println(a.concat(b));};
		conc.con(str1, str2);
    }
}

