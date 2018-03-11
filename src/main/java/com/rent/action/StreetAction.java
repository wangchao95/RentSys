package com.rent.action;
import com.opensymphony.xwork2.ActionSupport;
import com.rent.biz.StreetBiz;
import com.rent.biz.impl.StreetBizImpl;
import com.rent.entity.District;
import com.rent.entity.Street;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import java.util.List;

public class StreetAction extends ActionSupport {

    private StreetBiz streetBiz=new StreetBizImpl();
    private String result;
    private List<Street> streets;
    private District district=new District();
    private String did;
    public void setDid(String did) {
        this.did = did;
    }

    public String getDid() {
        return did;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    /**
     * 获得区县下的街道
     * @return
     */
    public String strList(){
        if(did!=null&&!"".equals(did)){
            district.setId(Integer.parseInt(did));
        }
        streets=streetBiz.getStreets(district);
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[]{"houseSet","district"});//除去HouseSet属性
        try {
            result= JSONArray.fromObject(streets.toArray(),config).toString();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return SUCCESS;
    }

}
