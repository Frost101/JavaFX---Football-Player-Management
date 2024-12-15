package network;

import codes.Players;

import java.io.Serializable;

public class TransferPlayer implements Serializable {
    private Players players;
    private String transferStatus;
    private String clubName;

    TransferPlayer(){

    }

    public TransferPlayer(Players players){
        this.players = players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Players getPlayers() {
        return players;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
    }
}
