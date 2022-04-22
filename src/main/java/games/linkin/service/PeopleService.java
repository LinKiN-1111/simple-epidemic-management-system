package games.linkin.service;

import games.linkin.pojo.People;
import games.linkin.pojo.PeopleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleService {

    List<People> selectAll();

    void add(People people);

    void deleteByIds(int[] ids);

    void deleteById(People people);

    void update(People people);

    PeopleBean<People> selectByPage(int begin, int size);

    List<People> selectByCardId(String cardId);

}
