package bowling.game;

import java.util.ArrayList;
import java.util.Random;

import bowling.model.ScoreLine;

public class Game {

	private final int NUMBER_OF_FRAMES = 10;

	private final String STRIKE = "X";
	private final String SPARE = "/";
	private final String MISS = "-";

	public ScoreLine generateScoreLine(){

		ScoreLine scoreLine = new ScoreLine();

		int bonusShots = 0;
		for (int index = 1; index <= NUMBER_OF_FRAMES; index++){
			String frameScore = getFrameScore();

			if (index == NUMBER_OF_FRAMES && bonusShots > 0 && frameScore.length() > 1){
				bonusShots--;
			}

			if (index == NUMBER_OF_FRAMES - 1 && frameScore.equals(STRIKE) ||
					index == NUMBER_OF_FRAMES && frameScore.contains(SPARE)){
				bonusShots = 1;
			}else if (index == NUMBER_OF_FRAMES && frameScore.equals(STRIKE)){
				bonusShots = 2;
			}

			scoreLine.setFrameScore(index, frameScore);
		}

		if (bonusShots > 0){
			scoreLine.setBonusFrameScore(getSingleScore(10, true) + (bonusShots == 2 ? "" + getSingleScore(10, true) : ""));
		}

		return scoreLine;
	}

	public void play(int numberOfPlayers){
		int maxScore = -1;
		ArrayList<Integer> playerNumber = new ArrayList<Integer>();
		for (int index = 1; index <= numberOfPlayers; index++){
			ScoreLine scoreLine = generateScoreLine();
			int score = scoreLine.getScore();
			if (score > maxScore){
				maxScore = score;
				playerNumber.clear();
				playerNumber.add(index);
			}else if (score == maxScore){
				playerNumber.add(index);
			}
			System.out.println("Player " + index + ": " + score + " (" + scoreLine + ")");
		}

		if (playerNumber.size() > 1){
			System.out.print("\nThere is a draw between players:");
			for (Integer player : playerNumber){
				System.out.print(" " + player);
			}
		}else if (numberOfPlayers > 1){
			System.out.println("\nThe winner is: Player " + playerNumber.get(0));
		}
	}

	private String getFrameScore(){
		String frameScore = "";

		int remaining = 10;
		String singleScore = getSingleScore(remaining, true);
		frameScore += singleScore;

		if (!singleScore.equals(STRIKE)){
			remaining = remaining - (singleScore.equals(MISS) ? 0 : Integer.valueOf(singleScore));
			if (isSpare()){
				frameScore += SPARE;
			}else{
				frameScore += getSingleScore(remaining, false);
			}
		}

		return frameScore;
	}

	private String getSingleScore(int remaining, boolean firstShot){
		String singleScore = "";
		int score = getScore(remaining);
		if (score == 0){
			singleScore += MISS;
		}else if (score == remaining){
			singleScore += firstShot ? STRIKE : SPARE;
		}else{
			singleScore += score;
		}
		return singleScore;
	}

	private boolean isStrike(){
		int chance = 25; // The higher the number the lower the chances
		int min = 0;
		int strike = new Random().nextInt((chance - min) + 1) + min;
		return strike == 1;
	}

	private boolean isSpare(){
		int chance = 25; // The higher the number the lower the chances
		int min = 0;
		int spare = new Random().nextInt((chance - min) + 1) + min;
		return spare == 1;
	}

	private int getScore(int pins){
		int min = 0;
		if (pins == 10 && isStrike()){
			return 10;
		}else{
			return new Random().nextInt((pins - min) + 1) + min;
		}
	}

}
