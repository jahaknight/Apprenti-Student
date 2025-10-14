package learn.memories.data;

import learn.memories.data.mappers.MemoryMapper;
import learn.memories.models.Memory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

public class MemoryJdbcRepository implements MemoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemoryJdbcRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Memory> findAll() throws DataAccessException {
        final String sql = getSelectQuery() + ";";

        MemoryMapper mapper = new MemoryMapper();

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Memory findById(int memoryId) throws DataAccessException {
        final String sql = getSelectQuery() +
                " WHERE memory.memory_id =?;";

        MemoryMapper mapper = new MemoryMapper();

        try {
            return jdbcTemplate.queryForObject(sql, mapper, memoryId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Memory> findShareable(boolean shareable) throws DataAccessException {
        final String sql = getSelectQuery() +
                " WHERE is_public =  true;";

        MemoryMapper mapper = new MemoryMapper();

        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Memory add(Memory memory) throws DataAccessException {
        final String sql = "INSERT INTO `memories`.`memory`\n" +
                    "(`memory_id`," +
                    "`user_id_created`," +
                    "`date_time_created`," +
                    "`memoryText`," +
                    "`is_public`)" +
                    "VALUES" +
                "(?, NOW(), ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement()
        })

    }

    @Override
    public boolean update(Memory memory) throws DataAccessException {
        return false;
    }

    @Override
    public boolean deleteById(int memoryId) throws DataAccessException {
        return false;
    }

    private String getSelectQuery () {
        return  "SELECT memory.memory_id, " +
                "user.user_name, " +
                "memory.date_time_created, " +
                "memory.memoryText, " +
                "memory.is_public " +
                "FROM memory " +
                "INNER JOIN user " +
                "ON memory.user_id_created = user.user_id";
    }

}
