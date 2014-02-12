package proof

class CoffeeCan {

    public static void main(String[] args) {

        int x = 11;

        while (x != 1) {

            println x

            if (x % 2 == 0) {
                x = x / 2
            } else {
                x = 3 * x + 1
            }

        }

        println x
    }
}
