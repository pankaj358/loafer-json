package devloafer.projects.code.jsonify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Pankaj Tirpude [tirpudepankaj@gmail.com]
 * @date 20190602
 */

public class LoaferJsonTest extends TestCase
{
  private final static Logger logger = LoggerFactory.getLogger(LoaferJsonTest.class);
  /**
   * Create the test case
   *
   * @param testName
   *          name of the test case
   */
  public LoaferJsonTest(String testName)
  {
    super(testName);
    logger.info("initializing loafer json test...");
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
    return new TestSuite(LoaferJsonTest.class);
  }

  /**
   * Rigourous Test :-)
   */
  public void loaferJsonTest()
  {
    assertTrue(true);
  }
}
