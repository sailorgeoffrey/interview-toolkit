package algo

class AnagramHash {

    static String calculateSignature(String word) {
        def chars = word.toCharArray()
        Arrays.sort(chars)
        return new String(chars)
    }

    public static void main(String[] args) {

        def words = ["pots", "stop", "tops", "top", "flop", "to", "mississippi"]

        def data = [:]

        for (word in words) {
            def sig = calculateSignature(word);
            def bucket = data.get(sig)
            if (bucket == null) bucket = []
            bucket.add(word)                                                                                                                                                        7
            data.put(sig, bucket)
        }

        println data

    }

}
