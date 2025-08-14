//  Largest 3-Same-Digit Number in String - 2264

class Solution {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String s = String.valueOf(i).repeat(3);
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }
}