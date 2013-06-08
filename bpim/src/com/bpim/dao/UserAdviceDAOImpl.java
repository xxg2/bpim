package com.bpim.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpim.common.DBConnUtil;
import com.bpim.entity.UserAdvice;
import com.bpim.form.SearchDataCondition;

/**
 * author Delgado
 */
public class UserAdviceDAOImpl implements UserAdviceDAO
{
    
    String queryUserAdvice =
        "SELECT ua.*,ui.USER_NAME FROM USER_ADVINCE ua, USER_INFO ui WHERE ua.USER_ID=ui.ID AND 1=1";
    
    String countQueryUserAdvice = "SELECT count(*) FROM USER_ADVINCE WHERE 1=1";
    
    String insertUserAdvice = "INSERT INTO USER_ADVINCE (USER_ID,ADVICE_CONTENT,ADVICE_DATE) values (?,?,now())";
    
    int i = 1;
    
    public List<UserAdvice> queryUserAdvice(SearchDataCondition condition)
        throws SQLException
    {
        
        String sql = getQuerySql(queryUserAdvice, condition);
        sql = sql + " ORDER BY ADVICE_DATE DESC LIMIT ?,?";
        PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
        setConditionValue(stat, condition);
        stat.setInt(i, condition.getStartRow());
        stat.setInt(i + 1, condition.getPageSize());
        ResultSet result = stat.executeQuery();
        List<UserAdvice> datas = new ArrayList<UserAdvice>();
        while (result.next())
        {
            UserAdvice data = new UserAdvice();
            data.setId(result.getLong("ID"));
            data.setUserID(result.getLong("USER_ID"));
            data.setUserName(result.getString("USER_NAME"));
            data.setAdviceContent(result.getString("ADVICE_CONTENT"));
            data.setAdviceDate(result.getTimestamp("ADVICE_DATE"));
            datas.add(data);
        }
        return datas;
    }
    
    public int countQueryUserAdvice(SearchDataCondition condition)
        throws SQLException
    {
        String sql = getQuerySql(countQueryUserAdvice, condition);
        PreparedStatement stat = DBConnUtil.getPrepareStatement(sql);
        setConditionValue(stat, condition);
        ResultSet result = stat.executeQuery();
        int value = 0;
        if (result.next())
        {
            value = result.getInt(1);
        }
        return value;
    }
    
    public void insertUserAdvice(UserAdvice userAdvice)
        throws SQLException
    {
        PreparedStatement stat = DBConnUtil.getPrepareStatement(insertUserAdvice);
        stat.setLong(1, userAdvice.getUserID());
        stat.setString(2, userAdvice.getAdviceContent());
        stat.execute();
    }
    
    private String getQuerySql(String sql, SearchDataCondition condition)
    {
        StringBuilder sqlSb = new StringBuilder(sql);
        
        if (null != condition.getUserInfoId() && 0 != condition.getUserInfoId())
        {
            sqlSb.append(" AND USER_ID = ?");
        }
        if (null != condition.getDataType() && !"".equals(condition.getDataType()))
        {
            if ("1".equals(condition.getDataType()))
            {
                sqlSb.append(" AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(ADVICE_DATE)");
            }
            else if ("2".equals(condition.getDataType()))
            {
                sqlSb.append(" AND DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= DATE(ADVICE_DATE)");
            }
        }
        
        return sqlSb.toString();
    }
    
    private void setConditionValue(PreparedStatement stat, SearchDataCondition condition)
        throws SQLException
    {
        i = 1;
        if (null != condition.getUserInfoId() && 0 != condition.getUserInfoId())
        {
            stat.setLong(i, condition.getUserInfoId());
            i++;
        }
    }
    
}
