package network;

import codes.Players;
import util.NetworkUtil;

import java.util.List;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;

    public ReadThreadClient(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();

                Boolean flag = false;

                if(o instanceof List){
                    ListContainerClient.playersList.clear();
                    ListContainerClient.playersList.addAll((List<Players>)o);
                    flag = true;
                }
                else if(o instanceof SellListContainer){
                    SellListContainer sc = (SellListContainer) o;
                    ListContainerClient.marketList.clear();
                    ListContainerClient.marketList.addAll(sc.getList());
                    flag = true;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



