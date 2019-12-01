package BloombergPractice;

//380. Insert Delete GetRandom O(1)
// Design a data structure that supports all following operations in average O(1) time.
//
// insert(val): Inserts an item val to the set if not already present.
// remove(val): Removes an item val from the set if present.
// getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.


import java.util.ArrayList;
import java.util.List;

public class RandomizedSet {

    List<Integer> randomizeSet;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        randomizeSet = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (!randomizeSet.contains(val))
            return randomizeSet.add(val);
        else
            return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer removedVal = null;

        if (randomizeSet.contains(val)) {
            int indexOfVal = randomizeSet.indexOf(val);
            randomizeSet.remove(indexOfVal);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        double randomDouble = Math.random() * randomizeSet.size();
        int randomNumber = (int) randomDouble;
        return randomizeSet.get(randomNumber);
    }

}
