import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class PetAnimal extends Animal {
    protected List<String> toys = new ArrayList<>();

    public PetAnimal(String name) {
        super(name);
    }

    public abstract void play(String toy);

    public abstract void new_toy(String toy);

    public List<String> getToys() {
        return toys;
    }

    public void setToys(List<String> toys) {
        this.toys = toys;
    }
}
