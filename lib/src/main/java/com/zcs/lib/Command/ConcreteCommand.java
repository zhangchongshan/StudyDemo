package com.zcs.lib.Command;

public class ConcreteCommand implements Command{
    CompanyArmy army;
    ConcreteCommand(CompanyArmy army){
        this.army=army;
    }
    public void execute(){
        army.sneakAttack();
    }
}
