package models;

public class Player {
    public static String player_name;

    public Player(String name){
        player_name = name;

    }

    public String name(){
        return player_name;
    }
}
