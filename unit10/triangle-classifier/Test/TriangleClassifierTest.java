import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @org.junit.jupiter.api.Test
    void testClassifierCan() {
        int a = 5;
        int b = 5;
        int c = 8;
        String expected = "Tam giac can";

        String result = TriangleClassifier.classifier(a,b,c);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void testClassifierDeu() {
        int a = 5;
        int b = 5;
        int c = 5;
        String expected = "Tam giac deu";

        String result = TriangleClassifier.classifier(a,b,c);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void testClassifierThuong() {
        int a = 2;
        int b = 3;
        int c = 4;
        String expected = "Tam giac thuong";

        String result = TriangleClassifier.classifier(a,b,c);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void testClassifierNotTriangle() {
        int a = 2;
        int b = 3;
        int c = 5;
        String expected = "Not triangle";

        String result = TriangleClassifier.classifier(a,b,c);
        assertEquals(expected, result);
    }
}