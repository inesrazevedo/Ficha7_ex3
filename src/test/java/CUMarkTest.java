import org.example.CU;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CUMarkTest {
    @ParameterizedTest
    @CsvSource({ "1, 8.0", "2, 10.0", "3, 7.5" })
    void testInserirNotaCU(int numAluno, double nota) {
        CU cu = new CU("Matemática", 3);
        cu.insertMarkCU(numAluno, nota);
        assertEquals(nota, cu.searchStudent(numAluno));
    }

    @ParameterizedTest
    @CsvSource({ "1, 8.0, false", "2, 10.0, true", "3, 7.5, false" })
    void testEstaAprovado(int numAluno, double nota, boolean esperado) {
        CU cu = new CU("Matemática", 3);
        cu.insertMarkCU(numAluno, nota);
        assertEquals(esperado, cu.isApproved(numAluno));
    }

    @Test
    void testMediaCU() {
        CU cu = new CU("Matemática", 3);
        cu.insertMarkCU(1, 8.0);
        cu.insertMarkCU(2, 10.0);
        cu.insertMarkCU(3, 7.5);
        assertEquals(8.5, cu.averageCU(), 0.01);
    }
}

