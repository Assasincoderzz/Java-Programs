import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a =sc.nextInt();
        Double b= sc.nextDouble();
        Boolean c = sc.nextBoolean();
        String d = sc.next();
        sc.nextLine();
        String e = sc.nextLine();
        System.out.println("Integer value = "+a);
        System.out.println("Double value = "+b);
        System.out.println("Boolean value = "+c);
        System.out.println("Char value = "+d.charAt(0));
        System.out.println("String value = "+e);
    }
}
