public class Main {
    static final int N = 8;
    static int[] board = new int[N];

    public static void main(String[] args) {

        System.out.println("Hello world!");
        placeQueen(0);
    }

    //shit vanskelig men baserer seg på permutasjon av en string hvor man flytter radvis basert på løkka i og rekursivt
    //vil pos+1 flytte oss kolonnevis
    public static boolean placeQueen(int pos) {
        if (pos == N) {
            printSolution();
            return true;
        }
        boolean funnet = false;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(pos, i)) {
                board[pos] = i;
                funnet = placeQueen(pos + 1) || funnet;
            }
        }
        return funnet;
    }
    //sjekker om den er trygg ved å iterere gjennom radene og for hver rad se om x == col eller om differansen mellom
    //x og col er samme som differansen mellom i (raden vi er på i løkka) og rad (raden vi plasserte dronningen)

    public static boolean isSafe(int rad, int col) {
        for (int i = 0; i < rad; i++) {
            int x = board[i];
            if (x == col || Math.abs(x - col) == Math.abs(i - rad)) {
                return false;
            }
        }
        return true;
    }

    //loop gjennom 1d array som en 2d array med nestet for loops for å prine ut "sjakkbrettet"
    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("· ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}