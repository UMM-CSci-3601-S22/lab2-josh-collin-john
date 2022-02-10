package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;


/*
  Tests getting todos by Id.
*/

@SuppressWarnings({ "MagicNumber" })
public class FilterTodosByOwner {

  @Test
  public void filterTodosByOwner() throws IOException {

    TodoDatabase db = new TodoDatabase("/todos.json");
    Map<String, List<String>> queryParams = new HashMap<>();

    queryParams.put("owner", Arrays.asList(new String[] {"Blanche"}));
    Todo[] ownerBlancheTodos = db.listTodos(queryParams);
    assertEquals(43, ownerBlancheTodos.length, "Incorrect number of todos with owner Blanche");

  }

}
