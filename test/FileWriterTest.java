import java.io.IOException;

public class FileWriterTest implements WriterTest {
  @Override
  public Writer createInstance() throws IOException {
    String file = "myfile.dat";
    return new FileWriter(file);
  }
}