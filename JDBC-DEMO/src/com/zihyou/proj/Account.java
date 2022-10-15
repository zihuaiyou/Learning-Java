package com.zihyou.proj;

public class Account {
    private int id;
    private String name;
    private double mny;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMny() {
        return mny;
    }

    public void setMny(double mny) {
        this.mny = mny;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mny=" + mny +
                '}';
    }
}
