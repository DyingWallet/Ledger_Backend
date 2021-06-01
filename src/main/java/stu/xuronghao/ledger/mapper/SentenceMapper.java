package stu.xuronghao.ledger.mapper;

import org.apache.ibatis.annotations.Mapper;
import stu.xuronghao.ledger.entity.Sentence;

import java.util.ArrayList;

@Mapper
public interface SentenceMapper {

    boolean insertSentence(String sent);

    boolean insertSentences(ArrayList<String> li);

    Sentence getSentence(int id);

    int CountAll();
}
