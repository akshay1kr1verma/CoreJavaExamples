package org.example.reflection;

public class AnimalReflectionExample {
    private String breed;
    public boolean canSwim;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public AnimalReflectionExample(String breed, boolean canSwim) {
        this.breed = breed;
        this.canSwim = canSwim;
    }

    public AnimalReflectionExample(){

    }

    public void run(boolean isRun, int dist, String name) {
        System.out.println("isRun :: " + isRun + " dist :: " + dist + " name :: " + name);
    }
}
