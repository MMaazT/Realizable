/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realizable;

import java.util.Scanner;

/**
 *
 * @author mmaaz
 */
public class Realizable {
    public static String realizable(int [] A, int T){
        int n= A.length;
        int sum= sum(A);
        int negS= -1*sum;
        int width= 2*sum+1;
        boolean P[][]= new boolean[n+1][width];
        for (int i = 0; i < P.length; i++) {
            for (int j = negS; j<=sum; j++) {
                if(i==0){
                    if(j==0) P[i][j+sum]=true;
                    else P[i][j+sum]=false;
                }
                //else if(j+sum+A[i-1]>2*sum) continue; 
                //else if (j+sum- A[i-1] < 0 ) continue;
                else{
                    if(j<0){
                        P[i][j+sum]=P[i-1][j+sum+A[i]];
                    }
                   
                }
            }
        }
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j<P[0].length; j++) {
                System.out.print(P[i][j]+ " ");
            }System.out.println("");
        }
        return P[n][T] + " "+ n;
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
        int [] A= {2,3,4};
        int T= in.nextInt();
        System.out.println(realizable(A, T));
       
        
    }
    
}
