import java.util.Comparator;

public class SortByBirthDay implements Comparator<Nguoi> {
    @Override
    public int compare(Nguoi o1, Nguoi o2) {
        return o1.getNgaySinh().getYear() - o2.getNgaySinh().getYear();
    }
}
