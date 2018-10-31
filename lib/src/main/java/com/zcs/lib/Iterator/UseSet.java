package com.zcs.lib.Iterator;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class UseSet {
    LinkedList<Student> list;
    Hashtable<String,Student> table;
    TreeSet<Student> tree;
    UseSet(){
        list=new LinkedList<>();
        table=new Hashtable<>();
        tree=new TreeSet<>();
    }
    public void addStudent(Student student){
        list.add(student);
        update();
    }
    public void lookStudent(String num){
        Student stu=table.get(num);
        String number=stu.getNumber();
        String name=stu.getName();
        double score=stu.getScore();
        System.out.println("学号："+number+"姓名："+name+"分数："+score);
    }
    public void printStudentsByScore(){
        Iterator<Student> iterator=tree.iterator();
        while ((iterator.hasNext())){
            Student stu=iterator.next();
            String number=stu.getNumber();
            String name=stu.getName();
            double score=stu.getScore();
            System.out.println("学号："+number+"姓名："+name+"分数："+score);
        }
    }
    private void update(){
        tree.clear();
        Iterator<Student> iterator=list.iterator();
        while (iterator.hasNext()){
            Student stu=iterator.next();
            String number=stu.getNumber();
            table.put(number,stu);
            tree.add(stu);
        }
    }
}
