package cn.zz.book.service.impl;

import cn.zz.book.dbc.DatabaseConnection;
import cn.zz.book.factory.DAOFactory;
import cn.zz.book.service.IMemberService;
import cn.zz.book.vo.Member;

public class MemberServiceImpl implements IMemberService{
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Member vo) throws Exception {
        try{
            if(DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findById(vo.getMid()) == null)
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return false;
    }
}
