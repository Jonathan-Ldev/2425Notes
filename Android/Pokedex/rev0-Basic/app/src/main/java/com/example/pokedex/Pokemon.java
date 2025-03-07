package com.example.pokedex;

public class Pokemon {
    private String name;
    private int number;
    private String description;
    private int stage;
    private int health;
    private String length;
    private String weight;
    private String move1Name;
    private String move2Name;
    private int move1DMG;
    private int move2DMG;
    private String weakness;
    private String strength;
    private int retreatCost;

    public Pokemon(String name, int number, String description, int stage, int health, String length, String weight, String move1Name, String move2Name, int move1DMG, int move2DMG, String weakness, String strength, int retreatCost){
        this.name = name;
        this.number = number;
        this.description = description;
        this.stage = stage;
        this.health = health;
        this.length = length;
        this.weight = weight;
        this.move1Name = move1Name;
        this.move2Name = move2Name;
        this.move1DMG = move1DMG;
        this.move2DMG = move2DMG;
        this.weakness = weakness;
        this.strength = strength;
        this.retreatCost = retreatCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMove1Name() {
        return move1Name;
    }

    public void setMove1Name(String move1Name) {
        this.move1Name = move1Name;
    }

    public String getMove2Name() {
        return move2Name;
    }

    public void setMove2Name(String move2Name) {
        this.move2Name = move2Name;
    }

    public int getMove1DMG() {
        return move1DMG;
    }

    public void setMove1DMG(int move1DMG) {
        this.move1DMG = move1DMG;
    }

    public int getMove2DMG() {
        return move2DMG;
    }

    public void setMove2DMG(int move2DMG) {
        this.move2DMG = move2DMG;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(int retreatCost) {
        this.retreatCost = retreatCost;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
