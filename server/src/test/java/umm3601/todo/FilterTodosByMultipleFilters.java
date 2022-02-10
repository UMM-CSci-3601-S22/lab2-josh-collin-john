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

public class FilterTodosByMultipleFilters {

  @Test
  public void FilterByMultiple() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    queryParams.put("owner",Arrays.asList(new String[] {"Barry"}));
    queryParams.put("category",Arrays.asList(new String[] {"video games"}));
    queryParams.put("status",Arrays.asList(new String[] {"complete"}));
    Todo[] MultipleFilterTodos = db.listTodos(queryParams);

    assertEquals(4, MultipleFilterTodos.length, "Incorrect number of todos displayed");

  }

}