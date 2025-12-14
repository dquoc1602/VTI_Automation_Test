package Collection.Hashmap;

import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();

        // Lưu dữ liệu
        map.put("id", 1001);
        map.put("name", "Nguyễn Văn A");
        map.put("age", 25);
        map.put("active", true);

        // Lấy dữ liệu (cần ép kiểu)
        int id = (int) map.get("id");
        String name = (String) map.get("name");
        int age = (int) map.get("age");
        boolean active = (boolean) map.get("active");

        System.out.println(id + " - " + name + " - " + age + " - " + active);
    }
}
