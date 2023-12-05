// handle your users, kids! (im dead inside.)

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserHandler {
    private static List<PetAnimal> getPets(List<Animal> animals){
        List<PetAnimal> pets = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof PetAnimal){
                pets.add((PetAnimal) animal);
            }
        }
        return pets;
    }

    private static List<FarmAnimal> getFarms(List<Animal> animals){
        List<FarmAnimal> farms = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof FarmAnimal){
                farms.add((FarmAnimal) animal);
            }
        }
        return farms;
    }

    private static int enterId(List objectList){
        Scanner scanner = new Scanner(System.in);
        String objectId = scanner.next();
        while (!intParsable(objectId) || intParsable(objectId) && (Integer.parseInt(objectId) >= objectList.size() || Integer.parseInt(objectId) < 0)) {
            System.out.println("Incorrect format, try again.");
            objectId = scanner.next();
        }
        return Integer.parseInt(objectId);
    }

    public static void printWithIds(List objectList){
        for (int i = 0; i < objectList.size(); i++){
            System.out.println(i + " " + objectList.get(i).toString());
        }
    }

    private static boolean intParsable(String intStr){
        try {
            Integer.parseInt(intStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean dateParsable(String dateStr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void menu(List<Animal> animals) {
        boolean running = true;
        while (running) {
            System.out.println("-> Add animal (a)");
            System.out.println("-> Delete animal (d)");
            System.out.println("-> View all animal's commands (v)");
            System.out.println("-> Do a command (c)");
            System.out.println("-> Teach a command (t)");
            System.out.println("-> Play a game (g)");
            System.out.println("-> Add a toy (y)");
            System.out.println("-> Work a job (w)");
            System.out.println("-> Add a job (j)");
            System.out.println("Or (q) to quit");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();

            if (command.equalsIgnoreCase("a")) {
                addAnimal(animals);
            } else if (command.equalsIgnoreCase("d")) {
                deleteAnimal(animals);
            } else if (command.equalsIgnoreCase("v")) {
                view_commands(animals);
            } else if (command.equalsIgnoreCase("c")) {
                do_command(animals);
            } else if (command.equalsIgnoreCase("t")) {
                learn_command(animals);
            } else if (command.equalsIgnoreCase("g")) {
                play(getPets(animals));
            } else if (command.equalsIgnoreCase("y")) {
                add_toy(getPets(animals));
            } else if (command.equalsIgnoreCase("w")) {
                work(getFarms(animals));
            } else if (command.equalsIgnoreCase("j")) {
                add_job(getFarms(animals));
            } else if (command.equalsIgnoreCase("q")) {
                running = false;
            } else {
                System.out.println("Command not found, try again.");
            }
        }
    }

    private static void view_commands(List<Animal> animals) {
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal you'd like to view the commands of");
            int animalId = enterId(animals);
            List<String> animalCommands = animals.get(animalId).getCommands();
            if (animalCommands.isEmpty()) {
                System.out.println("The animal doesn't know any commands!");
            } else {
                printWithIds(animalCommands);
            }
        }
    }

    private static void addAnimal(List<Animal> animals) {
        Scanner scanner = new Scanner(System.in);
        Animal newAnimal = null;
        String species = "";
        System.out.println("What is the animal's name?");
        String animalName = scanner.next();
        while (!species.equals("d") &&
                !species.equals("c") &&
                !species.equals("h") &&
                !species.equals("r") &&
                !species.equals("e") &&
                !species.equals("n")){
            System.out.println("What species is the animal?");
            System.out.println("-> Dog (d)");
            System.out.println("-> Cat (c)");
            System.out.println("-> Hamster (h)");
            System.out.println("-> Horse (r)");
            System.out.println("-> Camel (e)");
            System.out.println("-> Donkey (n)");
            species = scanner.next();
            switch (species) {
                case "d" -> newAnimal = new Dog(animalName);
                case "c" -> newAnimal = new Cat(animalName);
                case "h" -> newAnimal = new Hamster(animalName);
                case "r" -> newAnimal = new Horse(animalName);
                case "e" -> newAnimal = new Camel(animalName);
                case "n" -> newAnimal = new Donkey(animalName);
                default -> System.out.println("Incorrect format, try again.");
            }
        }
        String animalBirth = "";
        while (!dateParsable(animalBirth)){
            System.out.println("Enter the animal's birth date (dd/mm/yyyy)");
            animalBirth = scanner.next();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(animalBirth);
                newAnimal.setBirthDate(date);
            } catch (ParseException e) {
                System.out.println("Incorrect format, try again.");
            }
        }
        animals.add(newAnimal);
    }

    private static void deleteAnimal(List<Animal> animals) {
        if (animals.isEmpty()){
            System.out.println("There are no animals to delete!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal you'd like to delete");
            int animalId = enterId(animals);
            animals.remove(animalId);
        }
    }

    private static void do_command(List<Animal> animals){
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal to do a command");
            int animalId = enterId(animals);
            List<String> animalCommands = animals.get(animalId).getCommands();
            if (animalCommands.isEmpty()) {
                System.out.println("The animal doesn't know any commands!");
            } else {
                printWithIds(animalCommands);
                System.out.println("Enter the command to perform");
                int commandId = enterId(animalCommands);
                animals.get(animalId).do_command(animalCommands.get(commandId));
            }
        }
    }

    private static void play(List<PetAnimal> animals){
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal to play a game");
            int animalId = enterId(animals);
            List<String> animalToys = animals.get(animalId).getToys();
            if (animalToys.isEmpty()) {
                System.out.println("The animal doesn't have any toys!");
            } else {
                printWithIds(animalToys);
                System.out.println("Enter the toy to play with");
                int toyId = enterId(animalToys);
                animals.get(animalId).play(animalToys.get(toyId));
            }
        }
    }

    private static void work(List<FarmAnimal> animals){
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal to do a job");
            int animalId = enterId(animals);
            List<String> animalJobs = animals.get(animalId).getJobs();
            if (animalJobs.isEmpty()) {
                System.out.println("The animal can't do any jobs!");
            } else {
                printWithIds(animalJobs);
                System.out.println("Enter the job to do");
                int jobId = enterId(animalJobs);
                animals.get(animalId).work(animalJobs.get(jobId));
            }
        }
    }

    private static void learn_command(List<Animal> animals){
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal to learn a command");
            int animalId = enterId(animals);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a command to learn: ");
            animals.get(animalId).learn_command(scanner.next());
        }
    }

    private static void add_toy(List<PetAnimal> animals){
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal to add a toy");
            int animalId = enterId(animals);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a toy to add: ");
            animals.get(animalId).new_toy(scanner.next());
        }
    }

    private static void add_job(List<FarmAnimal> animals){
        if (animals.isEmpty()){
            System.out.println("There are no animals!");
        } else {
            printWithIds(animals);
            System.out.println("Enter the ID associated with the animal to add a job");
            int animalId = enterId(animals);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a job to add: ");
            animals.get(animalId).new_job(scanner.next());
        }
    }
}
