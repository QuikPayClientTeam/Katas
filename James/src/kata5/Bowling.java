package kata5;

public class Bowling {

	public static void main(String[] args) {

		 System.out.println(parseScore("1-|2-|3-|4-|5-|6-|7-|8-|9-|0-||")); //45
		 System.out.println(parseScore("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||")); //90
		 System.out.println(parseScore("X|X|X|X|X|X|X|X|X|X|X|X")); // 300
		 System.out.println(parseScore("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/|5")); 		//150
		 System.out.println(parseScore("X|7/|9-|X|-8|8/|-6|X|X|X|81")); //167
	}

	public static int parseScore(String input) {
		int score = 0;

		// replace slashes for 0s
		input = input.replace('-', '0');

		
		
		
		// split string into each frame
		String temp[] = input.split("\\|");
		
		String[] frames = new String[temp.length];
		
		//place split string into frames. 
		//do not do this in the parsing loop otherwise next frame is null. 
		for(int i = 0; i < frames.length; i++){
			frames[i] = temp[i];
		}

		//parsing loop
		for (int i = 0; i < 10; i++) {
			

			// strike
			if ("X".equalsIgnoreCase(frames[i].substring(0, 1))) {
				score += 10;
				// next frame if strike
				if ("X".equalsIgnoreCase(frames[i + 1].substring(0, 1))) {
					score += 10;

					// two frames ahead
					if ("X".equalsIgnoreCase(frames[i + 2].substring(0, 1))) {
						score += 10;
					} else {
						score += Integer.valueOf(frames[i + 2].substring(0, 1));
					} // end two frames

				} else if ("/".equalsIgnoreCase(frames[i + 1].substring(1, 2))) {
					score += 10;

				} else {
					score += (Integer.valueOf(frames[i + 1].substring(0, 1))
							+ Integer.valueOf(frames[i + 1].substring(1, 2)));
				}

			} // end strike

			// spare
			if (!"X".equalsIgnoreCase(frames[i].substring(0, 1)) && "/".equalsIgnoreCase(frames[i].substring(1, 2))) {
				score += (10 + Integer.valueOf(frames[i + 1].substring(0, 1)));
			} // end spare

			if (!"X".equalsIgnoreCase(frames[i].substring(0, 1)) && !"/".equalsIgnoreCase(frames[i].substring(1, 2))) {
				score += (Integer.valueOf(frames[i].substring(0, 1)) + Integer.valueOf(frames[i].substring(1, 2)));
			}

		}

		return score;
	}

}
