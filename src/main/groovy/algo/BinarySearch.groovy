package algo

class BinarySearch {

    //Missing 17
    static int[] whitelist = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20]

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    static check(int test) {
        return rank(test, whitelist) == -1
    }

    public static void main(String[] args) {

        for (a in (1..20)) {

            if (check(a)) println ("found it!  it's $a")

        }

    }
}
