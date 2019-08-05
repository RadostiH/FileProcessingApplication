package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ModifyNumber extends BaseCommand {

    protected ModifyNumber(int firstIndex, int secondIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        super(firstIndex, secondIndex, listLinkedHashMap);
    }

    public LinkedHashMap<Integer, ArrayList<String>> update(String newNumber){
        this.getListLinkedHashMap()
                .get(this.getFirstIndex())
                .set(this.getSecondIndex(), newNumber);
        return this.getListLinkedHashMap();
    }

}
