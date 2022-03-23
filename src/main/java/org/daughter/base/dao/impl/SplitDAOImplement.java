package org.daughter.base.dao.impl;

import org.daughter.base.dao.SplitDAO;
import org.daughter.base.mapper.SplitUtilsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("SplitDAO")
public class SplitDAOImplement implements SplitDAO {
    @Autowired
    private SplitUtilsMapper splitUtilsMapper;

    @Override
    public int totalPage(int rows, int size) {
        if(rows % size != 0){
            return (rows / size + 1);
        }else{
            return (rows / size);
        }

    }

    @Override
    public int currentRowsOfTheTable(int currentPage, int size) {
        int begin  = (currentPage - 1) * size;
        return begin;
    }

    @Override
    public int allRows(String tableName) {
        int rows = splitUtilsMapper.allRows( tableName );
        return rows;
    }
}
