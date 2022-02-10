package umm3601.todo;

/*
  Wrapper class for a given todo from /resources/todos.json,
  mirroring /user/User.java
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
