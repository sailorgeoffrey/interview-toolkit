package bitmap

class BinarySort {


    public static void main(String[] args) {

        def k = 12314
        def n = 27000

        def x = []

        def start = System.currentTimeMillis()

        for (i in 0..n - 1) {
            x[i] = i
        }

        //println x

        def rand = new Random()
        for (i in 0..k - 1) {
            def r = rand.nextInt(k)
            def prev = x[i]
            x[i] = x[r]
            x[r] = prev
        }

        //println x

        x = x[0..k - 1].collect { it as int } as int[]

        //println x

        def y = []
        for (int i in x) {
            y[i] = i
        }

        //println y

        def end = System.currentTimeMillis()

        println(end - start)
    }

}
