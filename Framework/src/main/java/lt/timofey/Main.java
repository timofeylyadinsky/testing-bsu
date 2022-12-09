package lt.timofey;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
//mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml clean test

//mvn -Dbrowser=chrome -DfileName="src\test\resources\testng-smoke.xml" clean test
//mvn -Dbrowser=chrome -DfileName="src\test\resources\testng-smoke.xml" -Denvironment=qa clean test