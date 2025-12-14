package Collection.ArrayList.Learn;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(0, "Heello");
        arrayList.add("Heello2");
//        System.out.println(arrayList.get(2));
        System.out.println("Vị trí hiện taị: "+arrayList.indexOf("Heello"));
        System.out.println("Vị trí hiện taị: "+arrayList.lastIndexOf("Heello2"));
    }
}
