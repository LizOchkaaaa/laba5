package org.example.Server.Commands;

import org.example.Server.Interfaces.Execute;

public abstract class AbstractCommand implements Execute {
    private String name;
    private String discription;

    private Integer extraArgs;
    private String fullname;

    public AbstractCommand(String name, String discription , Integer extraArgs , String fullname) {
        this.name = name;
        this.discription = discription;
        this.extraArgs = extraArgs;
        this.fullname = fullname;
    }

    public Integer getExtraArgs() {
        return extraArgs;
    }

    @Override
    public String toString() {
        if(fullname == ""){
            return name + " - " + discription;
        }
        return name + " " + fullname + " - " + discription;
    }

    public boolean isNeededExtraArgs(){
        return extraArgs > 2;
    }

    public String getName() {
        return name;
    }

}
