package runer;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"order", "pet"})
@IncludeTags("run")
public class TaggedTestsSuite {}