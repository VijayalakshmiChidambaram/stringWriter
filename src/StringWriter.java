import java.lang.StringBuilder;

public class StringWriter implements Writer {
  private StringBuilder contents = new StringBuilder();
  private boolean targetOpen = true;

  @Override
  public void write(String word) {
    if(targetOpen){
      contents.append(word);
    }
  }

  @Override
  public String getContents() {
    return contents.toString();
  }

  @Override
  public void closeTarget() {
    targetOpen = false;
  }
}
