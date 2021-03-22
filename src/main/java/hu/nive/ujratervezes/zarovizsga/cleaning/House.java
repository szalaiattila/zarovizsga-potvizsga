package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable{

    public static final int HOUSE_PRICE_PER_SQRM = 80;
    private final String address;

    private final int area;

    public House(String address, int area) {
        this.area = area;
        this.address = address;
    }


    @Override
    public int clean() {
        return area * HOUSE_PRICE_PER_SQRM;
    }


    @Override
    public String getAddress() {
        return address;
    }
}
