package Problems;

import Automata.NFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem8
{
    int states = 5;
    int[] startState = {0};
    int[] finalState = {4};
    char[] alphabet = {'a', 'b'};

    Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{0, 1}, {0}}),
            entry(1, new int[][]{{-1}, {2}}),
            entry(2, new int[][]{{2, 3}, {2}}),
            entry(3, new int[][]{{-1}, {4}}),
            entry(4, new int[][]{{4}, {4}})
    );
    NFA nfa = new NFA(states,startState,finalState,alphabet,transitionTable);

    public Problem8(BufferedReader br, BufferedWriter bw) throws IOException {
        bw.write("8\n");
        nfa.solveProblem(br,bw);
    }
}