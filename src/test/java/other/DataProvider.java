package other;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] dataProvider() {
        Object[][] objects = {
                {"qwe"},
                {"asd"}
        };
        return objects;
    }

    @Test(dataProvider = "dataProvider")
    public void tt(String s) {
        System.out.println(s);
    }

}
