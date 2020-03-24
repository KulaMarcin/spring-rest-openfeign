package kula.marcin.springrestopenfeign.client;

import kula.marcin.springrestopenfeign.model.TodoModel;
import kula.marcin.springrestopenfeign.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "UserClient", url = "https://jsonplaceholder.typicode.com")
public interface UserClient {
    @GetMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserModel> getUsers();
}
