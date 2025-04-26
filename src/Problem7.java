import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Map;

import static java.util.Map.entry;

public class Problem7
{
    int states = 9;
    int[] startState = {0};
    int[] finalState = {4, 5, 7, 8};
    char[] alphabet = {'0', '1'};

    Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{1}, {2}}),
            entry(1, new int[][]{{3}, {4}}),
            entry(2, new int[][]{{5},{6}}),
            entry(3, new int[][]{{-1}, {4}}),
            entry(4, new int[][]{{5}, {7}}),
            entry(5,new int[][]{{8}, {4}}),
            entry(6,new int[][]{{5}, {-1}}),
            entry(7,new int[][]{{5}, {-1}}),
            entry(8,new int[][]{{-1}, {4}})
    );
    NFA nfa = new NFA(states,startState,finalState,alphabet,transitionTable);

    public Problem7 (BufferedReader br, BufferedWriter bw)
    {
        nfa.solveProblem(br,bw);
    }
}