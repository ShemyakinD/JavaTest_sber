package Task11.PlayerPoints;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main9 {
    public static void main(String[] args) {
//        String[] players = new String[]{"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};
        String[] players = new String[]{"Ivan 5", "Alex 10", "Adam 3",  "Adam 8", "Ivan 6", "Alex 5", "Ivan 1", "Adam 5", "Alex 1"};
        System.out.println("Победитель: " + getWinner(players));

    }

    //Вычисляем победителя
    private static String getWinner(String[] players) {

        if (players.length == 0)
            return "Нет участников";

        Map<String, Integer> playerScores = new LinkedHashMap<>();
        String winnerName = "none";
        for (String player : players){
            String temporaryWinner="";
            String playerName = player.split(" ")[0];
            Integer scores = Integer.parseInt(player.split(" ")[1]);
            if (!playerScores.containsKey(playerName))
                playerScores.put(playerName,scores);
            else playerScores.put(playerName,playerScores.get(playerName) + scores);
            temporaryWinner = getWinnerByScores(playerScores);
            if (!winnerName.equalsIgnoreCase(temporaryWinner) && (playerScores.get(winnerName) != playerScores.get(temporaryWinner)))
                winnerName = temporaryWinner;
        }
        return winnerName;
    }

    //Поиск максимума очков по словарю с игроками
    private static String getWinnerByScores(Map<String, Integer> playerScores){
        String winnerName = "";
        int winnerScores = -999999;
        for (String name : playerScores.keySet()){
            if (winnerScores<playerScores.get(name)){
                winnerName = name;
                winnerScores = playerScores.get(name);
            }
        }
        return winnerName;
    }
}
