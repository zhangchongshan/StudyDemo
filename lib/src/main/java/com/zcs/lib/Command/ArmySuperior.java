package com.zcs.lib.Command;

public class ArmySuperior {
    Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void startExecuteCommand(){
        command.execute();
    }
}
