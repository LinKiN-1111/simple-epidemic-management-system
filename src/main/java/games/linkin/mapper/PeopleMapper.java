package games.linkin.mapper;

import games.linkin.pojo.People;
import games.linkin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PeopleMapper {
    /**
     * 查询所有资料
     * @return
     */
    @Select("select * from People")
    @ResultMap("peopleResultMap")
    List<People> selectAll();

    /**
     * 插入
     * @param people
     */
    @Insert("insert into people values (null,#{name},#{sex},#{cardId},#{covidTest},#{vaccination})")
    void add(People people);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    @Delete("delete from people where id= #{id}")
    void deleteById(People people);

    @Update("update people set name = #{name},sex=#{sex},card_id=#{cardId},covid_test=#{covidTest},Vaccination=#{vaccination} where id = #{id}")
    void update(People people);

    @Select("select * from people limit #{begin},#{size}")
    @ResultMap("peopleResultMap")
    List<People> selectByPage(@Param("begin")int begin,@Param("size")int size);

    @Select("select count(*) from people")
    int selectTotalcount();

    @Select("select * from people where card_id=#{cardId}")
    @ResultMap("peopleResultMap")
    List<People> selectByCardId(@Param("cardId")String cardId);
}
