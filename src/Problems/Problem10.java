package Problems;

import Automata.NFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem10
{
    int states = 4;
    int[] startState = {0};
    int[] finalState = {0, 1, 3}; 
    char[] alphabet = {'0', '1'};

    Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{0}, {1}}),
            entry(1, new int[][]{{2}, {1}}),
            entry(2, new int[][]{{0}, {1}}),
            entry(3, new int[][]{{3}, {3}})
    );

    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem10(BufferedReader br, BufferedWriter bw) throws IOException {
        bw.write("10\n");
        nfa.solveProblem(br, bw);
    }
}