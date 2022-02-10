package umm3601.todo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
* A fake database from JSON file for todos.json.
* Mirrors /user/UserDatabase.java
*/

public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String inputFile) throws IOException {
    InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream(inputFile));
    ObjectMapper mapper = new ObjectMapper();
    allTodos = mapper.readValue(reader, Todo[].class);
  }

  /**
   * Get the single user specified by the given ID. Return `null` if there is no
   * user with that ID.
   *
   * @param id the ID of the desired user
   * @return the user with the given ID, or null if there is no user with that ID
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

}
