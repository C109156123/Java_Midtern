/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;


/**
 *
 * @author Wei
 */
import java.util.Scanner;
public class Hw53 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("輸入路程公里(km)數：");
        float km=input.nextFloat();
        int fee=75;
        double over=km-1.5;
        if (km<1.5){
            fee=75;
        }   
        else{
            if(over%0.25==0){
                fee+=(over/0.25)*5;
            }
            else{
                fee+=((Math.floor(over/0.25))+1)*5;
            }
        }
        System.out.println("所需車資為："+fee);
    }
}
