package cn.itcast.service.Impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.Impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids!=null&&ids.length>0){
            for(String id:ids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);

        if(currentPage<=0){
            currentPage=1;
        }
        PageBean<User> pb=new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount=dao.findTotalCount(condition);
        pb.setRows(rows);

        int start=(currentPage-1)*rows;
        List<User> list =dao.findByPage(start,rows,condition);
        pb.setList(list);

        int totalPage=(totalCount % rows)==0 ? totalCount / rows :(totalCount / rows) +1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
