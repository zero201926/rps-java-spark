package models;

public class Rps {
    String computer_choice;
    String player_choice;

    public Rps(Computer computer, String player){
        computer_choice = computer.weapon();
        player_choice = player;
    }

    public String tie(){
        return "Tie! no one wins";
    }

    public String com_wins(){
        return "Computer wins";
    }

    public String pla_wins(){
        return "Player wins";
    }

    public void rock(){
        switch(computer_choice) {
            case "rock":
                tie();
                break;
            case "scissors":
                pla_wins();
                break;
            case "paper":
                com_wins();
                break;
        }

    }

    public void paper(){
        switch(computer_choice) {
            case "rock":
                tie();
                break;
            case "paper":
                com_wins();
                break;
            case "scissors":
                pla_wins();
                break;
        }

    }
    public void scissors(){
        switch(computer_choice) {
            case "rock":
                tie();
                break;
            case "paper":
                pla_wins();
                break;
            case "scissors":
                com_wins();
                break;
        }

    }
    public void match() {
        switch (player_choice) {
            case "rock":
                rock();
                break;
            case "paper":
                paper();
                break;
            case "scissors":
                scissors();
                break;
        }
    }
}
