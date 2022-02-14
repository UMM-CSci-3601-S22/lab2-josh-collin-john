package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/*
  Tests sorting todos by status, completed last.
*/

public class SortTodosByStatus {

  @Test
  public void testStatusSort() throws IOException {
    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new LinkedHashMap<>();

    queryParams.put("orderBy", Arrays.asList(new String[] {"status"}));
    Todo[] sortedTodos = db.sortTodosByStatus();
    System.out.println(sortedTodos);
    assertTrue(sortedTodos[sortedTodos.length - 1].status);
    assertFalse(sortedTodos[0].status);
  }
}
