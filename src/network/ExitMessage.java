package network;

import java.io.Serializable;

public class ExitMessage implements Serializable {
    private String Clubname;

    public void setClubname(String clubname) {
        Clubname = clubname;
    }

    public String getClubname() {
        return Clubname;
    }
}
