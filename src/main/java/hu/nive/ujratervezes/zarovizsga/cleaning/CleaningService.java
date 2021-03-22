package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class CleaningService {

    private List<Cleanable> cleanables;

    public CleaningService() {
        cleanables = new ArrayList<>();
    }

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int result = (int) cleanables.stream().collect(Collectors.summarizingInt(Cleanable::clean)).getSum();
        cleanables.clear();
        return result;
    }

    public int cleanOnlyOffices() {
        Iterator<Cleanable> it = cleanables.iterator();
        int result = 0;
        while (it.hasNext()) {
            Cleanable cleanable = it.next();
            if (cleanable.getClass() == Office.class) {
                result = result + cleanable.clean();
                it.remove();
            }
        }
        return result;
    }

    public List<Cleanable> findByAddressPart(String s) {
        return cleanables.stream().filter(cleanable -> cleanable.getAddress().contains(s)).collect(Collectors.toList());
    }


    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable item:cleanables) {
            sb.append(item.getAddress());
            sb.append(", ");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        return sb.toString();
    }
}

