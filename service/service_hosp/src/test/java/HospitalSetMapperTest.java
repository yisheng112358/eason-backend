import com.atguigu.yygh.hosp.ServiceHospApplication;
import com.atguigu.yygh.hosp.mapper.HospitalSetMapper;
import com.atguigu.yygh.model.hosp.HospitalSet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@SpringBootTest(classes = {ServiceHospApplication.class})
public class HospitalSetMapperTest {

    @Autowired
    private HospitalSetMapper hospitalSetMapper;

    @Test
    @Transactional
    public void hospitalSetMapperInsertSelectDeleteTest() {
        int insertNum = hospitalSetMapper.insert(getHospitalSet());
        assert insertNum == 1;

        List<HospitalSet> allHospitalSet = hospitalSetMapper.selectList(null);
        assert allHospitalSet.get(0).equals(getHospitalSet());

        HashMap<String, Object> map = new HashMap<>();
        map.put("hosname", "三軍總醫院");
        map.put("hoscode", "123");
        map.put("api_url", "456");
        map.put("sign_key", "789");
        map.put("contacts_name", "Eason");
        map.put("status", 0);
        int deleteNum = hospitalSetMapper.deleteByMap(map);
        assert deleteNum == 1;
    }

    private HospitalSet getHospitalSet() {
        HospitalSet hospitalSet = new HospitalSet();
        hospitalSet.setHosname("三軍總醫院");
        hospitalSet.setHoscode("123");
        hospitalSet.setApiUrl("456");
        hospitalSet.setSignKey("789");
        hospitalSet.setContactsName("Eason");
        hospitalSet.setStatus(0);
        return hospitalSet;
    }
}
