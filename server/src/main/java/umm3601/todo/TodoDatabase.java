package umm3601.todo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.BadRequestResponse;

/*
  Mock database class for todo objects, mirrors /user/UserDatabase.java
*/

public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDatabaseFile) throws IOException{
    InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream(todoDatabaseFile));
    ObjectMapper objectMapper = new ObjectMapper();
    allTodos = objectMapper.readValue(reader, Todo[].class);
  }

  public int size(){
    return allTodos.length;
  }


}
