package bowling.model;

public class Frame {

	private int index;
	private String firstShot;
	private String secondShot;

	private final String STRIKE = "X";
	private final String SPARE = "/";
	private final String MISS = "-";

	private ScoreLine scoreLine;

	private boolean bonusFrame = false;
	private boolean lastFrame = false;

	public Frame(int index, ScoreLine scoreLine){
		this.index = index;
		this.scoreLine = scoreLine;
		if (index == 10){
			lastFrame = true;
		}else if (index == 11){
			bonusFrame = true;
		}
	}

	public boolean setStrike(){
		return setValues(STRIKE, null);
	}

	public boolean setBonus(String values){
		if (values.contains(SPARE) || !(values.length() > 0 && values.length() <= 2)){
			return false;
		}else{
			if (values.length() == 1){
				firstShot = values;
			}else if (values.length() == 2){
				firstShot = values.substring(0, 1);
				secondShot = values.substring(1, 2);
			}
			return true;
		}
	}

	public boolean setValues(String values){
		if (values.length() > 0 && values.length() <= 2){
			String firstValue;
			String secondValue;
			if (values.length() == 1){
				firstValue = values;
				secondValue = null;
			}else{
				String[] valuesArray = values.split("|");
				firstValue = valuesArray[0];
				secondValue = valuesArray[1];
			}
			return setValues(firstValue, secondValue);
		}
		return false;
	}

	public boolean setValues(String firstValue, String secondValue){
		boolean isValid = true;

		if(firstValue.equals(SPARE)){
			isValid = false;
		}else if(STRIKE.equalsIgnoreCase(firstValue) && secondValue != null){
			isValid = false;
		}else if(SPARE.equals(firstValue) && SPARE.equals(secondValue)){
			isValid = false;
		}else if(firstValue != null && STRIKE.equalsIgnoreCase(secondValue)){
			isValid = false;
		}else if(firstValue == null || secondValue == null && !(STRIKE.equalsIgnoreCase(firstValue) || STRIKE.equalsIgnoreCase(secondValue))){
			isValid = false;
		}else{
			if (!STRIKE.equalsIgnoreCase(firstValue) && !MISS.equals(firstValue) && !isNumeric(firstValue)){
				isValid = false;
			}else if (STRIKE.equalsIgnoreCase(secondValue) && !SPARE.equals(secondValue) && !MISS.equals(secondValue) && !isNumeric(secondValue)){
				isValid = false;
			}else{
				int total = 0;
				if (isNumeric(firstValue)){
					total += Integer.valueOf(firstValue);
				}
				if (isNumeric(secondValue)){
					total += Integer.valueOf(secondValue);
				}
				if (total > 9){
					isValid = false;
				}
			}
		}

		if (isValid){
			if (STRIKE.equalsIgnoreCase(secondValue)){
				firstValue = STRIKE;
				secondValue = null;
			}
			this.firstShot = firstValue;
			this.secondShot = secondValue;
		}

		return isValid;
	}

	public int getTotalFrameScore(){
		int score = 0;
		int extraShots = 0;

		score = getFrameScore();

		if (STRIKE.equalsIgnoreCase(firstShot) || SPARE.equals(secondShot)){
			if (firstShot.equalsIgnoreCase(STRIKE)){
				extraShots = 2;
			}else{
				extraShots = 1;
			}
		}

		if (extraShots > 0){
			Frame frame = getNextFrame();
			if (frame != null){
				score += frame.getScoreForShots(extraShots);
			}
		}

		return score;
	}

	private Frame getNextFrame(){
		Frame frame = null;
		if (!isBonusFrame()){
			if (isLastFrame()){
				frame = scoreLine.getBonus();
			}else{
				frame = scoreLine.getFrames().get(this.index);
			}
		}
		return frame;
	}

	private int getScoreForShots(int numberOfShots){
		int score = 0;
		if (numberOfShots == 1){
			score = getFirstShotValue();
		}else{
			score = getFirstShotValue();
			if (secondShot == null){
				Frame frame = getNextFrame();
				if (frame != null){
					score += frame.getScoreForShots(1);
				}
			}else{
				score += getSecondShotValue();
			}
		}
		return score;
	}

	private int getFrameScore(){
		int score = getFirstShotValue() + getSecondShotValue();
		return score;
	}

	private int getFirstShotValue(){
		return getValueScore(firstShot, 0);
	}

	private int getSecondShotValue(){
		return getValueScore(secondShot, getFirstShotValue());
	}

	private int getValueScore(String value, int firstShotValue){
		int score = 0;

		if (value != null){
			if (value.equalsIgnoreCase(STRIKE)){
				score = 10;
			}else if (value.equals(SPARE)){
				score = 10 - firstShotValue;
			}else{
				if (isNumeric(value)){
					score += Integer.valueOf(value);
				}
			}
		}

		return score;
	}

	private static boolean isNumeric(String string) {
		return string == null ? false : string.matches("[-+]?\\d*\\.?\\d+");
	}

	public String getFirstShot() {
		return firstShot == null ? "" : firstShot;
	}

	public String getSecondShot() {
		return secondShot == null ? "" : secondShot;
	}

	public int getIndex() {
		return index;
	}

	public boolean isStrike(){
		return getFirstShot().equals(STRIKE);
	}

	public boolean isSpare(){
		return getSecondShot().equals(SPARE);
	}

	public boolean isBonusFrame() {
		return bonusFrame;
	}

	public boolean isLastFrame() {
		return lastFrame;
	}

	@Override
	public String toString() {
		return "Frame [index=" + index + ", firstValue=" + firstShot + ", secondValue=" + secondShot
				+ ", isBonusFrame()=" + isBonusFrame() + ", isLastFrame()=" + isLastFrame() + "]";
	}

}
