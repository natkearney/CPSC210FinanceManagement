package Category;

import java.io.IOException;
import java.util.List;

public interface Loadable {
    public List<String> load() throws IOException;
}
