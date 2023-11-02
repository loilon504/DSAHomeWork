//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Map people = new HashMap();

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            people.put(name, phone);
        }

        while(in.hasNext())
        {
            String s=in.nextLine();
            if (people.containsKey(s)) System.out.println(s + "=" + people.get(s));
            else System.out.println("Not found");
        }
    }
}



