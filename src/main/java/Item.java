public class Item {
    private String name;
    private int price;
    private boolean check;

    public Item(String name, int price, boolean check) {
        this.name = name;
        this.price = price;
        this.check = check;
    }

    public int getPrice() {
        return price;
    }

    public boolean isCheck() {
        return check;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }
}