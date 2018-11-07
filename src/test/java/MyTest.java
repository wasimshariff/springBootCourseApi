import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String a[]) {
        List<String> listStr = Arrays.asList(
                "wasim","nadeem","zara");
        listStr.stream()
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        persons.forEach(System.out::println);
        String test ="wasim";
        persons.stream()
                .collect(Collectors.toMap((p) -> p.name, Function.identity()));

       String names =  persons.stream()
                .collect(
                        () -> new StringJoiner("|"),
                        (StringJoiner response, Person elem) -> response.add(elem.toString()),
                        (StringJoiner p1, StringJoiner p2) -> p1.merge(p2)

                ).toString();
        System.out.println(names);


        Collector<Person, StringJoiner, String> myCollector =  Collector.of(
                 () -> new StringJoiner("|"),
                 (StringJoiner resp, Person p) -> resp.add(p.toString()),
                 (StringJoiner resp, StringJoiner resp1) -> resp.merge(resp1),
                 (StringJoiner result) -> result.toString()
         );

        Collector<Person, StringJoiner, StringJoiner> myCollector1 =  Collector.of(
                () -> new StringJoiner("|"),
                (StringJoiner resp, Person p) -> resp.add(p.toString()),
                (StringJoiner resp, StringJoiner resp1) -> resp.merge(resp1),
                (StringJoiner result) -> result
        );

        String obj =  persons.stream()
                .collect(myCollector);
        System.out.println(obj);


        Collector<Person, StringJoiner, StringJoiner> myCollector2 =  Collector.of(
                () -> new StringJoiner("|"),
                (StringJoiner resp, Person p) -> resp.add(p.toString()),
                (StringJoiner resp, StringJoiner resp1) -> resp.merge(resp1),
                Collector.Characteristics.IDENTITY_FINISH
        );

        StringJoiner obj2 =  persons.stream()
                .collect(myCollector2);
        System.out.println(obj2.toString());

        Person pp = new Person("nadeem", 12);

        List<Person> persons1 = new ArrayList<Person>();
        persons1.add(new Person("Max", 18));
        persons1.add(new Person("Max1", 19));
        persons1.add(new Person("Max2", 10));
        persons1.add(new Person("Max3", 11));
        persons1.add(new Person("Max4", 12));


        persons1.add(pp);
        System.out.println(persons1.size());
        pp=  null;
        System.out.println(persons1.size());

        Integer totalAge = persons1
                .stream()
                .mapToInt(Person::getAge)
                .sum();
    }


    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


}
