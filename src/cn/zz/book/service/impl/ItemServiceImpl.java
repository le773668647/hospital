package cn.zz.book.service.impl;

import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.factory.DAOFactory;
import cn.zz.book.service.IItemService;
import cn.zz.book.vo.Item;

import java.util.List;

public class ItemServiceImpl implements IItemService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Item vo) throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }


    }

    @Override
    public List<Item> list() throws Exception {
        try {
            return DAOFactory.getIItemDAOInstance(this.dbc.getConn()).findAll();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }
}
