
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.util.Comparator;

/**
 * **************************************************************************
 * Compilation within a console or terminal: Windows version: javac -cp
 * .;stdlib.jar InsertionSorting.java OS / Linux version: javac -cp .:stdlib.jar
 * InsertionSorting.java
 *
 * Execution within a console or terminal: Windows version: java -cp
 * .;stdlib.jar InsertionSorting < tiny.txt (or words3.txt) OS / Linux version:
 * javac -cp .:stdlib.jar InsertionSorting < tiny.txt (or words3.txt)
 *
 * Adaptation: Enable and disable statements where appropriately in the lines of
 * code below.
 *
 * NOTE for execution within an IDE (i.e., Eclipse or NetBeans): In Eclipse,
 * drag the corresponding input data files tiny.txt and words3.txt over the main
 * project folder and COPY it; In NetBeans. copy-paste the .txt files into the
 * NetBeans project directory. Accordingly, change the file name in the
 * statement, for instance, reading data from the tiny.txt file:
 *
 * input = new Scanner(new File("tiny.txt"));
 *
 * NOTE (2) for execution within an IDE: Do not forget to add the stdlib.jar to
 * the Libraries.
 *
 *
 ***************************************************************************
 */
/**
 * The <tt>InsertionSorting</tt> class provides static methods for sorting an
 * array using an optimised version of insertion sort (with half exchanges and a
 * sentinel).
 *
 */
public class InsertionSorting {

    // This class should not be instantiated.
    private InsertionSorting() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;

        // Complete the Insertion sorting algorithm by using all other methods in this API....
//        for (int i =  N-1; i > 0; i--)
//           if (less(a[i], a[i-1])) exch(a, i, i-1);
//
//        for (int i = 2; i < N; i++) {
//            Comparable v = a[i];
//            int j = i;
//            while (less(v, a[j-1])) {
//                a[j] = a[j-1];
//                j--;
//            }
//            a[j] = v;
//        }
        for (int index = 1; index < a.length; index++) {
            Comparable key = a[index];
            //get index of array
            int position = index;

            //  Shift bigger values values to the right
            while (position > 0 && key.compareTo(a[position - 1]) < 0) {
                //swap
                a[position] = a[position - 1];
                position--;
            }

            a[position] = key;
        }

        isSorted(a);
    }

    /**
     * *********************************************************************
     * Helper sorting functions
     * *********************************************************************
     */
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * *********************************************************************
     * Check if array is sorted - useful for debugging
     * *********************************************************************
     */
    private static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return false;

    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        ArrayList<Comparable> t = new ArrayList<Comparable>();
        // ONLY for IDE version, remove otherwise
        Scanner input = null;
        try {
            input = new Scanner(new File("words.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // END of IDE version

        int N = input.nextInt();
        String[] a = new String[N];

        // ONLY for IDE version, remove otherwise
        int i = 0;
        while (input.hasNext()) {
            a[i] = input.next();
            t.add(a[i]);
            i++;

        };

        // END of IDE version
        // Enable line below for the console/terminal version....
        // a = StdIn.readAllStrings();
        Stopwatch timer = new Stopwatch();
        Collections.sort(t);
        //InsertionSorting.sort(a);
        StdOut.println("Elapsed time for Insertion Sort = " + timer.elapsedTime());
        //show(a);

        for(int e = 0; e < t.size(); e++){
        
            System.out.println(t.get(e));
        }
    }

}
