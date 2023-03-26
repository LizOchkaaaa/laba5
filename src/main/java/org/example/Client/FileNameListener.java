package org.example.Client;

import org.example.exceptions.FileLoadingException;
import org.example.exceptions.NoAccessToFileException;
import org.example.models.StudyGroup;
import org.example.xmlFileHandler;

import java.io.File;
import java.util.Stack;


public class FileNameListener {
    private String fileName;
    private Stack<StudyGroup> groups;

    public String getFileName(){
        return fileName;
    }

    public DataInOutStatus listener(){
        OutStream.outputIntoCLI("Type name of file.");
        String fileName = InputClireader.getInputReader().nextLine();
        return DataInOutStatus.SUCCESSFULLY;
    }

    public DataInOutStatus reader(){
        File file1 = new File(fileName);
        xmlFileHandler read  = new xmlFileHandler();
        try {
            read.load(file1);
            groups = read.get();
        }catch (NoAccessToFileException | FileLoadingException e) {
            return DataInOutStatus.FAILED;
        }
        return DataInOutStatus.SUCCESSFULLY;
    }

    public Stack<StudyGroup> getGroups() {
        return groups;
    }
}
