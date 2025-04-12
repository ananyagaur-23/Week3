public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("name", "John");
        map.put("age", "30");
        map.put("city", "New York");

        System.out.println("Name: " + map.get("name"));
        System.out.println("Age: " + map.get("age"));
        System.out.println("City: " + map.get("city"));

        map.remove("age");

        System.out.println("Contains 'age': " + map.containsKey("age"));

        System.out.println("Non-existing key: " + map.get("address"));
    }
}
