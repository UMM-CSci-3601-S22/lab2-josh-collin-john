package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/*
  Tests getting todos by body contents.
*/

@SuppressWarnings({ "MagicNumber" })
public class FilterTodosByBody {

  @Test
  public void filterTodosByBody() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    queryParams.put("contains", Arrays.asList(new String[] {"voluptate"}));
    Todo[] bodyVoluptateTodos = db.listTodos(queryParams);
    assertEquals(85, bodyVoluptateTodos.length, "Incorrect number of todos with body contents Voluptate");

  }

}
