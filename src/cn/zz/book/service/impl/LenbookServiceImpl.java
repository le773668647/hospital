package cn.zz.book.service.impl;

import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.factory.DAOFactory;
import cn.zz.book.service.ILenbookService;
import cn.zz.book.vo.Lenbook;

import java.util.HashMap;
import java.util.Map;

public class LenbookServiceImpl implements ILenbookService {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Lenbook vo) throws Exception {
        try {
            return DAOFactory.getILenbookDAOInstance(this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }


    }

    @Override
    public Map<String, Object> listByMemberAndBooks() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            map.put("allBooks",DAOFactory.getILenbookDAOInstance(this.dbc.getConn()).findAll());
            map.put("allMembers",DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findAll());
            return map;

        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}

