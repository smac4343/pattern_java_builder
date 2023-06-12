public class Person {
    private final String name;
    private final String surname;
    private int age;
    private boolean hasAge;
    private String address;
    private boolean hasAddress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void happyBirthday() {
        if (hasAge) {
            age++;
        }
    }

    public boolean hasAge() {
        return hasAge;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAddress() {
        return hasAddress;
    }

    public void setAddress(String address) {
        this.address = address;
        this.hasAddress = true;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.setSurname(this.surname);
        builder.setAddress(this.address);
        return builder;
    }

    static class PersonBuilder {
        private String name;
        private String surname;
        private int age;
        private boolean hasAge;
        private String address;
        private boolean hasAddress;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
            this.hasAge = true;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            this.hasAddress = true;
            return this;
        }

        public Person build() {
            if (name == null || surname == null) {
                throw new IllegalStateException("Name and surname must be set");
            }

            Person person = new Person(name, surname);

            if (hasAge) {
                person.age = age;
                person.hasAge = true;
            }

            if (hasAddress) {
                person.address = address;
                person.hasAddress = true;
            }

            return person;
        }
    }
}
