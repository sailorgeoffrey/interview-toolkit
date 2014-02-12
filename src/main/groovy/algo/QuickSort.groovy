package algo

/**
 * description
 *
 * @since 2/11/14 at 10:40 PM.
 * @author geoffc@gmail.com
 */
class Quicksort {

    static int n = 50

    static int[] numbers = new int[n]

    public static void main(String[] args) {

        for (i in 0..n - 1) {
            numbers[i] = i
        }

        println()
        println "original:"
        println numbers

        def rand = new Random()
        for (i in 0..n - 1) {
            def r = rand.nextInt(n)
            def prev = numbers[i]
            numbers[i] = numbers[r]
            numbers[r] = prev
        }

        println()
        println "random:"
        println numbers
        println()
        println()

        quicksort(0, n - 1);

        println()
        println "after sort:"
        println numbers

    }


    static quicksort(int low, int high) {
        int i = low, j = high;

        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];
        //int pivot = numbers[low + (high - low) / 2];


        println " ${indent(pivot)}V"

        // Divide into two lists
        while (i <= j) {

            println " ${indent(i)}L"
            println " ${indent(j)}H"

            println numbers

            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    static exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    static String indent(int level) {
        def s = ""
        for (int i = 0; i < level; i++) {
            if (numbers[i] <10)
                s = s + "   "
            else
                s = s + "    "
        }
        return s
    }
}