package cn.zz.book.service;

import cn.zz.book.vo.Member;

public interface IMemberService {
    /**
     * 实现数据增加操作
     * @param vo 表示要执行增加的对象
     * @return
     * @throws Exception
     */
    public boolean insert(Member vo) throws Exception;
}
