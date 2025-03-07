public abstract class Animal {
    protected String name;
    protected String description;

    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Abstract method to be implemented by subclasses
    public abstract String makeNoise();

    // Getters for name and description
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}