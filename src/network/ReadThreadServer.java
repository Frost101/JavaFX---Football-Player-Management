package network;

import codes.FileOperations;
import codes.Players;
import util.NetworkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, NetworkUtil> clientMap;


    public ReadThreadServer(HashMap<String, NetworkUtil> map, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();

                if(o instanceof TransferPlayer){
                    TransferPlayer tp = (TransferPlayer) o;
                    Players players = tp.getPlayers();

                    if(tp.getTransferStatus().equalsIgnoreCase("Sell")) {
                        FileOperations.sellList.add(players);
                        SellListContainer sendList = new SellListContainer();
                        sendList.setList(FileOperations.sellList);
                        for (String s : Server.clientNameList) {
                            clientMap.get(s).write(sendList);
                        }
                    }
                    else if(tp.getTransferStatus().equalsIgnoreCase("Buy")) {
                        int cnt = 0;
                        for(Players p : FileOperations.sellList){
                            if(p.getName().equalsIgnoreCase(players.getName())){
                                break;
                            }
                            cnt++;
                        }
                        FileOperations.sellList.remove(cnt);

                        for(Players p : FileOperations.playersList){
                            if(p.getName().equalsIgnoreCase(players.getName())){
                                p.setClub(tp.getClubName());
                            }
                        }

                        for (String s : Server.clientNameList) {
                            SellListContainer sendList = new SellListContainer();
                            sendList.setList(FileOperations.sellList);
                            clientMap.get(s).write(sendList);
                        }

                        for (String s : Server.clientNameList){
                            List<Players> tempList = new ArrayList();
                            for(Players p : FileOperations.playersList){
                                if(p.getClub().equalsIgnoreCase(s)){
                                    tempList.add(p);
                                }
                            }
                            clientMap.get(s).write(tempList);
                        }
                    }
                }
                else if(o instanceof ExitMessage){
                    String removeClient = ((ExitMessage) o).getClubname();
                    int index = 0;
                    for(String s : Server.clientNameList){
                        if(s.equalsIgnoreCase(removeClient)){
                            break;
                        }
                        index++;
                    }
                    Server.clientNameList.remove(index);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



