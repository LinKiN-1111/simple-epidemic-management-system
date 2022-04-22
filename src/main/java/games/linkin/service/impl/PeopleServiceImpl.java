package games.linkin.service.impl;

import games.linkin.mapper.PeopleMapper;
import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import games.linkin.service.PeopleService;
import games.linkin.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PeopleServiceImpl implements PeopleService {
    //1.创建sqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<People> selectAll() {
        //2.获取sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3.获取BrandMapper
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        //4.调用方法
        List<People> peoples = mapper.selectAll();

        //5.释放资源
        sqlSession.close();

        return peoples;
    }

    @Override
    public void add(People people) {
        //2.获取sqlSession对象
        SqlSession sqlSession = factory.openSession();

        //3.获取BrandMapper
        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        //4.调用方法
        mapper.add(people);

        //5.提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();

        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        mapper.deleteByIds(ids);

        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteById(People people){
        SqlSession sqlSession = factory.openSession();

        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        mapper.deleteById(people);

        sqlSession.commit();

        sqlSession.close();
    }


    @Override
    public void update(People people){
        SqlSession sqlSession = factory.openSession();

        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        mapper.update(people);

        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public PeopleBean<People> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();

        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        //计算开始索引与查询条目数
        int begin = (currentPage -1)*pageSize;
        int size = pageSize;
        //4.调用方法
        List<People> rows = mapper.selectByPage(begin, size);

        int totalCount = mapper.selectTotalcount();

        //封装PageBean对象
        PeopleBean<People> pageBean = new PeopleBean<>();
        pageBean.setRow(rows);
        pageBean.setTotalCount(totalCount);

        //5.释放资源
        sqlSession.close();

        return pageBean;
    }

    public List<People> selectByCardId(String cardId) {
        SqlSession sqlSession = factory.openSession();

        PeopleMapper mapper = sqlSession.getMapper(PeopleMapper.class);

        //4.调用方法
        List<People> peoples = mapper.selectByCardId(cardId);

        //5.释放资源
        sqlSession.close();

        return peoples;
    }
}
