package games.linkin.mapper;

import games.linkin.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /**
     * 
     * @param user
     * @return boolean
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(User user);

}
