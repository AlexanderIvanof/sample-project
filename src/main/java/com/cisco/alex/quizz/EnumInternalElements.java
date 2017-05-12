package com.cisco.alex.quizz;

/**
 * Fruits enum.
 *
 * @author oleivano
 */
enum Fruits {
    APPLE("sweet"),
    CHERRY("sweet-sour"),
    MANGOSTEEN("sweet and tangy") {
        public String getColor() {
            return "deep reddish-purple";
        }
    };

    private String taste;

    Fruits(String taste) {
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

}

public class EnumInternalElements {

    public static void main(String[] args) {
        Fruits apple = Fruits.APPLE;
        Fruits cherry = Fruits.CHERRY;
        Fruits mangosteen = Fruits.MANGOSTEEN;

        final int appleMethods = apple.getClass().getDeclaredMethods().length;
        final int cherryMethods = cherry.getClass().getDeclaredMethods().length;
        final int mangosteenMethods = mangosteen.getClass().getDeclaredMethods().length;

        System.out.println(appleMethods == cherryMethods);
        System.out.println(appleMethods == mangosteenMethods);

        System.out.println(apple.getClass() == cherry.getClass());
        System.out.println(apple.getClass() == mangosteen.getClass());
    }
}
