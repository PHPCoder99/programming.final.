import java.util.Date;
import java.util.List;

public class Donkey extends FarmAnimal {
    public Donkey(String name) {
        super(name);
    }

    @Override
    public void do_command(String command) {
        if (this.commands.contains(command)) {
            System.out.println("Ee-yo! " + this.name + " does the command " + command);
        } else {
            System.out.println("Ee-yo! " + this.name + " does not know the command " + command);
        }
    }

    @Override
    public void learn_command(String command) {
        if (!this.commands.contains(command)) {
            System.out.println("Ee-yo! " + this.name + " learns the command " + command);
            this.commands.add(command);
        } else {
            System.out.println("Ee-yo! " + this.name + " already knows the command " + command);
        }
    }

    @Override
    public void work(String job) {
        if (this.jobs.contains(job)) {
            System.out.println("Ee-yo! " + this.name + " does the job " + job);
        } else {
            System.out.println("Ee-yo! " + this.name + " does not know the job " + job);
        }
    }

    @Override
    public void new_job(String job) {
        if (!this.jobs.contains(job)) {
            System.out.println("Ee-yo! " + this.name + " learns the job " + job);
            this.jobs.add(job);
        } else {
            System.out.println("Ee-yo! " + this.name + " already knows the job " + job);
        }
    }

    @Override
    public String toString() {
        return "Donkey " + this.name + " birth date " + this.birthDate;
    }
}
