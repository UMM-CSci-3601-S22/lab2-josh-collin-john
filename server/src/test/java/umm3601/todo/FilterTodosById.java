package umm3601.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;


/*
  Tests getting todos by Id.
*/

public class FilterTodosById {

  @Test
  public void getTodo58895985a22c04e761776d54() throws IOException {
    TodoDatabase db = new TodoDatabase("/todos.json");
    Todo todo = db.getTodo("58895985a22c04e761776d54");
    assertEquals("Blanche", todo.owner, "Incorrect owner.");
  }

  @Test
  public void getTodo58895985ae3b752b124e7663() throws IOException {
    TodoDatabase db = new TodoDatabase("/todos.json");
    Todo todo = db.getTodo("58895985ae3b752b124e7663");
    assertEquals("Fry", todo.owner, "Incorrect owner.");
  }

}
