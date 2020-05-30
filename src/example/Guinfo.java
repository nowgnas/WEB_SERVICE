package example;

public class Guinfo extends Seoul_data_Json {
    private String guname;
    private String sigu;

    public Guinfo(String guname, String sigu) {
        this.guname = guname;
        this.sigu = sigu;
    }

    public String toString() {
        int hashcode = super.hashCode();
        return "\nHashcode: " + hashcode + "구 이름: " + guname + "  구 코드: " + sigu;
    }
}
