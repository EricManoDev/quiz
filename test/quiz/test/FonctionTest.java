/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Formation
 */
public class FonctionTest {
    
    public int calculeCarre(int n){
        
        return n * n;
    }
    
    
    
    @Test
    public void test(){
        
        int resultat = calculeCarre(10);
    }
}
