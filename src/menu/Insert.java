package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Insert extends BaseCommand {
    protected Insert(int firstIndex, int secondIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        super(firstIndex, secondIndex, listLinkedHashMap);
    }

    public LinkedHashMap<Integer, ArrayList<String>> insert(String number){
        boolean flag = true;
        for (char c:
             number.toCharArray()) {
            if(!Character.isDigit(c)){
                flag = false;
            }

        }
        if(flag) {
            this.getListLinkedHashMap().get(this.getFirstIndex()).add(this.getSecondIndex(), number);
        }else {
            System.out.println("Only numbers are allowed!");
        }
        return this.getListLinkedHashMap();
    }
}
