package com.zcs.lib.Iterator;

public class Student implements Comparable {
    String number,name;
    double score=0;
    private int x=10;
    Student(){}
    Student(String number,String name,double score){
        this.number=number;
        this.name=name;
        this.score=score;
    }
    @Override
    public int compareTo(Object o) {
        Student st= (Student) o;
        if (Math.abs(this.score-st.score)<=1/1000){
            return 1;
        }
        return (int) (1000*(this.score-st.score));
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
