public class Item {
    private String name;
    private String description;
    private float price;
    private String location;

    public Item(String n, String d, float p, String l){
        name = n;
        description = d;
        price = p;
        location = l;
    }

    public String getLocation() {
        return location;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public void setDescription(String d){
        description = d;
    }

    public void setPrice(float i){
        price = i;
    }

    public void setLocation(String l){
        location = l;
    }

    public String toString() {
        return "Name: " + name + "\nDescription: " + description + "\nPrice: "+ price + "\nLocation: " + location + "\n" + "\n";
    }
}