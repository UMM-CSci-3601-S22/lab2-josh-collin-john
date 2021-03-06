package umm3601.todo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
//import io.javalin.http.BadRequestResponse;

/*
  Mock database class for todo objects, mirrors /user/UserDatabase.java
*/

public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDatabaseFile) throws IOException {
    InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream(todoDatabaseFile));
    ObjectMapper objectMapper = new ObjectMapper();
    allTodos = objectMapper.readValue(reader, Todo[].class);
  }

  public int size() {
    return allTodos.length;
  }

  /**
   * Get the single user specified by the given ID. Return `null` if there is no
   * user with that ID.
   *
   * @param id the ID of the desired todo
   * @return the todo with the given ID, or null if there is no user with that ID
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all the Todos satisfying the queries in the params.
   *
   * @param queryParams map of key-value pairs for the query
   * @return an array of all the todos matching the given criteria
   */
  public Todo[] listTodos(Map<String, List<String>> queryParams) {
    Todo[] filteredTodos = allTodos;

    // Filter by Owner
    if (queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner").get(0);
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    // filter by Category
    if (queryParams.containsKey("category")) {
      String targetCategory = queryParams.get("category").get(0);
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }

    // filter by body contents
    if (queryParams.containsKey("contains")) {
      String targetBody = queryParams.get("contains").get(0);
      filteredTodos = filterTodosByBody(filteredTodos, targetBody);
    }

    // filter by status
    if (queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status").get(0);
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    // limit number of visible todos
    if (queryParams.containsKey("limit")) {
      Integer targetLimit = Integer.parseInt(queryParams.get("limit").get(0));
      filteredTodos = limitDisplayedTodos(filteredTodos, targetLimit);
    }

    return filteredTodos;
  }

  public Todo[] filterTodosByOwner(Todo[] todos, String targetOwner) {
    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByCategory(Todo[] todos, String targetCategory) {
    return Arrays.stream(todos).filter(x -> x.category.equals(targetCategory)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByBody(Todo[] todos, String targetBody) {
    return Arrays.stream(todos).filter(x -> x.body.contains(targetBody)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByStatus(Todo[] todos, String targetStatus) {
    Boolean realStatus;
    if (targetStatus.equals("complete")) {
      realStatus = true;
    } else {
      realStatus = false;
    }

    return Arrays.stream(todos).filter(x -> x.status == realStatus).toArray(Todo[]::new);
  }

  public Todo[] sortTodosByCategory() {
    Todo[] sortedTodos = allTodos;
    Arrays.sort(allTodos, new Comparator<Todo>() {
      public int compare(Todo t1, Todo t2) {
        return t1.category.compareTo(t2.category);
      }
    });

    return sortedTodos;
  }

  public Todo[] sortTodosByBody() {
    Arrays.sort(allTodos, new Comparator<Todo>() {
      public int compare(Todo t1, Todo t2) {
        return t1.body.compareTo(t2.body);
      }
    });

    return allTodos;
  }

  public Todo[] sortTodosByStatus() {
    Arrays.sort(allTodos, new Comparator<Todo>() {
      public int compare(Todo t1, Todo t2) {
        return (t1.status && !t2.status) ? 1 : -1;
      }
    });

    return allTodos;
  }

  public Todo[] limitDisplayedTodos(Todo[] todos, Integer targetLimit) {
    return Arrays.stream(todos).limit(targetLimit).toArray(Todo[]::new);
  }
}
