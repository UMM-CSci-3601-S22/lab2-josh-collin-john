package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


/*
  Tests getting todos by Limit.
*/

@SuppressWarnings({ "MagicNumber" })
public class FilterTodosByLimit {

  @Test
  public void filterTodosByLimit() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    queryParams.put("limit", Arrays.asList(new String[] {"8"}));
    Todo[] limit8Todos = db.listTodos(queryParams);
    assertEquals(8, limit8Todos.length, "Incorrect number of todos displayed");

  }

}
