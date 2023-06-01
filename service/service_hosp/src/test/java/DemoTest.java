import com.atguigu.yygh.hosp.ServiceHospApplication;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {ServiceHospApplication.class})
public class DemoTest {

    @Autowired
    private HospitalSetService hospitalSetService;

    @Test
    public void test() {
        List<HospitalSet> allHospitalSet = hospitalSetService.list();
        allHospitalSet.forEach(System.out::println);
    }
}
