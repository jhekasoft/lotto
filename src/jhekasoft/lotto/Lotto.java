package jhekasoft.lotto;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jheka
 */
public class Lotto {
    public static final int NUMBERS_END = -1;
    public static final int NUMBERS_COUNT = 90;
    private int stepNum = 0;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    
    public Lotto() {
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers.add(i+1);
        }
        
        Collections.shuffle(numbers);
    }
    
    public int getNextNumber(){
        if(NUMBERS_COUNT == stepNum) {
            return NUMBERS_END;
        }
        
        int nextNum = numbers.get(stepNum);
        stepNum++;
        
        return nextNum;
    }
    
}
