package games.linkin.pojo;

import java.util.List;

public class PeopleBean<T> {
    private int totalCount;
    private List<T> row;

    public PeopleBean() {
    }

    @Override
    public String toString() {
        return "PeopleBean{" +
                "totalCount=" + totalCount +
                ", row=" + row +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRow() {
        return row;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }

    public PeopleBean(int totalCount, List<T> row) {
        this.totalCount = totalCount;
        this.row = row;
    }
}
