import java.util.Date;
import java.util.List;

public class Hamster extends PetAnimal {
    public Hamster(String name) {
        super(name);
    }

    @Override
    public void do_command(String command) {
        if (this.commands.contains(command)) {
            System.out.println("Ham! " + this.name + " does the command " + command);
        } else {
            System.out.println("Ham! " + this.name + " does not know the command " + command);
        }
    }

    @Override
    public void learn_command(String command) {
        if (!this.commands.contains(command)) {
            System.out.println("Ham! " + this.name + " learns the command " + command);
            this.commands.add(command);
        } else {
            System.out.println("Ham! " + this.name + " already knows the command " + command);
        }
    }

    @Override
    public void play(String toy) {
        if (this.toys.contains(toy)) {
            System.out.println("Ham! " + this.name + " plays with the toy " + toy);
        } else {
            System.out.println("Ham! " + this.name + " does not have the toy " + toy);
        }
    }

    @Override
    public void new_toy(String toy) {
        if (!this.toys.contains(toy)) {
            System.out.println("Ham! " + this.name + " gets the toy " + toy);
            this.toys.add(toy);
        } else {
            System.out.println("Ham! " + this.name + " already has the toy " + toy);
        }
    }

    @Override
    public String toString() {
        return "Hamster " + this.name + " birth date " + this.birthDate;
    }
}
