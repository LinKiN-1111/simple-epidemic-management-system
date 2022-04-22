package games.linkin.service.impl;

import games.linkin.mapper.UserMapper;
import games.linkin.pojo.User;
import games.linkin.service.UserService;
import games.linkin.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    //1.创建factory工厂对象..
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public User login(User user) {
        //2.获取sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4.调用方法
        User loginedUser = mapper.login(user);

        //5.释放资源
        sqlSession.close();

        return loginedUser;
    }

}
