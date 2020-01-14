import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	public void run(Class<?> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		final Constructor<?> constructor = clazz.getConstructor();
		final Object o = constructor.newInstance();
		final Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(Test.class)) {
				m.invoke(o);
			}
		}
	}
}
