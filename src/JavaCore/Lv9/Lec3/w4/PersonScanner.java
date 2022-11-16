package JavaCore.Lv9.Lec3.w4;

import java.io.IOException;
import java.util.List;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
