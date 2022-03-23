package org.daughter.base.dao.sources;

public interface SplitPageBase {
    /**
     * 每页的默认行数
     */
    public static final int size = 10;
    /**
     * 用于查询表的总行数
     * tableName : article
     */
    public static final String articleTableName = "article";

    /**
     * table : reply
     */
    public static final String replyTableName = "reply";

    /**
     * reply split page size
     */
    public static final int replySize = 10;
}
