package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class BaseCommand {
    private int firstIndex;
    private int secondIndex;
    private LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap;

    protected BaseCommand(int firstIndex, int secondIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.listLinkedHashMap = listLinkedHashMap;
    }

    public LinkedHashMap<Integer, ArrayList<String>> switchIt(){
        return null;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public LinkedHashMap<Integer, ArrayList<String>> getListLinkedHashMap() {
        return listLinkedHashMap;
    }

    public void setListLinkedHashMap(LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        this.listLinkedHashMap = listLinkedHashMap;
    }
}
