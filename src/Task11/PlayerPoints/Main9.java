package Task11.PlayerPoints;

import java.util.HashMap;
import java.util.Map;

public class Main9 {
    public static void main(String[] args) {
        String[] players = new String[]{"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"};

        System.out.println("Победитель: " + getWinner(players, 11));

    }

    //Если не задан максимум очков вычисляем без границы
    private static String getWinner(String[] players) {
        return getWinner(players, Integer.MAX_VALUE);
    }

    //Вычисляем победителя, который первым наберёт нужное количество очков
    private static String getWinner(String[] players, int maxScores) {

        if (players.length == 0)
            return "Нет участников";

        Map<String, Integer> playerScores = new HashMap<>();
        for (String player : players){
            String playerName = player.split(" ")[0];
            Integer scores = Integer.parseInt(player.split(" ")[1]);
            if (!playerScores.containsKey(playerName))
                playerScores.put(playerName,scores);
            else playerScores.put(playerName,playerScores.get(playerName) + scores);
            if (playerScores.get(playerName) >= maxScores){
                return playerName;
            }
        }
        return getWinnerByScores(playerScores); //Если предварительно никто не достиг границы очков - ищем максимум
    }

    //Поиск максимума очков по словарю с игроками
    private static String getWinnerByScores(Map<String, Integer> playerScores){
        String winnerName = "";
        int winnerScores = 0;
        for (String name : playerScores.keySet()){
            if (winnerScores<=playerScores.get(name)){
                winnerName = name;
                winnerScores = playerScores.get(name);
            }
        }
        return winnerName;
    }
}
