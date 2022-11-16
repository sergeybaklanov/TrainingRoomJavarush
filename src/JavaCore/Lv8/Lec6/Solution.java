package JavaCore.Lv8.Lec6;

public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat("Vaska");
        CatWrapper catWrapper = new CatWrapper(cat);
        System.out.println(catWrapper.getName());


    }
    public static class Cat{
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static  class CatWrapper extends  Cat{
        Cat original;

        public String getName() {
            return original.getName()+" А точно ?";
        }

        public void setName(String name) {
            this.original.setName(name);
        }

        public CatWrapper(Cat cat) {
            super(cat.getName());
            this.original=cat;
        }
    }
}
