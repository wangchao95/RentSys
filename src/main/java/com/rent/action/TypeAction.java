package com.rent.action;
import com.opensymphony.xwork2.ActionSupport;
import com.rent.biz.TypeBiz;
import com.rent.biz.impl.TypeBizImpl;
import com.rent.entity.Type;
import net.sf.json.JSONArray;
import java.util.ArrayList;
import java.util.List;
public class TypeAction extends ActionSupport{

    private TypeBiz typeBiz=new TypeBizImpl();
    private String result;
    private List<Type> typeList=new ArrayList<Type>();
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public List<Type> getTypeList() {
        return typeList;
    }
    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }
    /**
     * 获得类型列表
     * @return
     */
    public String getList(){
      typeList = typeBiz.getTypeList();
      JSONArray  jsonArray= JSONArray.fromObject(typeList.toArray());
      result=jsonArray.toString();
      return SUCCESS;
    }

}
