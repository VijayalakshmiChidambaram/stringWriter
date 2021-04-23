import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements Writer {
  private boolean targetOpen = true;
  java.io.FileWriter fileWriter;
  String file = "myfile.dat";

  public FileWriter(String file) throws IOException {
    fileWriter = new java.io.FileWriter(file);
  }

  @Override
  public void write(String word) throws IOException {
    if(targetOpen)
      fileWriter.write(word);
      fileWriter.flush();
  }

  @Override
  public String getContents() throws IOException {
    return Files.readString(Path.of(file));
  }

  @Override
  public void closeTarget() {
    targetOpen = false;
  }
}