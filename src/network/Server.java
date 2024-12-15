package network;

import codes.FileOperations;
import codes.Players;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;
    public static List<String> clientNameList = new ArrayList();

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33339);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clientName = (String) networkUtil.read();
        Boolean clubFound = false;
        Boolean alreadyIn = false;

        for(Players p : FileOperations.playersList){
            if(p.getClub().equalsIgnoreCase(clientName)){
                clubFound = true;
                break;
            }
        }
        if(clubFound){
            for(String s : Server.clientNameList ){
                if(s.equalsIgnoreCase(clientName)){
                    alreadyIn = true;
                    break;
                }
            }

            if(alreadyIn){
                networkUtil.write("Already Connected");
            }
            else{
                networkUtil.write("Success");
                List<Players> list = new ArrayList();
                for(Players p: FileOperations.playersList){
                    if(p.getClub().equalsIgnoreCase(clientName)){
                        list.add(p);
                    }
                }

                networkUtil.write(list);

                SellListContainer sendList = new SellListContainer();
                sendList.setList(FileOperations.sellList);
                networkUtil.write(sendList);

                clientMap.put(clientName, networkUtil);
                clientNameList.add(clientName);
                new ReadThreadServer(clientMap, networkUtil);
            }

        }
        else {
            networkUtil.write("Not Found");
        }

    }

    public static void main(String args[]) throws Exception {
        FileOperations.readFromFile();
        Server server = new Server();

    }
}
