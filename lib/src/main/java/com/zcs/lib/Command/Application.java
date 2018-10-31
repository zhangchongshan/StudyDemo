package com.zcs.lib.Command;

import java.io.File;

public class Application {
    public static void main(String[] args){
        CompanyArmy sanLian=new CompanyArmy();
        Command command= new ConcreteCommand(sanLian);
        ArmySuperior commander=new ArmySuperior();
        commander.setCommand(command);
        commander.startExecuteCommand();
    }
}
