package fr.unilim.iut.katatennis;

public class TennisGame1 implements TennisGame {

	private int player1Score = 0;
	private int player2Score = 0;
	private String player1Name;
	private String player2Name;
	
	private String[] verbalScore = { "Love", "Fifteen", "Thirty", "Forty" };

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1Name))
			player1Score ++;
		else
			player2Score ++;
	}

	public String getScore() {
		if (player1Score == player2Score)
			return getScoreForEquality();
		if (player1Score >= 4 || player2Score >= 4)
			return getScoreForAdvantageAndWinner();
		return getStandardScore();
	}

	private String getStandardScore() {
		return verbalScore[player1Score] + '-' + verbalScore[player2Score];
	}

	private String getScoreForAdvantageAndWinner() {
		String score;
		int minusResult = player1Score - player2Score;
		if (minusResult == 1)
			score = "Advantage " + player1Name;
		else if (minusResult == -1)
			score = "Advantage " + player2Name;
		else if (minusResult >= 2)
			score = "Win for " + player1Name;
		else
			score = "Win for " + player2Name;
		return score;
	}

	private String getScoreForEquality() {
		if (player1Score >= 3) return "Deuce";
		else return verbalScore[player1Score] + "-All";
	}
}