public class TennisGame {
    public static final char SUBTRACTION = '-';
    public static String display = "";

    public static String getScore(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
           equalScore(player1Score);
        }
        else if (player1Score >= 4 || player2Score >= 4) {
            playerScoreGreaterThan4(player1Score,player2Score);
        }
        else {
            playerScoreLessThan4(player1Score, player2Score);
        }
        return display;
    }

    public static void playerScoreGreaterThan4(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            display = "Advantage player1";
        }
        else if (minusResult == -1) {
            display = "Advantage player2";
        }
        else if (minusResult >= 2) {
            display = "Win for player1";
        }
        else if (minusResult <= -2){
            display = "Win for player2";
        }
    }

    public static void equalScore(int playerScore) {
        switch (playerScore) {
            case 0:
                display = "Love-All";
                break;
            case 1:
                display = "Ten-All";
                break;
            case 2:
                display = "Twenty-All";
                break;
            case 3:
                display = "Thirty-All";
                break;
            default:
                display = "Deuce";
                break;
        }
    }

    public static void playerScoreLessThan4(int player1Score, int player2Score) {
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            }
            else {
                display += SUBTRACTION;
                tempScore = player2Score;
            }

            switch(tempScore) {
                case 0:
                    display += "Love";
                    break;
                case 1:
                    display += "Ten";
                    break;
                case 2:
                    display += "Twenty";
                    break;
                case 3:
                    display += "Thirty";
                    break;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(TennisGame.getScore(2,3));
        System.out.println(TennisGame.getScore(1,1));
        System.out.println(TennisGame.getScore(5,3));
    }
}
