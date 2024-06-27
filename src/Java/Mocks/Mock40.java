package Mocks;

public class Mock40 {

    public String restoreString(String s, int[] indices) {

        StringBuilder newStr = new StringBuilder(s.length());

        for (int i = 0; i < indices.length/2; i++) {

            newStr.setCharAt(indices[i], s.charAt(i));

        }

        return newStr.toString();
    }

}
