package org.daughter.base.dao.impl;

import org.daughter.base.dao.ReplyDAO;
import org.daughter.base.mapper.ReplyDAOMapper;
import org.daughter.base.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Controller("ReplyDAO")
public class ReplyDAOImplement implements ReplyDAO {
    @Autowired
    private ReplyDAOMapper replyDAOMapper ;


    @Override
    @Transactional
    public boolean replyIssue(Reply reply) {
        boolean b = replyDAOMapper.replyIssue( reply );
        return b;
    }

    @Override
    public List<Reply> getReplies(Map<String,Integer> map) {
        List<Reply> replies =  replyDAOMapper.getReplies( map );
        return replies;
    }

    @Override
    @Transactional
    public boolean replyDelete(int replyId) {
        boolean b = replyDAOMapper.replyDelete( replyId );
        return b;
    }
}
