public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Prime numbers up to " + n + ":");
        printPrimes(n);
    }

    public static void printPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];

        int i = 2;
        while (i <= n) {
            isPrime[i] = true;
            i++;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int multiple = p * p;
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += p;
                }
            }
            p++;
        }

        int j = 2;
        int count = 0;
        while (j <= n) {
            if (isPrime[j]) {
                System.out.println(j);
                count++;
            }
            j++;
        }
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + (int) ((double) count / n * 100)
                + "% are primes)");
    }
}