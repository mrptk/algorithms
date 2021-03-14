
package pl.mazur;

import java.util.Comparator;

/**
 *
 * @author ptkma
 */
public class SortingTest {
    
    public static double code(char character){
        //Deklaracja zmiennych
        double code;
        
        //Inicjalizacja zmiennych
        code = (double) character;
        
        //Zmiana kodu polskich znaków
        if (character == 'Ą') code = (double) 'A' + 0.5;
        if (character == 'ą') code = (double) 'a' + 0.5;
        if (character == 'Ć') code = (double) 'C' + 0.5;
        if (character == 'ć') code = (double) 'c' + 0.5;
        if (character == 'Ę') code = (double) 'E' + 0.5;
        if (character == 'ę') code = (double) 'e' + 0.5;
        if (character == 'Ł') code = (double) 'L' + 0.5;
        if (character == 'ł') code = (double) 'l' + 0.5;
        if (character == 'Ń') code = (double) 'N' + 0.5;
        if (character == 'ń') code = (double) 'n' + 0.5;
        if (character == 'Ó') code = (double) 'O' + 0.5;
        if (character == 'ó') code = (double) 'o' + 0.5;
        if (character == 'Ś') code = (double) 'S' + 0.5;
        if (character == 'ś') code = (double) 's' + 0.5;
        if (character == 'Ź') code = (double) 'Z' + 0.5;
        if (character == 'ź') code = (double) 'z' + 0.5;
        if (character == 'Ż') code = (double) 'Z' + 0.7;
        if (character == 'ż') code = (double) 'z' + 0.7;
        
        return code;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        String text;
        String[] arrBeforeSorting;
        String[] arrAfterSorting;
        Comparator<String> comparison;
        
        text = "LITWO, OJCZYZNO MOJA! " +
" " +
"Litwo, Ojczyzno moja! ty jesteś jak zdrowie; " +
"Ile cię trzeba cenić, ten tylko się dowie, " +
"Kto cię stracił. Dziś piękność twą w całej ozdobie " +
"Widzę i opisuję, bo tęsknię po tobie. " +
" " +
"Panno święta, co Jasnej bronisz Częstochowy " +
"I w Ostrej świecisz Bramie! Ty, co gród zamkowy " +
"Nowogródzki ochraniasz z jego wiernym ludem! " +
"Jak mnie dziecko do zdrowia powróciłaś cudem " +
"(— Gdy od płaczącej matki, pod Twoją opiekę " +
"Ofiarowany martwą podniosłem powiekę; " +
"I zaraz mogłem pieszo, do Twych świątyń progu " +
"Iść za wrócone życie podziękować Bogu —) " +
"Tak nas powrócisz cudem na Ojczyzny łono!... " +
"Tymczasem, przenoś moją duszę utęsknioną " +
"Do tych pagórków leśnych, do tych łąk zielonych, " +
"Szeroko nad błękitnym Niemnem rozciągnionych; " +
"Do tych pól malowanych zbożem rozmaitem, " +
"Wyzłacanych pszenicą, posrebrzanych żytem; " +
"Gdzie bursztynowy świerzop, gryka jak śnieg biała, " +
"Gdzie panieńskim rumieńcem dzięcielina pała, " +
"A wszystko przepasane jakby wstęgą, miedzą " +
"Zieloną, na niej zrzadka ciche grusze siedzą.";
        
        arrBeforeSorting = text.split(" ");
        arrAfterSorting = null;
        
        comparison = (firstElement, secondElement) -> {
            //Variables
            int result = 0;
            char[] charArr1 = firstElement.toCharArray();
            char[] charArr2 = secondElement.toCharArray();
            
            
            //Comparison
            for (int i = 0; i < charArr1.length && i < charArr2.length && result == 0; i++){ 
                if (code(charArr1[i]) < code(charArr2[i])) result = -1; 
                if (code(charArr1[i]) > code(charArr2[i])) result = 1;
            } //end for
            
            if (result == 0){
                if (charArr1.length < charArr2.length) result = -1;
                if (charArr1.length > charArr2.length) result = 1;
            }//end for
            
            return result;
        };
        
        // ******* MAIN TESTING PROGRAM ******
        System.out.println("************************ BEFORE *************************");
        for (String S : arrBeforeSorting) System.out.println(S);
        
        System.out.println("********************* AFTER BUBBLE SORTING **********************");
        arrAfterSorting = TextSorting.bubble(arrBeforeSorting, comparison);
        for (String S : arrAfterSorting) System.out.println(S);
        
        System.out.println("******************** AFTER SELECTION SORTING ********************");
        arrAfterSorting = TextSorting.selection(arrBeforeSorting, comparison);
        for (String S : arrAfterSorting) System.out.println(S);
        
        System.out.println("************* AFTER DOUBLE-ENDED SELECTION SORTING *************");
        arrAfterSorting = TextSorting.doubleEndedSelection(arrBeforeSorting, comparison);
        for (String S : arrAfterSorting) System.out.println(S);
    }
    
    
    
}
