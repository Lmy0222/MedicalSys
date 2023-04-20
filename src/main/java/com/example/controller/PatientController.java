package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dao.PatientDao;
import com.example.domain.Medicine;
import com.example.domain.Patient;
import com.example.domain.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientDao patientdao;


    @RequestMapping("/getList")
    public List<Patient> getList(String apply){
        return patientdao.getList(apply);
    }

    @RequestMapping("/updateApplyById")
    public boolean updateApplyById(@PathParam("id") int id){
        return patientdao.updateApplyById(id);
    }

    @RequestMapping("/updateUseMedicineById")
    public boolean updateUseMedicineById(@PathParam("id") int id){
        return patientdao.updateUseMedicineById(id);
    }

    @RequestMapping("/insertRegistration")
    public boolean insertRegistration(Patient patient){
        return patientdao.insertRegistration(patient);
    }

    @GetMapping("/getCountById")
    public int getCountById(@PathParam("id") int id,@PathParam("apply") String apply,@PathParam("status") String status){
        return patientdao.getCountById(id,apply,status);
    }

    @GetMapping("/getResultById")
    public String getResultById(@PathParam("id") int id){
        return patientdao.getResultById(id);
    }

    @GetMapping("/getSuggestionById")
    public String getSuggestionById(@PathParam("id") int id){
        return patientdao.getSuggestionById(id);
    }

    @GetMapping("/updateSayingById")
    public boolean updateSayingById(@PathParam("id") int id){
        return patientdao.updateSayingById(id);
    }

    @GetMapping("/getUseMedicineById")
    public String getUseMedicineById(@PathParam("id") int id){
        return patientdao.getUseMedicineById(id);
    }

    @RequestMapping("updateSuggestionById")
    public boolean updateSuggestionById(@PathParam("id") int id){
        return patientdao.updateSuggestionById(id);
    }

    @RequestMapping("/updatePlanById")
    public boolean updatePlanById(@PathParam("id") int id){
        return patientdao.updatePlanById(id);
    }

    @GetMapping("/getHistoryByIdCard")
    public List<Patient> getHistoryByIdCard(@PathParam("id") String idCard){
        return patientdao.getHistoryByIdCard(idCard);

    }

}
