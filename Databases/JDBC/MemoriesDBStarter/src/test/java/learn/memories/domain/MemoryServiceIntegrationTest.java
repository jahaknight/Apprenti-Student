package learn.memories.domain; // Use the correct package for your test

import learn.memories.data.DataAccessException;
import learn.memories.models.Memory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 1. Use the SpringJUnitConfig annotation
// (or @ExtendWith(SpringExtension.class) + @ContextConfiguration)
@SpringJUnitConfig
@ContextConfiguration(locations = {"classpath:dependency-configuration.xml"}) // 2. Point to your XML file
class MemoryServiceIntegrationTest {

    // 3. Autowire the production service bean created by Spring
    @Autowired
    MemoryService service;

    // The @BeforeEach method is no longer needed since Spring handles setup.

    @Test
    void shouldFindAll() throws DataAccessException {
        // NOTE: For this test to pass, your configured database must contain exactly 10 records.
        // It's usually better to test for a successful read (size > 0)
        // and test specific data in other tests.

        List<Memory> memories = service.findAllMemories();

        // Assert that we successfully read data from the database
        //assertTrue(memories.size() > 0, "Should return records from the JDBC repository.");

        // If you are confident your test data setup is exactly 10:
        assertEquals(10, memories.size());
    }

    @Test
    void shouldFindShareable() throws DataAccessException {
        List<Memory> memories = service.findShareableMemories();

        assertEquals(5, memories.size());
        System.out.println(memories);
    }

    @Test
    void shouldAdd () throws DataAccessException{

    }

}

