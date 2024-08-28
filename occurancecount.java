package occurance;

import java.util.Scanner;
public class occurancecount
{
    public static void main(String[] args) 
    {
        int j = 0,find, count = 0, i = 0;
        boolean found = false;
        Scanner s = new Scanner(System.in);
        
        System.out.println("no. of elements in string array:");
        
        String[] a = {"1287","287","567","8689"};
        
        for(String itr : a)
        {
        	System.out.print("{" + itr + "}");
        }
        System.out.println();
         
        System.out.println("Enter the number you want to count number of occurrences:");
        find = s.nextInt();
        for(i = 0; i < a.length; i++)
        {
        	for(j=0;j<a[i].length();j++)
        	{
        	   String key = String.valueOf(a[i].charAt(j));
        		
        	   if(Integer.parseInt(key) == find)
        	     {
        	       count++; 
        	       found = true;
        	  	 }    
        	}
        	
               if(found)
                 {
            	   System.out.println("String = " + a[i] + " and count of "+find+ " is: " + count);
                 }
                  count = 0;
                  found = false;
        }
    }
}