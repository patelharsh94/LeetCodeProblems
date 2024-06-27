import org.junit.Test;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        int subStrSize = 0;
        boolean stopLoop = false;

        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 0) {
            return "";
        }
        else {
            while (!stopLoop) {
                for (int i = 1; i < strs.length; i++) {

                    if (strs[i-1].length() == 0
                            || strs[i].length() == 0
                            || subStrSize >= strs[i].length()
                            || subStrSize >= strs[i-1].length()
                            || strs[i].charAt(subStrSize) != strs[i-1].charAt(subStrSize)) {
                        stopLoop = true;
                        break;
                    }
                }

                if (!stopLoop) {
                    subStrSize++;
                }
            }

            return strs[0].substring(0, subStrSize);
        }
    }

    @Test
    public void test() {

        String [] strs = {"ab","a"};
        longestCommonPrefix(strs);
    }
}
