import org.junit.Test;

public class CompareVersionNumbers {

    // 165. Compare Version Numbers

    public int compareVersion(String version1, String version2) {

        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");

        int len = v1.length > v2.length ? v1.length : v2.length;

        for (int i = 0; i < len; i++) {
            int v1Int = v1.length > i ? Integer.valueOf(v1[i]) : 0;
            int v2Int = v2.length > i ? Integer.valueOf(v2[i]) : 0;

            if (v1Int > v2Int)
                return  1;
            else if (v1Int < v2Int)
                return -1;
        }

        return 0;
    }

    @Test
    public void test() {
        System.out.println(compareVersion("1.0.1", "1"));
    }
}
