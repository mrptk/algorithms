package pl.mazur;

/**
 *
 * @author ptkma
 */
public class TestingProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        var lista = new MyList<String>();
        
        lista.add("hejost");
        lista.add("hej1");
        lista.add("hej2");
        lista.add("hej");
        lista.add("hej1");
        lista.add("baran");
        lista.add("hej");
        lista.add("hej1");
        lista.add("hej21");
        
        System.out.println("*************** LIST ****************");
        lista.print();
        
        System.out.println("\n************* LIST AFTER ELEMENT DELETION *************");
        lista.delete("baran");
        lista.print();
        
        System.out.println("\n************* LIST AFTER APPENDING *************");
        lista.append("baran");
        lista.print();
        
        System.out.println("\n************* LIST DESTROYED ****************");
        lista.destroy();
        lista.print();
        
        System.out.println("\n********** LIST FROM AN ARRAY ***************");
        Integer[] arr = new Integer[]{ 1, 2, 3, 4};
        MyList<Integer> newList = new MyList<>();
        newList.fromArray(arr);
        newList.append(0);
        newList.print();
        
        System.out.println("\n************ LIST TO AN ARRAY **************************");
        Integer[] arr1 = newList.toArray();
        for(Integer o : arr1) System.out.println(o);
        
        
        
    }
    
}
