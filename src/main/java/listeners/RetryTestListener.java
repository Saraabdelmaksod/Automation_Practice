package listeners;


import org.testng.IAnnotationTransformer;
import org.testng.TestListenerAdapter;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


// as .xml file not understand true or false that result from RetryTestAnalyzer Class so we used IAnnotationTransformer
public class RetryTestListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
    }
}
