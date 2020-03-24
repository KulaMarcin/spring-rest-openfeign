package kula.marcin.springrestopenfeign.client;

import kula.marcin.springrestopenfeign.model.TodoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="TodoClient", url="https://jsonplaceholder.typicode.com")
public interface TodoClient {
    @GetMapping(value = "/todos", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<TodoModel> getTodos();

    @GetMapping(value = "/todos", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<TodoModel> getTodosBy(@RequestParam("userId") Integer userId);
}
