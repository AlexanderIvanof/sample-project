package com.cisco.alex.quizz;

import java.util.ArrayList;
import java.util.List;

interface AInterface {

    void doSomething();

    default String name() {
        return "NONE";
    }
}


enum Workers implements AInterface {
    BUILDER {
        @Override
        public void doSomething() {
            System.out.println(name() + "is doing something");
        }
    }
}

class CustomWorker implements AInterface {

    private String profession;

    public CustomWorker(String profession) {
        this.profession = profession;
    }

    @Override
    public void doSomething() {
        final String is = String.join("is", profession != null ? profession : "EMPTY", " working");
        System.out.println(is);
    }
}

/**
 * @author oleivano
 */
public class EnumWithOtherInOneCollection {

    public static void main(String[] args) {
        List<AInterface> all = new ArrayList<>();
        all.add(Workers.BUILDER);
        all.add(new CustomWorker("Miner"));

        all.stream().map(AInterface::name).forEach(System.out::println);

        all.forEach(it -> System.out.println(it.name()));
    }
}
