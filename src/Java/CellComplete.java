import java.util.Arrays;
import java.util.List;

public class CellComplete {

    public Integer[] getPreviousState(Integer [] newStates) {
        Integer [] previousStates = new Integer [newStates.length + 2];
        previousStates[0] = 0;
        previousStates[previousStates.length - 1] = 0;
        for (int i = 0; i < 8; i++) {
            previousStates[i+1] = newStates[i];
        }

        return previousStates;
    }


    public List<Integer> cellCompete(int[] states, int days)
    {
        Integer [] convertedStates = new Integer[states.length];

        for (int i = 0; i < states.length; i++) {
            convertedStates[i] = states[i];
        }

        Integer [] previousStates = getPreviousState(convertedStates);
        Integer [] newStates = new Integer[states.length];

        int a, b;
        while (days > 0) {
            for (int i = 1; i < previousStates.length - 1; i++) {
                a = previousStates[i-1];
                b = previousStates[i+1];
                newStates[i-1] = a ^ b;
            }
            previousStates = getPreviousState(newStates);
            days --;
        }

        return Arrays.asList(newStates);
    }
}
