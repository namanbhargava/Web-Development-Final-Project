/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Vector;

/**
 *
 * @author bharg
 */
public class PrimeNumber {
    
    Vector<Integer> number;

    public PrimeNumber() {
        number = new Vector<>();
        for(int i=3; i<50; i++)
            if(isPrime(i)){
                number.add(i);
            }
                
        
        showPrimeNumber();
    }
    
    public void showPrimeNumber() {
        for (int x : number) {
            System.out.println(x);
        }
    }

    public boolean isPrime(int n) {
        int i;
        for (i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        PrimeNumber pn = new PrimeNumber();
    }
    
    
}
