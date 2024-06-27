public class ReverseIntegers {

    public int reverse(int x) {
        String intVal = String.valueOf(x);
        StringBuilder sb = new StringBuilder(intVal);

       sb = sb.reverse();

       if (x < 0) {
           sb.deleteCharAt(intVal.length()-1);
       }

       try {
           return x < 0 ? Integer.parseInt(sb.toString()) * -1 : Integer.parseInt(sb.toString());
       } catch (NumberFormatException e) {
           return 0;
       }
    }
}
