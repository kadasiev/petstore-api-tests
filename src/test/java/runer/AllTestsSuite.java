package runer;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectPackages;

@Suite
@SelectPackages({"order", "pet"})
public class AllTestsSuite {}
