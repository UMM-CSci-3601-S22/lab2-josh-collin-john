package umm3601.todo;

/*
* A wrapper class for Todo objects from todos.json.
* Mirrors /user/User.java
*/

@SuppressWarnings({"VisibilityModifier"})
public class Todo {
  @SuppressWarnings({"MemberName"})
  public String _id;
  public String owner;
  public boolean status;
  public String body;
  public String category;
}
