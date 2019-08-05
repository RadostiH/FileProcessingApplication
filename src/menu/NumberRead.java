package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NumberRead extends BaseCommand {

    protected NumberRead(int firstIndex, int secondIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        super(firstIndex, secondIndex, listLinkedHashMap);
    }
    public LinkedHashMap<Integer, ArrayList<String>> read(){
        System.out.println(this.getListLinkedHashMap().get(this.getFirstIndex()).get(this.getSecondIndex()));

        return this.getListLinkedHashMap();
    }


}

