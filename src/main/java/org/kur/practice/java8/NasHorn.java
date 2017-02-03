package org.kur.practice.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Date;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Keyur on 07-10-2016.
 * This Class Demonstrate Nashorn JavaScript Engine that can Invoke and call JavaScript and it's functions inside Java Code.
 */
public class NasHorn {

	public static void main(String[] args) {
		try {
			ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
			scriptEngine.eval("print('Hello World !')");

			scriptEngine.eval(new BufferedReader(new InputStreamReader(NasHorn.class.getClassLoader().getResourceAsStream("script.js"))));

			Invocable invocable = (Invocable) scriptEngine;
			Object result = invocable.invokeFunction("function1", "keyur bhatt");

			System.out.println(result);
			System.out.println(result.getClass());

			invocable.invokeFunction("function2", new Date());

			invocable.invokeFunction("function2", LocalDateTime.now());

		} catch (ScriptException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
