package com.cisco.alex.quizz;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        List<String> listOfStrings = Arrays.asList("Helllo", "wrld");

        String reduce = listOfStrings.stream().reduce(" ", (a, b) -> a + "'" + b + "',", (a, b) -> a + b+1);
//        System.out.println(reduce);
        String tested = "tuytu'347rf789','hhooo8779'";
        Pattern ptrn = Pattern.compile("\'(.+?)\'", Pattern.DOTALL);

        final Matcher matcher = ptrn.matcher(tested);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    public static void mainq(String[] args) {
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
