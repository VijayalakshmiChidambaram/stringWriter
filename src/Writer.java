import java.io.IOException;

public interface Writer {
  void write(String text) throws IOException;
  String getContents() throws IOException;
  void closeTarget();
}
