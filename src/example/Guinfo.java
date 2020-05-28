package example;

public class Guinfo extends Seoul_data_Json {
    private String guname;

    public Guinfo(String guname) {
        this.guname = guname;
    }

    public String toString() {
        int hashcode = super.hashCode();
        return "\nHashcode: " + hashcode + "구 이름: " + guname;
    }
}
