public class StringWriterTest implements WriterTest{
  @Override
  public Writer createInstance() {
    return new StringWriter();
  }
}
