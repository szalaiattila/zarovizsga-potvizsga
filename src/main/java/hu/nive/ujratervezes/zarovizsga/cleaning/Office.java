package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    public static final int OFFICE_PRICE_PER_SQRM = 100;
    private final String address;

    private final int area;

    private final int levels;

    public Office(String address, int area, int levels) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    @Override
    public int clean() {
        return levels * area * OFFICE_PRICE_PER_SQRM;
    }

    @Override
    public String getAddress() {
        return address;
    }


}
