package com.mybatis.test.mybatishandler;

import com.mybatis.test.dto.NewsDTO;
import com.mybatis.test.entity.NewsEntity;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.data.relational.core.sql.In;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ExampleHandler extends BaseTypeHandler<Integer> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        parameter += 1;
        System.out.println(parameter.toString());
        if (parameter != null) {
            ps.setObject(i, parameter);
        }

    }

    @Override
    public Integer getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Integer getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Integer getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }



}
