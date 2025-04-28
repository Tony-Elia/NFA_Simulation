package Problems;

import Automata.DFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem1
{
    int states = 2;
    int startState = 0;
    int[] finalState = {1};
    char[] alphabet = {'a', 'b'};
    Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 0}),
            entry(1, new int[]{0, 1})
    );
    DFA dfa = new DFA(states,startState,finalState,alphabet,transitionTable);

    public Problem1(BufferedReader br, BufferedWriter bw) throws IOException {
        bw.write("1\n");
        dfa.solveProblem(br,bw);
    }
}