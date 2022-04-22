package games.linkin.pojo;

public class People {
    private int id;
    private String name;
    private String sex;
    private String cardId;
    private String covidTest;
    private String vaccination;

    public People(int id, String name, String sex, String cardId, String covidTest, String vaccination) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.cardId = cardId;
        this.covidTest = covidTest;
        this.vaccination = vaccination;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", cardId='" + cardId + '\'' +
                ", covidTest='" + covidTest + '\'' +
                ", vaccination='" + vaccination + '\'' +
                '}';
    }

    public People() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCovidTest() {
        return covidTest;
    }

    public void setCovidTest(String covidTest) {
        this.covidTest = covidTest;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }
}
