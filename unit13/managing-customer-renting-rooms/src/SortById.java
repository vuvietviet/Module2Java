import java.util.Comparator;

public class SortById implements Comparator<Nguoi> {
    @Override
    public int compare(Nguoi o1, Nguoi o2) {
        return (int) (o1.getSoCMND() - o2.getSoCMND());
    }
}
