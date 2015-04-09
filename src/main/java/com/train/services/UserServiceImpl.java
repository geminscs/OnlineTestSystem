package com.train.services;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import com.train.daos.IUserDao;  
import com.train.models.User;  
  
@Service  
public class UserServiceImpl implements IUserService {  
      
    @Autowired  
    private IUserDao userdao;  
  
    public int lookUser() {  
        return userdao.lookUser();  
    }  
    /** 
     * 删除表数�? 
     * @return 
     */  
    public int deleteUser(int id){  
        return userdao.deleteUser(id);  
    }  
    /** 
     * 添加数据 
     * @param user 
     */  
    public void saveUser(User user){  
        userdao.saveUser(user);  
    }  
}