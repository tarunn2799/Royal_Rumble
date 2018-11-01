import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class King implements Comparable<King>{
    private String nameKing;
    private String romanNumber;
    private Integer numberKing;

    public King(String nameKing, String romanNumber){
        this.nameKing = nameKing;
        this.romanNumber = romanNumber;
        this.numberKing = 0;
        convertRomanToNumber();
    }

    public void setNameKing(String nameKing){
        this.nameKing = nameKing;
    }
    public void setRomanNumber(String romanNumber){
        this.romanNumber = romanNumber;
        convertRomanToNumber();
    }

    public String getNameKing(){
        return this.nameKing;
    }
    public String getRomanNumber(){
        return this.romanNumber;
    }
    public int getNumberKing(){
        return numberKing;
    }

    /**
     * This class convert a Roman number to an integer
     * @postcondition:
     *  sets the variable numberKing to the value it should have.
     */
    public void convertRomanToNumber(){
        //{'I', 'V', 'X', 'L','C', 'D', 'M'} //Roman
        //{ 1,   5,  10,  50, 100, 500, 1000}//The value in int. This is for reference.
        HashMap<Character, Integer> translationNumbers =  new HashMap<Character, Integer>();
        translationNumbers.put(' ',0);
        translationNumbers.put('I', 1);
        translationNumbers.put('V', 5);
        translationNumbers.put('X', 10);
        translationNumbers.put('L', 50);
        translationNumbers.put('C',100);
        translationNumbers.put('D',500);
        translationNumbers.put('M',1000);

        char previous = ' ';
        int total = 0;

        for (char letter: this.romanNumber.toCharArray()) {
            if(translationNumbers.get(letter) <= translationNumbers.get(previous)){
                total += translationNumbers.get(letter);
            }else if(translationNumbers.get(letter) > translationNumbers.get(previous)){
                total += translationNumbers.get(letter) - translationNumbers.get(previous) * 2;
            }
            previous = letter;
        }
        this.numberKing = total;
    }

    /**
     * Override the compareTo class adding the numbers of the Kings to compare.
     * @param k1
     *  The object King is passed to the method
     * @return
     *  Returns an integer indicating if the comparisons are smaller than the previous king, it returns a number
     *  bigger than 0
     */
    @Override
    public int compareTo(King k1) {
        int lastKing = nameKing.compareTo(k1.nameKing);
        if(lastKing == 0){
            lastKing = k1.numberKing.compareTo(numberKing);
        }
        return lastKing;
    }

    public String toString(){
        return nameKing + " the " + romanNumber;
    }
}