import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Long countBefore18 = persons.stream()
                .filter(m -> m.getAge() < 18)
                .count();
        System.out.println("Лоличество призывников - " + countBefore18);

//        List<String> surnameConscript = persons.stream()
//                .filter(x -> x.getAge() > 18)
//                .filter(x -> x.getAge() < 27)
//                .map(x -> x.getFamily())
//                .collect(Collectors.toList());
//        System.out.println(surnameConscript);

        List<Person> surnameEducation = persons.stream()
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x -> x.getAge() > 18)
                .filter(x -> x.getAge() < 65)

                .filter(w -> (w.getSex().equals(Sex.WOMAN) && w.getAge() > 60) )  //|| (w.getSex().equals(Sex.MAN) && w.getAge() < 65))
//                .filter(obj -> obj.getSex().equals(Sex.WOMAN) && obj.getAge() <= 60 || obj.getSex().equals(Sex.MAN) && obj.getAge() <= 65)



//                .filter(x -> {
//                    if (x.getSex().equals(Sex.WOMAN)) {
//                       boolean y= x.getAge() < 60;
//
//
//                    }
//return false;
//                })
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(surnameEducation);

    }

}
