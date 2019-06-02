package realizable;

import java.util.Scanner;
/*
 * @author mmaaz
 */
public class Realizable {
    public static boolean realizable(int [] A, int T){
        int n= A.length;
        int sum= sum(A);
        int negS= -1*sum;
        boolean P[][]= new boolean[n+1][2*sum+1];
        for (int i = 0; i < P.length; i++) {
            for (int j = negS; j<=sum; j++) {
                if(i==0){
                    P[i][j+sum] = j==0;
                }
                else{
                    if(j<0){
                        P[i][j+sum]=P[i-1][j+sum+A[i-1]] || P[i-1][(j+sum-A[i-1])>=0 ?j+sum-A[i-1]:j+sum+A[i-1]];
                    }
                    else if(j>=0) {
                        P[i][j+sum]=P[i-1][j+sum-A[i-1]] || P[i-1][j+sum+A[i-1]<=2*sum ? j+sum+A[i-1]:j+sum-A[i-1]] ;
                    }
                }
            }
        }
        /*for (int i = 0; i < P.length; i++) {
            for (int j = 0; j<P[0].length; j++) {
                System.out.print(P[i][j]+ " ");
            }System.out.println("");
        }*/
        return P[n][T+sum];
    }
    public static String showOne(int [] A, int T){
        String expr="";
        int n= A.length;
        int sum= sum(A);
        int negS= -1*sum;
        boolean P[][]= new boolean[n+1][2*sum+1];
        for (int i = 0; i < P.length; i++) {
            for (int j = negS; j<=sum; j++) {
                if(i==0){
                    P[i][j+sum] = j==0;
                }
                else{
                    if(j<0){
                        P[i][j+sum]=P[i-1][j+sum+A[i-1]] || P[i-1][(j+sum-A[i-1])>=0 ?j+sum-A[i-1]:j+sum+A[i-1]];
                    }
                    else if(j>=0) {
                        P[i][j+sum]=P[i-1][j+sum-A[i-1]] || P[i-1][j+sum+A[i-1]<=2*sum ? j+sum+A[i-1]:j+sum-A[i-1]] ;
                    }
                }
            }
        }
        int i=n;
        int j=T+sum;
        if(!P[i][j]){
            expr="The value "+ T + " is not realizable";
            return expr;
        }
        else{
            while(i>=0){
                if(P[i-1][j+sum-A[i-1]]){
                    expr= "+" + A[i-1]+expr; 
                    j=j-A[i-1];
                }
                else if (P[i-1][j+sum+A[i-1]]) {
                    expr= "-" + A[i-1]+expr;
                    j=j+A[i-1];
                }
                i--;
            }
        }
        System.out.println(expr);
        return expr;
    }
    public static int sum(int [] A){
        int sum=0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n= in.nextInt();
        int [] A= new int[n];
        System.out.println("Empty array created. Enter the array elements:");
        for (int i = 0; i < n; i++) {
            A[i]= in.nextInt();
        }
        System.out.println("Enter the number whose realizability is to be checked: ");
        int T= in.nextInt();
        boolean result = (realizable(A, T));
        System.out.println("");
        
        System.out.print("n= " + n + "\nThe input array: \n" );
        for (int i = 0; i < n; i++) {
            System.out.print(A[i]+ " ");
        }
        System.out.println("\nT= " + T);
        System.out.println("\tPart1: Realizability Check");
        String p1="";
        if(!result) p1="not "; 
        System.out.println("\t\tThe value is " + p1 + "realizable");
        System.out.println(showOne(A,T));
    }
    
}
