package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/*
  Tests sorting todos alphabetically by category.
*/

public class SortTodosByCategory {

  @Test
  public void testCategorySort() throws IOException {
    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new LinkedHashMap<>();

    queryParams.put("orderBy", Arrays.asList(new String[] {"category"}));
    Todo[] sortedTodos = db.sortTodosByCategory();
    assertEquals("groceries", sortedTodos[0].category);
  }
}
