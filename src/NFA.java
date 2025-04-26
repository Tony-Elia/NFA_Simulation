import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class NFA
{
    int noOfStates;
    int[] startStates, finalStates;
    char[] alphabet;
    Map<Integer, int[][]> transitionTable;
    String str;
    int epsilon = -1;

    public NFA(int noOfStates, int[] startStates, int[] finalStates, char[]
            alphabet, Map<Integer, int[][]> transitionTable) {
        this.noOfStates = noOfStates;
        this.startStates = startStates;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
        this.epsilon = charAtAlphabet('E'); // Get the epsilon index
    }

    public boolean isAccepted(String input)
    {
        str = input;
        boolean res = false;
        for(int i : startStates) {
           res |= dfs(0, i);
        }
        return res;
    }

    public boolean dfs(int cursor, int state) {
        int[][] stateTransition = transitionTable.get(state);
        boolean res = false;
        if (epsilon != -1 && stateTransition != null) {
            for (int i : stateTransition[epsilon]) { // consume the eplison first
                res |= dfs(cursor, i);
            }
        }

        if(cursor >= str.length() || stateTransition == null) { // Base Case
            return res || isFinalState(state);
        }

        int nextChar = charAtAlphabet(str.charAt(cursor)); // Consume the next char in the string
        for (int i : stateTransition[nextChar]) { // dfs on all possible transitions for this char
            res |= dfs(cursor + 1, i);
        }
        return res;
    }

    private int charAtAlphabet(char target) {
        for (int i = 0; i < alphabet.length; i++) {
            if(target == alphabet[i]) return i;
        } return -1;
    }

    private boolean isFinalState(int target) {
        for (int num : finalStates) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) {
        try {
            bw.write("7\n");
            String str = br.readLine();
            while (!str.equals("end")) {
                bw.write((isAccepted(str) ? "True\n" : "False\n"));
                str = br.readLine();
            }
            bw.write("x\n");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}