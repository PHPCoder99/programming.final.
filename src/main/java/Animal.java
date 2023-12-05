import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    protected String name;
    protected List<String> commands = new ArrayList<>();
    protected Date birthDate;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void do_command(String command);

    public abstract void learn_command(String command);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Animal " + this.name + " birth date " + this.birthDate;
    }
}
