package cn.zz.book.vo;

/**
 * @author zzzz
 * @create 2019-07-09 下午3:05
 */
public class Medicine extends Doctor {
    private String id;
    private String name;
    private String price;
    private String amount;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
