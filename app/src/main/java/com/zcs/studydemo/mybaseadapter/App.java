package com.zcs.studydemo.mybaseadapter;

public class App {

    private int icon;

    private String name;

    public App(){

    }

    public App(int icon,String name){
        this.icon=icon;
        this.name=name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
