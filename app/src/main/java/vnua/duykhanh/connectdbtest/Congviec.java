package vnua.duykhanh.connectdbtest;

public class Congviec {
    private int Id;
    private String tenCv;

    public Congviec(int id, String tenCv) {
        Id = id;
        this.tenCv = tenCv;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenCv() {
        return tenCv;
    }

    public void setTenCv(String tenCv) {
        this.tenCv = tenCv;
    }
}
