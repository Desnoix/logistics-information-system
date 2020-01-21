package com.mybatis.dao;

import com.mybatis.pojo.UserPrivileges;
import com.mybatis.pojo.UserPrivilegesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPrivilegesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    int countByExample(UserPrivilegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    int deleteByExample(UserPrivilegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    int insert(UserPrivileges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    int insertSelective(UserPrivileges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    List<UserPrivileges> selectByExample(UserPrivilegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserPrivileges record, @Param("example") UserPrivilegesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER_PRIVILEGES
     *
     * @mbggenerated Mon Jan 13 22:15:29 CST 2020
     */
    int updateByExample(@Param("record") UserPrivileges record, @Param("example") UserPrivilegesExample example);
}