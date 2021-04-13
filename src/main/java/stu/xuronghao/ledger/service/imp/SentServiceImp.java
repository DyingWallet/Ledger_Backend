package stu.xuronghao.ledger.service.imp;

import stu.xuronghao.ledger.entity.Sentence;
import stu.xuronghao.ledger.mapper.SentenceMapper;
import org.springframework.stereotype.Service;
import stu.xuronghao.ledger.service.SentService;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class SentServiceImp implements SentService {
    @Resource
    SentenceMapper mapper;

    @Override
    public String getReply() {
        int id = 0;
        Random random = new Random();
        Sentence sentence;

        id = 1 + random.nextInt(mapper.CountAll());

        sentence = mapper.getSentence(id);
        return sentence.getContent();
    }

}
