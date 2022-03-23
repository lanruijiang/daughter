package org.daughter.base.dao;

public interface SplitDAO {

    /**
     * 求总页数
     * @param rows 总行数
     * @param size 每页行数
     * @return
     */
    public int totalPage(int rows , int size);

    /**
     * limit中的begin
     * @param currentPage 当前页
     * @param size 每页行数
     * @return
     */
    public int currentRowsOfTheTable(int currentPage , int size);

    /**
     * 总行数
     * @param tableName
     * @return
     */
    public int allRows(String tableName);
}
