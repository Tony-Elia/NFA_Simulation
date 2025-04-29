package Problems;
import Automata.NFA;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;
import static java.util.Map.entry;

public class Problem9 {
    int states = 5;
int[] startState = {0};
int[] finalState = {0, 1, 2, 4};
char[] alphabet = {'0', '1'};

Map<Integer, int[][]> transitionTable = Map.ofEntries(
    entry(0, new int[][]{{0}, {0, 1}}), 
    entry(1, new int[][]{{2}, {1}}),    
    entry(2, new int[][]{{3}, {1}}),   
    entry(3, new int[][]{{3}, {3}}),    
    entry(4, new int[][]{{4}, {4}})    
);

NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

public Problem9(BufferedReader br, BufferedWriter bw) throws IOException {
    bw.write("9\n");
    nfa.solveProblem(br, bw);
}
}
