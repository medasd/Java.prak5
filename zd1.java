import java.util.ArrayList;

enum PetType {
    DOG, CAT
}

enum HealthStatus {
    HEALTHY, SICK
}

class Pet {
    String name;
    int age;
    PetType type;

    public Pet(String name, int age, PetType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Тип: " + type);
    }
}

class Dog extends Pet {
    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age, PetType.DOG);
        this.breed = breed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Порода: " + breed);
    }
}

class Cat extends Pet {
    String color;

    public Cat(String name, int age, String color) {
        super(name, age, PetType.CAT);
        this.color = color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Цвет: " + color);
    }
}

class PetClinic {
    ArrayList<Pet> pets = new ArrayList<>();

    public void addPet(Pet pet) throws Exception {
        for (Pet existingPet : pets) {
            if (existingPet.name.equals(pet.name)) {
                throw new Exception("Питомец с таким именем уже есть в клинике!");
            }
        }
        pets.add(pet);
    }

    public void displayPets() {
        for (Pet pet : pets) {
            pet.displayInfo();
            System.out.println();
        }
    }
}

public class zd1 {
    public static void main(String[] args) {
        PetClinic clinic = new PetClinic();

        try {
            Dog dog1 = new Dog("Бобик", 3, "Шершавая");
            Cat cat1 = new Cat("Мурка", 2, "Черный");

            clinic.addPet(dog1);
            clinic.addPet(cat1);

            // Попытка добавить питомца с уже существующим именем
            Dog dog2 = new Dog("Бобик", 5, "Лабрадор");
            clinic.addPet(dog2); // вызовет исключение

            clinic.displayPets();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
