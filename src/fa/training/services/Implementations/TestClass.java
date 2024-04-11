package fa.training.services.Implementations;

import fa.training.services.Interfaces.TestInterface;

public class TestClass implements TestInterface {
    @Override
    public void testMethod(int a) {
        System.out.println(a);
    }
}
