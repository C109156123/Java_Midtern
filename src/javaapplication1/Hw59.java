/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Hw59 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int money=sc.nextInt();
    
    int a1 = money % 100;
    int a2 = a1 % 50;
    int a3 = a2 % 10;
    int a4 = a3 % 5;
    int a=0;
    int b=0;
    if (money/100!=0){
        a = money/100;
        b += a;      }  
    if (a1/50!=0){
        a = a1 / 50;
        b+=a;}
    if (a2/10!=0){
        a = a2 / 10;
        b+=a;   }
    if (a3/5!=0){
        a = a3 / 5;
        b+=a;}
    if (a4/1!=0){
        a = a4 / 1;
        b+=a ;}
    System.out.println(b);
            }
}
