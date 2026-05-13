package java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {

  public static void main(String[] args) {

//    This should only works in older java versions
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

//    javascript code as a string
    String script = "var greeting = 'Hello, Nashorn!'; greeting";

//    Execute the script
    try {
      Object result = engine.eval(script);
      System.out.println(result);
    } catch (ScriptException e) {
      e.printStackTrace();
    }

  }

}
