package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Switch extends BaseCommand {


    public Switch(int firstIndex, int secondIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        super(firstIndex, secondIndex, listLinkedHashMap);
    }

    @Override
    public LinkedHashMap<Integer, ArrayList<String>> switchIt(){

        if(this.getListLinkedHashMap().containsKey(this.getFirstIndex()) && this.getListLinkedHashMap().containsKey(this.getSecondIndex()))
        {
            ArrayList<String> temp = this.getListLinkedHashMap().get(this.getFirstIndex());
            this.getListLinkedHashMap().putIfAbsent(this.getFirstIndex(), this.getListLinkedHashMap().get(this.getSecondIndex()));
            this.getListLinkedHashMap().putIfAbsent(this.getSecondIndex(), temp);
        }else{
            System.out.println("Not existing index!");
        }

        return this.getListLinkedHashMap();
    }

}
