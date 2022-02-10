package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


/*
  Tests getting todos by category.
*/

public class FilterTodosByCategory {

  @Test
  public void filterTodosByCategory() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    queryParams.put("category",Arrays.asList(new String[] {"video games"}));
    Todo[] CategoryVideoGamesTodos = db.listTodos(queryParams);
    assertEquals(71, CategoryVideoGamesTodos.length, "Incorrect number of todos with Category Video Games");

  }

}
