import java.io.*;


public class HighScoreTable {
  private static final int MAX_SIZE = 10;
  private static final String FILE_NAME = "highScores.txt";

  private int[] scores;
  private String[] names;
  private int numEntries;

  public HighScoreTable() {
    scores = new int[MAX_SIZE];
    names = new String[MAX_SIZE];
    numEntries = 0;
  }

  public void addScore(String name, int score) {
    if (numEntries == MAX_SIZE) {
      // Table is full, so we need to remove the lowest score to make room
      int lowestScoreIndex = getLowestScoreIndex();
      scores[lowestScoreIndex] = score;
      names[lowestScoreIndex] = name;
    } else {
      scores[numEntries] = score;
      names[numEntries] = name;
      numEntries++;
    }
    sortTable();
    writeScoresToFile();
  }

  private void sortTable() {
    // Simple selection sort algorithm
    for (int i = 0; i < numEntries - 1; i++) {
      int maxIndex = i;
      for (int j = i + 1; j < numEntries; j++) {
        if (scores[j] > scores[maxIndex]) {
          maxIndex = j;
        }
      }
      int tempScore = scores[i];
      scores[i] = scores[maxIndex];
      scores[maxIndex] = tempScore;
      String tempName = names[i];
      names[i] = names[maxIndex];
      names[maxIndex] = tempName;
    }
  }

  private int getLowestScoreIndex() {
    int index = 0;
    for (int i = 1; i < numEntries; i++) {
      if (scores[i] < scores[index]) {
        index = i;
      }
    }
    return index;
  }

  public void printTable() throws IOException{
	File file = new File ("highScores.txt");

	if(!file.exists()) {
		file.createNewFile();
	}
	FileReader fReader = new FileReader(file);
	String line;

	BufferedReader bReader = new BufferedReader(fReader);
		
	while ((line = bReader.readLine()) != null) {
		System.out.println(line);
	}
	bReader.close();

  }

  public void printTablea() {
    for (int i = 0; i < numEntries; i++) {
      System.out.println((i + 1) + ". " + names[i] + ": " + scores[i]);
    }
  }

  private void writeScoresToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
      for (int i = 0; i < numEntries; i++) {
        writer.println(names[i] + ":" + scores[i]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
