package main.java.model;

public class Category {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int mutualCateId;
    public int getMutualCateId() {
        return mutualCateId;
    }

    public void setMutualCateId(int mutualCateId) {
        this.mutualCateId = mutualCateId;
    }
}
