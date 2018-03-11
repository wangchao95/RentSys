package com.rent.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rent.biz.DistrictBiz;
import com.rent.biz.impl.DistrictBizImpl;
import com.rent.entity.District;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.util.List;

public class DistrictAction extends ActionSupport {

    private DistrictBiz districtBiz=new DistrictBizImpl();
    private List<District> districtList;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    /**
     * 获得区县列表
     * @return
     */
    public String disList(){
        districtList=districtBiz.getDistrictList();
        try {
            JsonConfig config = new JsonConfig();
             config.setExcludes(new String[]{"streetList"});//除去streetList属性
            result= JSONArray.fromObject(districtList.toArray(),config).toString();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return SUCCESS;
    }

}
