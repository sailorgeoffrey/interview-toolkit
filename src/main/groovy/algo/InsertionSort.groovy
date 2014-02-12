package algo

class InsertionSort {


    public static void main(String[] args) {

        def n = 50

        int[] x = new int[n]

        for (i in 0..n - 1) {
            x[i] = i
        }

        println()
        println "original:"
        println x

        def rand = new Random()
        for (i in 0..n - 1) {
            def r = rand.nextInt(n)
            def prev = x[i]
            x[i] = x[r]
            x[r] = prev
        }

        println()
        println "random:"
        println x


        int i;

        for (int j = 1; j < x.length; j++) {
            def key = x[j];
            for (i = j - 1; (i >= 0) && (x[i] < key); i--) {   // Smaller values are moving up
                x[i + 1] = x[i];
            }
            x[i + 1] = key;    // Put the key in its proper location
            println x
        }

        println()
        println "after sort:"
        println x
    }

}