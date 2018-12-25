package mainacademy.recipesapp;

// class to hold values for listview items
@SuppressWarnings({"SameParameterValue", "CanBeFinal"})
class Model {
    private String name; // Recipe name
    private int value; // checkbox: 0 = disable, 1 = enable
    private int id; // database _id (record id)

    Model(String _name, int _value, int _id) {
        this.name = _name;
        this.value = _value;
        this.id = _id;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int _v){
        value = _v;
    }

    public int getID(){
        return id;
    }
    // setID not needed, is set on instantiate, and never changed
}

