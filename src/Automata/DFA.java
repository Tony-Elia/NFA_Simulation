package Automata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class DFA
{
    int noOfStates, startState;
    int[] finalStates;
    char[] alphabet;
    Map<Integer, int[]> transitionTable;
    String str;

    public DFA(int noOfStates, int startState, int[] finalStates, char[]
            alphabet, Map<Integer, int[]> transitionTable) {
        this.noOfStates = noOfStates;
        this.startState = startState;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }

    public boolean isAccepted(String input)
    {
        str = input;
        return traverse(0, startState);
    }

    public boolean traverse(int cursor, int state) {
        int[] stateTransition = transitionTable.get(state);

        if(cursor >= str.length() || stateTransition == null) { // Base Case
            return isFinalState(state);
        }

        int nextChar = charAtAlphabet(str.charAt(cursor)); // Consume the next char in the string
        return traverse(cursor + 1, stateTransition[nextChar]);
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