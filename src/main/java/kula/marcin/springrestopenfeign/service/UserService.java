package kula.marcin.springrestopenfeign.service;

import kula.marcin.springrestopenfeign.client.UserClient;
import kula.marcin.springrestopenfeign.model.TodoModel;
import kula.marcin.springrestopenfeign.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserClient userClient;

    public List<UserModel> getUsers()
    {
        return userClient.getUsers();
    }

}
