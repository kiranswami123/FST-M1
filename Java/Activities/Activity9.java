import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList <String> mylist= new ArrayList<String>();
        mylist.add("apple");
        mylist.add("mango");
        mylist.add("Orange");

        mylist.add(3,"grapes");
        mylist.add(1,"papaya");

        System.out.println("Print All the Objects:");
        for (String s:mylist){
            System.out.println(s);
        }
        System.out.println("3rd element in the list is: " + mylist.get(2));
        System.out.println("Is Chicku is in list: " + mylist.contains("Chicku"));
        System.out.println("Size of ArrayList: " + mylist.size());

        mylist.remove("papaya");
        System.out.println("New Size of ArrayList: " + mylist.size());


    }
}
