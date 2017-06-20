import java.io.BufferedReader;
import java.io.InputStreamReader;

class HelloWorldApp {
  public static void main(String[] args) { 
    
	try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                System.out.println("Hello World! - " + bufferedReader.readLine());
            } catch (Exception e) {
                //...
            }
    } catch (Exception e) {
            //...
	}
	
  }
}