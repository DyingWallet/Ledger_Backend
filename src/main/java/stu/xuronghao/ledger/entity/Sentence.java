package stu.xuronghao.ledger.entity;

public class Sentence {
    private int sentenceId;
    private String content;

    public Sentence(int senId, String content) {
        sentenceId = senId;
        this.content = content;
    }

    public Sentence() {}

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "SenId=" + sentenceId +
                ", Content='" + content + '\'' +
                '}';
    }
}
