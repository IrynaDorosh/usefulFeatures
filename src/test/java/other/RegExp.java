package other;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RegExp {

    @Test
    public void tt2() {
        String text = "Егор Алла Александр";
        Pattern pattern = Pattern.compile("А.+а");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    @Test
    public void tt3() {
        String str1 = "<b> g </b> e <bb> n </bb> i <brtr> u </wrgehrthr> s <sfergehrhtyjty>";
        System.out.println(str1.replaceAll("\\<[^<>]*\\>", ""));
        log.info("lf4j works or no?)");
    }

    @Test
    public void testName() {
        boolean flag = false;

        try {
            System.out.println("11111");
            throw new RuntimeException("22222");
        } catch (RuntimeException ex) {
            System.out.println("333333");
            flag = true;
        }
        if (!flag) {
            Assert.assertTrue(flag, "element clickable");
        }
    }


    @Test
    public void test2() {


        String str1 = " fy: Playgendary\nDeal: [AU] Liftoff - Banner - 2.10 AUD\n" +
                "Deal Token: LIF-14554-01464\n";

        System.out.println(extractedFirstLine(str1));



    }

    @Test
    public void test22() {
        Assert.fail("sferg");
    }

    public String extractedFirstLine(String str) {
        int beginning = str.indexOf(": ");
        int end = str.contains("\n") ? str.indexOf("\n") : str.length();
        return str.substring(beginning + 2, end);

    }
}
