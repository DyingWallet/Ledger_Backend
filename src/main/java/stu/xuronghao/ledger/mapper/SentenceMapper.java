package stu.xuronghao.ledger.mapper;

import stu.xuronghao.ledger.entity.Sentence;

import java.util.ArrayList;

public interface SentenceMapper {

    boolean insertSentence(String sent);

    boolean insertSentences(ArrayList<String> li);

    Sentence getSentence(int id);

    int CountAll();
}
