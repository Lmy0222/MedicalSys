package com.example.controller;

import com.example.dao.MedicineDao;
import com.example.domain.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineDao medicineDao;

    @GetMapping("/getMedicineByType")
    public List<Medicine> getMedicineByType(@PathParam("type") String type){
        return medicineDao.getMedicineByType(type);
    }
}
