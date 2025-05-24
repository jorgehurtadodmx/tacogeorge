package george.taco_cloud.repository;

import george.taco_cloud.entities.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredients> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from Ingredient",
                this::mapRowToIngredient);

    }


    @Override
    public Optional<Ingredients> findById(String id) {
        List<Ingredients> results = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
        //return Optional.empty();
    }


    //how to insert rows
    @Override
    public Ingredients save(Ingredients ingredients) {
        jdbcTemplate.update(
                "insert into Ingredients (id, name, type) values (?, ?, ?)",
                ingredients.getId(),
                ingredients.getName(),
                ingredients.getType().toString());
                return ingredients;



    }
    // mas info en p95, mostly irrelevant
    private Ingredients mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredients(
                row.getString("id"),
                row.getString("name"),
                Ingredients.Type.valueOf(row.getString("type"))
        );
    }
}
