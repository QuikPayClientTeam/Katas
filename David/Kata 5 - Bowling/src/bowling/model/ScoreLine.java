package bowling.model;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ScoreLine {

	private static final Logger LOGGER = Logger.getLogger(ScoreLine.class.getName());

	private final int NUMBER_OF_FRAMES = 10;

	private ArrayList<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private boolean valid = true;

	public ScoreLine(){
		init();
	}

	private void init(){
		frames.clear();
		for (int index = 1; index <= NUMBER_OF_FRAMES; index++){
			frames.add(new Frame(index, this));
		}
		bonus = new Frame(NUMBER_OF_FRAMES + 1, this);
	}

	public boolean setFrameScore(int frameNumber, String frameScore){
		if (valid){
			if (frameNumber <= NUMBER_OF_FRAMES){
				valid = frames.get(frameNumber - 1).setValues(frameScore);
			}else{
				valid = false;
			}
		}
		return valid;
	}

	public boolean setBonusFrameScore(String frameScore){
		if (valid){
			valid = bonus.setBonus(frameScore);
		}
		return valid;
	}

	public boolean setScoreLine(String line){
		init();
		String[] framesArray = line.split("\\|");

		int index = 0;

		boolean isBonus = false;
		for (String frame : framesArray){
			index++;
			if (isBonus){
				int bonusShotsNeeded = bonusShotsNeeded();
				if (bonusShotsNeeded > 0 && frame.length() == bonusShotsNeeded){
					boolean validBonus = bonus.setBonus(frame);
					if (!validBonus){
						LOGGER.severe("Bonus frame is not valid");
						valid = false;
						break;
					}
				}else{
					if (bonusShotsNeeded == 0){
						LOGGER.severe("This scoreline shouldn't have a bonus frame.");
					}else if (frame.length() != bonusShotsNeeded){
						LOGGER.severe("The number of bonus shots is not correct.");
					}
					valid = false;
					break;
				}
			}else{
				if (frame.equals("")){
					isBonus = true;
				}else{
					if (index > NUMBER_OF_FRAMES){
						LOGGER.severe("More than " + NUMBER_OF_FRAMES + " frames found!");
						valid = false;
						break;
					}else{
						boolean validFrame = setFrameScore(index, frame);
						if (!validFrame){
							LOGGER.severe("Frame #" + index + " is not valid");
							valid = false;
							break;
						}
					}
				}
			}
		}

		if (index < NUMBER_OF_FRAMES){
			LOGGER.severe("Less than " + NUMBER_OF_FRAMES + " frames found!");
			valid = false;
		}

		if (!valid){
			init();
		}

		return valid;
	}

	private int bonusShotsNeeded(){
		int bonusShotsNeeded = 0;

		Frame frame = frames.get(NUMBER_OF_FRAMES - 1);
		if (frame.isStrike()){
			bonusShotsNeeded = 2;
		}else if (frame.isSpare()){
			bonusShotsNeeded = 1;
		}else{
			bonusShotsNeeded = 0;
		}

		return bonusShotsNeeded;
	}

	public int getScore(){
		int score = 0;
		if (isValid()){
			for (int index = 0; index < NUMBER_OF_FRAMES; index++){
				score += frames.get(index).getTotalFrameScore();
			}
		}else{
			LOGGER.severe("The scoreline is not valid.");
		}
		return score;
	}

	public ArrayList<Frame> getFrames() {
		return isValid() ? frames : null;
	}

	public Frame getBonus() {
		return isValid() ? bonus : null;
	}

	public boolean isValid() {
		return valid;
	}

	@Override
	public String toString() {
		String line = "";
		if (isValid()){
			line = generateScoreLineString();
		}else{
			line = "Not valid";
		}
		return "ScoreLine: " + line;
	}

	private String generateScoreLineString(){
		String scoreLineString = "";

		for (Frame frame : frames){
			scoreLineString += frame.getFirstShot() + frame.getSecondShot() + "|";
		}

		if (!bonus.getFirstShot().equals("")){
			scoreLineString += "|" + bonus.getFirstShot() + bonus.getSecondShot();
		}

		return scoreLineString;
	}

}
