package org.example.Server.Commands;

import org.example.Server.Receiver;
import org.example.Server.Interfaces.Execute;

import java.util.ArrayList;

public class ExitCommand extends AbstractCommand implements Execute {
    public ExitCommand() {
        super("exit", "terminate program (without saving to file)", 0);
    }
    @Override
    public String execute(ArrayList<String> arguments, Receiver worker) {
        return "";
    }
}
