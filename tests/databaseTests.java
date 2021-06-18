import org.junit.jupiter.api.Test;
import other.ProgrammingTool;

import static org.junit.jupiter.api.Assertions.*;

public class databaseTests {
    @Test
    void getConnectionForDatabaseTest() {
        String dbName = "ProgrammingToolDatabase";
        assertNotNull(ProgrammingTool.getConnection());
    }
}
