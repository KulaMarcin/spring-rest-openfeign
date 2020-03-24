package kula.marcin.springrestopenfeign.service;

import kula.marcin.springrestopenfeign.client.TodoClient;
import kula.marcin.springrestopenfeign.model.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoClient todoClient;

    public List<TodoModel> getTodos()
    {
        return todoClient.getTodos();
    }

    public List<TodoModel> getTodosBy(int id)
    {
        return todoClient.getTodosBy(id);
    }
}
