/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author varcal
 */
public class LimitaDigitosNumericos extends PlainDocument{
    
    private int maxLength;

    public LimitaDigitosNumericos(int maxLength) {
        super();
        if(maxLength<=0){
            throw new IllegalArgumentException("Especifique a quantidade!");
        }     
        
        this.maxLength = maxLength;
    } 
    
    @Override
    public void insertString(int offSet, String str, AttributeSet attr) throws BadLocationException{
        if(str == null || getLength() == this.maxLength){
            return;
        }
        
        int quantidade = (getLength()+str.length());
        
        if(quantidade<= this.maxLength){
            super.insertString(offSet, str.replaceAll("[^0-9]", ""), attr);
            return;
        }
        
        String strNova = str.substring(0, getLength() - this.maxLength);
        super.insertString(offSet, strNova, attr);
    }
}
