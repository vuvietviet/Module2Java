public class TriangleClassifier {
    public static String classifier(int a, int b, int c) {
        String show = "Not triangle";
        if (a + b > c && a + c > b && b + c > a) {
            show = "Tam giac thuong";
            if ((a == b && a!= c)|| (a == c && a!= b)|| (b == c && b!= a)) {
                show = "Tam giac can";
            } else if (a == b && b == c) {
                show = "Tam giac deu";
            }
        }
        return show;
    }
}
