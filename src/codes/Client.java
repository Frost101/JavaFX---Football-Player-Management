package codes;

import network.ReadThreadClient;
import util.NetworkUtil;

public class Client {

        private NetworkUtil networkUtil;
        private String clientName;
        private Main main;
        private Boolean isConnected = false;


        public Client(){

        }

        public Client(String serverAddress, int serverPort, String clientName, Main main) {
            try {
                networkUtil = new NetworkUtil(serverAddress, serverPort);
                this.clientName = clientName;
                networkUtil.write(clientName);
                this.main =  main;
                String status = (String) networkUtil.read();
                if(status.equalsIgnoreCase("Not Found")){
                    main.showAlert("Invalid Club","No Such Club Exists With This Name. ","Please input club's name correctly");
                }
                else if(status.equalsIgnoreCase("Already Connected")){
                    main.showAlert("Invalid Login","This club is Already connected ","Please input club's name correctly");
                }
                else if(status.equalsIgnoreCase("Success")){
                    isConnected = true;
                    new ReadThreadClient(networkUtil);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public NetworkUtil getNetworkUtil() {
            return networkUtil;
        }

        public String getClientName() {
            return clientName;
        }

         public Boolean getConnected() {
             return isConnected;
         }
}
