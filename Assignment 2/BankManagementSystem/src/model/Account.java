package model;

public class Account {
    private int id;
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
}