package cn.zz.book.service.impl;

import cn.zz.book.vo.Admin;
import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.factory.DAOFactory;
import cn.zz.book.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean login(Admin vo) throws Exception {
        try{
            //如果登录成功
            if (DAOFactory.getAdminDAOInstance(this.dbc.getConn()).findLogin(vo)) {
                return DAOFactory.getAdminDAOInstance(this.dbc.getConn()).doUpdateByLastDate(vo.getAid());
            }
            return false;

        }
        catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

    @Override
    public boolean updateByLastDate(String aid) throws Exception {
        return false;
    }
}
