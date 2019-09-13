package cn.zz.book.vo;

/**
 * @author zzzz
 * @create 2019-07-08 下午4:15
 */
public class Nurse {
    private String id;
    private String name;
    private String object;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", object='" + object + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
