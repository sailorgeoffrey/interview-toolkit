package algo

class PhoneWords {

    static map = [
            '0': "",
            '1': "",
            '2': "abc",
            '3': "def",
            '4': "ghi",
            '5': "jkl",
            '6': "mno",
            '7': "pqrs",
            '8': "tuv",
            '9': "wxyz"
    ]

    static letterCombinations(String digits) {
        def res = [""]
        def preres = []

        for (int i = 0; i < digits.length(); i++) {
            for (str in res) {
                def letters = map.get(digits.charAt(i).toString())
                for (int j = 0; j < letters.length(); j++) {
                    preres.add(str + letters.charAt(j))
                }
            }
            res = preres;
            preres = []
        }
        return res;
    }

    public static void main(String[] args) {
        println letterCombinations("3108014192")
        println letterCombinations("2367755587")
    }


}
