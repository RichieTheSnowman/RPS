import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RunMe {
	private static final int TOTAL_GAMES = 1000;

	public static void main(String[] args) {
		RPS game = new RPS(); 								// create the game object

		Player p1 = new RandomPlayer();
		Player p2 = new MarkovModel(20);


		for (int i = 0; i < TOTAL_GAMES; i++) { 			// play many games together
			int p1move = p1.getMove(); 						// get the moves from the players
			int p2move = p2.getMove();


			int winner = game.playRound(p1move, p2move); // play the round

			// Display game stats
			System.out.println("Game " + i + ": P1 (" + game.getP1Percent()
					+ "%): " + RPS.intToString(p1move) + "\tP2("
					+ game.getP2Percent() + "%): " + RPS.intToString(p2move)
					+ "\tWinner: " + RPS.getWinnerString(winner));

			// Update both players with this round's info
			p1.updateLastRoundInfo(p1move, p2move, RPS.getWinnerFor(1, winner));
			p2.updateLastRoundInfo(p2move, p1move, RPS.getWinnerFor(2, winner));

			System.out.println(p1move + " " + p2move);
		}

		// Display ending statistics
		System.out.println("Results:\n\tplayer 1 wins: " + game.getP1Percent()
				+ "%\tplayer2 wins: " + game.getP2Percent() + "%\tties: "
				+ game.getTiesPercent() + "%");

	}

	/*private static ArrayList<Integer> increaseArray(ArrayList<Integer> freq, int move) {
		if(move == RPS.ROCK){
			freq.set(0, freq.get(0) + 1);
		}else if(move == RPS.PAPER){
			freq.set(1, freq.get(1) + 1);
		}else {
			freq.set(2, freq.get(2) + 1);
		}

		return freq;

	}*/
}
