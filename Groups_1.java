package Folders;
import org.testng.annotations.Test;

public class Groups_1 {
	
@Test(groups= {"Smoke1"})
public void method1() {
	
	System.out.println("Method1 is executed");
	
}
@Test(groups= {"Smoke1"})
public void method2(){
	
	System.out.println("Method2 is executed");
}
@Test(groups= {"Smoke1"})
public void method3(){
	
	System.out.println("Method3 is executed");
}
@Test
public void method4() {
	
	System.out.println("Method4 is executed");
	
}
@Test(groups={"Smoke1"})
public void method5() {
	
System.out.println("Method4 is executed");


}



}
