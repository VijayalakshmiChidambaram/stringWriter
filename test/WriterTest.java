import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public interface WriterTest {
  Writer createInstance() throws IOException;

  @Test
  default void CanaryTest() {
    assertTrue(true);
  }

  @Test
  default void testWriteNothingToWriter() throws IOException {
    var instance = createInstance();
    instance.write("");

    assertEquals("", instance.getContents());
  }

  @Test
  default void testWriteAStringToWriter() throws IOException {
    var instance = createInstance();
    instance.write("apple");

    assertEquals("apple", instance.getContents());
  }

  @Test
  default void testWriteStringTwiceToWriter() throws IOException {
    var instance = createInstance();
    instance.write("Apple");
    instance.write("fruit");

    assertEquals("Applefruit", instance.getContents());
  }

  @Test
  default void testWriteCloseWriteToAWriter() throws IOException
  {
    var instance = createInstance();
    instance.write("Apple");
    instance.closeTarget();
    instance.write("fruit");
    assertEquals("Apple", instance.getContents());
  }

  @Test
  default void testCloseThenWriteToAStringWriter() throws IOException
  {
    var instance = createInstance();
    instance.closeTarget();
    instance.write("Apple");
    assertEquals("", instance.getContents());
  }
}
