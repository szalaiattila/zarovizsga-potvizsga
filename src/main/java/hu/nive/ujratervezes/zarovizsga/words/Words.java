package hu.nive.ujratervezes.zarovizsga.words;


public class Words {
    public boolean hasMoreDigits(String s) {


        int digits =0;
        for (char item:s.toCharArray()) {
            if (item >= '0' && item <= '9') {
                digits++;
            }
            else {
                digits--;
            }
        }
        return digits > 0;
    }
}

