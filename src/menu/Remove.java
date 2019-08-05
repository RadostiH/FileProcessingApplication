package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Remove extends BaseCommand {
    protected Remove(int firstIndex, int secondIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        super(firstIndex, secondIndex, listLinkedHashMap);
    }

    public LinkedHashMap<Integer, ArrayList<String>> delete(){
        this.getListLinkedHashMap().get(this.getFirstIndex()).remove(this.getSecondIndex());
        return this.getListLinkedHashMap();
    }
}
