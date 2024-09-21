package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/* to automatically retry a failed test to automatically retry a failed test*/
public class RetryAnalyzer implements IRetryAnalyzer {
	
	int count = 0;
	int retryCount = 1;

	public boolean retry(ITestResult result) {
		
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
