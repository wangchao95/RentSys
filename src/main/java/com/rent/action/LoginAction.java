package com.rent.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rent.biz.UserBiz;
import com.rent.biz.impl.UserBizImpl;
import com.rent.entity.Users;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport {
   private Users users;   //用户对象
   private String message;  //提示消息
   private List<Users> usersList; //用户对象集合
    private String repassword;
    private File upload;   //上传到服务器的文件对象
    private String uploadContentType;  //上传的文件类型
    private String uploadFileName;   //上传文件的名称
    private String savePath;   //保存到服务器的那个文件下面
    public String getSavePath() {
        return savePath;
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }
    public String getUploadContentType() {
        return uploadContentType;
    }
    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }
    public String getUploadFileName() {
        return uploadFileName;
    }
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    private UserBiz userBiz=new UserBizImpl();

    /**
     * 登录的方法
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        Users users = userBiz.loginUser(this.users);
        if(users==null){
            message="用户名或者密码错误";
            return "fail";
        }else{
            //登录成功把返回的用户对象赋值给当前登录接受的对象
            this.users=users;
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("user",users);
            return "success";
        }
    }

    /**
     * 退出
     * @return
     */
    public String loginOut(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.clear();
        return "successOut";
    }

    /**
     * 获得用户列表
     * @return
     * @throws Exception
     */
    public String getUserList() throws Exception{
        usersList=userBiz.findUserList();
        return "userList";
    }

    /**
     * 验证方法
     */
    public void validateLogin(){
        if (users==null||users.getUsername()==null ||users.getUsername().length()==0){
            addFieldError("username","用户名不能为空");
        }
        if(users==null||users.getPassword()==null ||users.getPassword().length()==0){
            addFieldError("password","密码不能为空");
        }
    }

    public void validateRegister(){
        if(users==null||users.getUsername()==null||users.getUsername().length()==0){
            addFieldError("username","用户名不能为空");
        }
        if(!users.getPassword().equals(repassword)){
            addFieldError("repwd","两次的密码不一致");
        }
        if(repassword==null||repassword.length()<6){
            addFieldError("repwd","重复密码必须是大于6长度");
        }
        if(users==null||users.getPassword()==null||users.getPassword().length()<6){
            addFieldError("password","密码必须是大于6长度");
        }
        if(users==null||users.getTelephone()==null||users.getTelephone().length()<11){
            addFieldError("telephone","电话必须不能低于11位");
        }
    }


    public String toRegist(){
        return "rigist";
    }

    public String register(){
        String dbPath=null;
        String realPath = ServletActionContext.getRequest().getRealPath(savePath + "\\" + this.getUploadFileName());
        File file=new File(realPath);
        try {
            FileUtils.copyFile(upload,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbPath=savePath+"/"+this.getUploadFileName();
        users.setPhoto(dbPath);
        users.setIsadmin("否");
        if(userBiz.registerUser(users)>0){
            return "rigistSuccess";
        }else{
            return "fail";
        }
    }
}
