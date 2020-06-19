package Task4;

import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,45,75,32,1,7,8,5};
        UltraList ultraList = new UltraList(arr);
        UltraList ultraList2 = new UltraList();
        ultraList2.add(2);
        ultraList2.add(6);
        ultraList.print();
        ultraList.printSize();

        ultraList.add(9999,3);
        ultraList.print();

        ultraList.set(-777777,3);
        ultraList.print();
        ultraList.printSize();

        ultraList.remove(0);
        ultraList.print();
        ultraList.printSize();

        ultraList.sort().print();
        ultraList.sort(1).print();
        ultraList.print();
    }
}
