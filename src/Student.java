//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 5
//Brief description of file contents: Project 5

import java.util.ArrayList;

public abstract class Student {
    private String name;
    private String id;
    private String essay;
    private ArrayList<String> errorList;

    public Student(String name, String id, String essay, ArrayList<String> errorList) {
        this.name = name;
        this.id = id;
        this.essay = essay;
        this.errorList = errorList;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(ArrayList<String> errorList) {
        this.errorList = errorList;
    }

    public String getPrintableErrorList() {
        String output = null;
        if (errorList != null) {
            StringBuilder buffer = new StringBuilder();
            int idx = 0;
            for (String word : errorList) {
                idx += 1;
                buffer.append("(" + idx + ")" + word + System.lineSeparator());
            }
            output = buffer.toString();
        }
        return output;
    }

    abstract void writeToFile();
}
