package DsaForYou.udemy;

import java.util.Scanner;

public class RightAngledTrianglePattern {
    public static void main (String [] args){

       // Scanner sc = new Scanner(System.in);
       // System.out.println("Enter Size of Right Angled Triangle :");
        int size = 6;
        for(int i =0; i <=size;i++){
            for(int j = 1; j<=size-i;j++){
                System.out.print(" ");
            }
            for(int j = 1; j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();

        }
    }
}
