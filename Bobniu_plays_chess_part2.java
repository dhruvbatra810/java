// code forces https://codeforces.com/problemset/problem/1395/B

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobniu_plays_chess_part2;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Bobniu_plays_chess_part2 {

    /**
     * @param args the command line arguments
     */
    public static int search(int a,int [][]arr){
        int c=-1;
        done:
        for(int i=a;i==a;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                  if( arr[i][j] == 0)
                  {
                      
                     c=j;
                      break done;
                  }
            }
        }
        return c;
    }
    public static void main(String[] args) {
        // TODO code application logic here
          Scanner obj = new Scanner(System.in);
        int rows=obj.nextInt();
        int cols=obj.nextInt();
        int rowsp=(obj.nextInt()-1);
        int colsp=(obj.nextInt()-1);
        int rowss[][]=new int[rows][cols];
        int colss[][]= new int[rows][cols];
        int arr[][]= new int[rows][cols];
        
        int upc=0;  
         int upr=0;
         
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                arr[i][j]=0;
        arr[rowsp][colsp]=1;  // changed
        rowss[upr][upc]=rowsp;
         colss[upr][upc++]=colsp;
        arr[rowsp][0]=1;    //changed
         rowss[upr][upc]=rowsp;
         colss[upr][upc++]=0;
        arr[0][0]=1;   // changed
        rowss[upr][upc]=0;
         colss[upr][upc++]=0;
         if(upc == cols)  
                     {  upc=0;
                        upr++;
                     }
         
         int start=0;
         int saveforwhile=-1;
           while(start<rows){
              int index= search(start,arr);
              if(index == -1){
                    start++;
                    if(start <rows){
                    arr[start][saveforwhile]=1;
                     rowss[upr][upc]=start;
              colss[upr][upc++]=saveforwhile;
              if(upc == cols)  
                    {  upc=0;
                       upr++;
                    }
                    }
                    
              }
              else{
               saveforwhile=index;
              arr[start][index]=1;
              rowss[upr][upc]=start;
              colss[upr][upc++]=index;
              if(upc == cols)  
                    {  upc=0;
                       upr++;
                    }
                }
             
           }
		 
             for(int i=0;i<rows;i++)
                    for(int j=0;j<cols;j++){
                    System.out.print((rowss[i][j])+" ");
                
                    System.out.println(colss[i][j]);}

    
}
}
    
