package reflection;

import reflection.data.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodV3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("호출 메서드: ");
        String methodName = scanner.nextLine();

        System.out.print("숫자 1: ");
        int num1 = scanner.nextInt();
        System.out.print("숫자 2: ");
        int num2 = scanner.nextInt();

        Calculator calculator = new Calculator();
        Class<? extends Calculator> clazz = calculator.getClass();
        Method method = clazz.getMethod(methodName, int.class, int.class);
        
        Object result = method.invoke(calculator, num1, num2);
        System.out.println("result = " + result);
    }
}
