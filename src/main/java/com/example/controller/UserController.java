package com.example.controller;



import com.example.domain.Medicine;
import com.example.domain.Patient;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.dao.UserDao;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/getOne")
    public User getOne(@PathParam("id") Integer id){
        return userDao.selectById(id);
    }

    @GetMapping("/getList")
    public List<User> getList(@PathParam("status") String status){
        return userDao.getList(status);
    }

    @GetMapping("/getMedicineByType")
    public List<Medicine> getMedicineByType(@PathParam("type") String type){
        return userDao.getMedicineByType(type);
    }

    @RequestMapping("/updateApplyById")
    public boolean updateApplyById(@PathParam("id") int id){
        return userDao.updateApplyById(id);
    }

    @RequestMapping("/updateUseMedicineById")
    public boolean updateUseMedicineById(@PathParam("id") int id){
        return userDao.updateUseMedicineById(id);
    }

    @RequestMapping("/insertRegistration")
    public boolean insertRegistration(Patient patient){
        return userDao.insertRegistration(patient);
    }

    @GetMapping("/getCountById")
    public int getCountById(@PathParam("id") int id,@PathParam("apply") String apply,@PathParam("status") String status){
        return userDao.getCountById(id,apply,status);
    }

    @GetMapping("/getResultById")
    public String getResultById(@PathParam("id") int id){
        return userDao.getResultById(id);
    }

    @GetMapping("/getSuggestionById")
    public String getSuggestionById(@PathParam("id") int id){
        return userDao.getSuggestionById(id);
    }

    @GetMapping("/updateSayingById")
    public boolean updateSayingById(@PathParam("id") int id){
        return userDao.updateSayingById(id);
    }

    @GetMapping("/getUseMedicineById")
    public String getUseMedicineById(@PathParam("id") int id){
        return userDao.getUseMedicineById(id);
    }

    @RequestMapping("updateSuggestionById")
    public boolean updateSuggestionById(@PathParam("id") int id){
        return userDao.updateSuggestionById(id);
    }

    @RequestMapping("/updatePlanById")
    public boolean updatePlanById(@PathParam("id") int id){
        return userDao.updatePlanById(id);
    }

    @GetMapping("/getHistoryByIdCard")
    public List<Patient> getHistoryByIdCard(@PathParam("id") String idCard){
        return userDao.getHistoryByIdCard(idCard);
    }


}
