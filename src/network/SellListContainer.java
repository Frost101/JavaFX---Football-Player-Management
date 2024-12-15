package network;

import codes.Players;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SellListContainer implements Serializable {
    List<Players> list = new ArrayList();

    SellListContainer(){

    }

    public void setList(List<Players> list) {
        this.list.addAll(list);
    }

    public List<Players> getList() {
        return list;
    }
}
