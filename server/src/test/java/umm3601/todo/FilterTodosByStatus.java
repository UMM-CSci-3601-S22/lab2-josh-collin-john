package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


/*
  Tests getting todos by Status.
*/

public class FilterTodosByStatus {

  @Test
  public void filterTodosByStatus() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    queryParams.put("status",Arrays.asList(new String[] {"incomplete"}));
    Todo[] statusIncompleteTodos = db.listTodos(queryParams);
    assertEquals(157, statusIncompleteTodos.length, "Incorrect number of todos with status incomplete");

  }

}
