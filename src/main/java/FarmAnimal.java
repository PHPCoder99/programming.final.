import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class FarmAnimal extends Animal {
    protected List<String> jobs = new ArrayList<>();

    public FarmAnimal(String name) {
        super(name);
    }

    public abstract void work(String job);

    public abstract void new_job(String job);

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }
}
