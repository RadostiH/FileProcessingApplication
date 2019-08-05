package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NumberSwitch extends BaseCommand {
    private int firstNumberIndex;
    private int secondNumberIndex;


    public NumberSwitch(int firstIndex, int firstNumberIndex, int secondIndex, int secondNumberIndex, LinkedHashMap<Integer, ArrayList<String>> listLinkedHashMap) {
        super(firstIndex, secondIndex, listLinkedHashMap);
        this.firstNumberIndex = firstNumberIndex;
        this.secondNumberIndex = secondNumberIndex;
    }

    @Override
    public LinkedHashMap<Integer, ArrayList<String>> switchIt() {
        String temp = this.getListLinkedHashMap().get(this.getFirstIndex()).get(this.firstNumberIndex);

        this.getListLinkedHashMap().get(this.getFirstIndex()).set(this.firstNumberIndex,
                this.getListLinkedHashMap().get(this.getSecondIndex()).get(this.secondNumberIndex));

        this.getListLinkedHashMap().get(this.getSecondIndex()).set(this.secondNumberIndex, temp);

        return this.getListLinkedHashMap();

    }
}
