package stu.xuronghao.ledger.entity;

public class Sentence {
    private int SenId;
    private String Content;

    public Sentence(int senId, String content) {
        SenId = senId;
        Content = content;
    }

    public Sentence() {

    }

    public int getSenId() {
        return SenId;
    }

    public void setSenId(int senId) {
        SenId = senId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "SenId=" + SenId +
                ", Content='" + Content + '\'' +
                '}';
    }
}
