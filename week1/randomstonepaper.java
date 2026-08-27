import java.util.*;

public class randomstonepaper
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner (System.in);
        Random ran=new Random();
        int n=ran.nextInt(3)+1;
        System.out.println("You have three choice\n1:Scissor\n2:Stone\n3:Paper");
        System.out.println("Choose from 1 to 3");
        int x=sc.nextInt();
        if(n==1 )
            System.out.println("System chooses : Scissor");
        else if(n==2)
            System.out.println("System chooses : Stone");
        else if(n==3 )
            System.out.println("System chooses : Paper");


        if(x==1)
            System.out.println("You choose: Scissor");
        else if(x==2)
            System.out.println("You choose : Stone");
        else if( x==3)
            System.out.println("You choose : Paper");


        if(x==1 && n==3 || x==2 && n==1 || x==3 && n==2)
            System.out.println("You win");
        else if(x==1 && n==2 || x==2 && n==3 || x==3 && n==1)
            System.out.println("System win");
        else if(x==n)
            System.out.println("Draw"); 

        sc.close();
    }
}
    

