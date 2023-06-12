
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                            .setName("Антошка")
                            .setSurname("Лопатов")
                            .setAge(48)
                            .build();

        Person child = person.newChildBuilder()
                            .setName("Ребенок")
                            .setAge(1)
                            .build();
    }
}