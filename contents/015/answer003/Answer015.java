public class Answer015 {
    private String name;

    Answer015() {
      this.name = "no name";
    }
    Answer015(String name) {
      this.name = name;
    }

    public static void main(String arguments[]) {
        System.out.println(new Answer015().name);
        System.out.println(new Answer015("hoge").name);
    }
}
