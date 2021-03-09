package com.klxx.api.bdmap.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.klxx.api.bdmap.pojo.qo.PlaceQo;
import com.klxx.api.bdmap.pojo.ro.PlaceExportRo;
import com.klxx.api.bdmap.pojo.vo.PlaceApiVo;
import com.klxx.api.bdmap.pojo.vo.PlaceDetailVo;
import com.klxx.api.utils.RestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PlaceApi {

    private static final String API = "http://api.map.baidu.com/place/v2/search?";


    private static PlaceApiVo getPlace(String keyword, String city){
        PlaceQo qo = new PlaceQo();
        qo.setQuery(keyword);
        qo.setRegion(city);
        return RestUtils.getForObjectText(API, qo, PlaceApiVo.class);

    }

    public static void main(String[] args) {
//        山东省，河南省，山西省，陕西省，河北省，北京市，天津市，黑龙江, 辽宁, 吉林，内蒙古，新疆
        List<String> cities = new ArrayList<>();
        // 山东
        cities.add("济南市、青岛市、淄博市、枣庄市、东营市、烟台市、潍坊市、济宁市、泰安市、威海市、日照市、滨州市、德州市、聊城市、临沂市、菏泽市、莱芜市");
        // 河南
        cities.add("郑州市、开封市、洛阳市、平顶山市、焦作市、鹤壁市、新乡市、安阳市、濮阳市、许昌市、漯河市、三门峡市、南阳市、商丘市、信阳市、周口市、驻马店市、济源市");
        // 山西
        cities.add("太原、大同、朔州、忻州、阳泉、吕梁、晋中、长治、晋城、临汾、运城");
        // 陕西
        cities.add("西安市、咸阳市、铜川市、渭南市、延安市、榆林市、汉中市、安康市、商洛市、宝鸡市");
        // 河北省
        cities.add("石家庄 、邯郸、 邢台、 保定 、张家口、 承德、 唐山、秦皇岛 、沧州 、衡水 、廊坊");
        // 黑龙江
        cities.add("哈尔滨市、齐齐哈尔市、牡丹江市、佳木斯市、大庆市、鸡西市、双鸭山市、伊春市、七台河市、鹤岗市、黑河市、绥化市");
        // 辽宁
        cities.add("沈阳市、大连市、鞍山市、抚顺市、本溪市、丹东市、锦州市、营口市、阜新市、辽阳市、盘锦市、铁岭市、朝阳市、葫芦岛市");
        // 吉林
        cities.add("长春市、吉林市、四平市、通化市、白山市、辽源市、白城市、松原市、延边朝鲜族自治州");
        // 内蒙古
        cities.add("呼和浩特市、包头市、乌海市、赤峰市、通辽市、鄂尔多斯市、呼伦贝尔市、巴彦淖尔市、乌兰察布市");
        // 新疆
        cities.add("乌鲁木齐市、克拉玛依市、吐鲁番市、哈密市");
        cities.add("北京市");
        cities.add("天津市");

        List<PlaceExportRo> roList = new ArrayList<>();
        cities.forEach(e -> {
            String[] each = e.split("、");
            for (String str : each) {
                PlaceApiVo vo = getPlace("篮球", str.trim());
                List<PlaceDetailVo> detail = vo.getResults();

                if (!CollectionUtils.isEmpty(detail)) {
                    detail.forEach(k -> {
                        if (StringUtils.hasLength(k.getTelephone())) {
                            roList.add(k.toExportRo());
                        }
                    });
                }
                try {
                    Thread.sleep(10000);
                } catch (Exception ex) {

                }
            }
        });

        if (!CollectionUtils.isEmpty(roList)) {
            ExportParams params = new ExportParams();
            Workbook workbook = ExcelExportUtil.exportExcel(params, PlaceExportRo.class, roList);

            FileOutputStream fos;
            try {
                fos = new FileOutputStream("D:/busketball.xls");

                workbook.write(fos);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }

        }

    }



}
