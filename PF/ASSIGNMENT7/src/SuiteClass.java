import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ CountClumpTest.class, FixXYTest.class, MirrorTest.class,
		SplitPointTest.class })
public class SuiteClass {

}
