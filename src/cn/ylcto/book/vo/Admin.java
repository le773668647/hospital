package cn.ylcto.book.vo;

import javafx.scene.chart.PieChart;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zzzz
 * @create 2019-06-24 上午11:12
 */
public class Admin implements Serializable {
    private String Aid;
    private String Password;
    private Date Lastdate;
    private int Flag;
    private int Status;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public Date getLastdate() {
        return Lastdate;

    }

    public void setLastdate(Date lastdate) {
        this.Lastdate = lastdate;
    }

    public int getFlag() {
        return Flag;
    }

    public void setFlag(int flag) {
        this.Flag = flag;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        this.Aid = aid;
    }
}
