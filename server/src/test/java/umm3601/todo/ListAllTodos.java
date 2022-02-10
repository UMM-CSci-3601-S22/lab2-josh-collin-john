package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


/*
  Tests getting todos by Limit.
*/

@SuppressWarnings({ "MagicNumber" })
public class ListAllTodos {

  @Test
  public void listAllTodos() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    Todo[] listAllTodos = db.listTodos(queryParams);
    assertEquals(300, listAllTodos.length, "Incorrect number of todos displayed");

  }

}
