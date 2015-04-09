package com.train.services;

import com.train.models.User;

public interface IUserService {  
    public int lookUser();  
    public int deleteUser(int id);  
    public void saveUser(User user);  
      
}  