package bak.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import bak.dao.PolicyDao;
import bak.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    PolicyDao policyDao;

    @GetMapping("/getById")
    public Policy getById(@PathParam("id") String id) {
        Policy policy = policyDao.selectById(1);
        return policy;
    }

    @GetMapping("/getAll")
    public List<Policy> getAll() {
        List<Policy> policies = policyDao.selectList(null);
        return policies;
    }

    @GetMapping("/getByPage")
    public List<Policy> getAll(@PathParam("curPage") Integer curPage, @PathParam("pageSize") Integer pageSize) {
        List<Policy> policyList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jinli01";
            String username = "root";
            String password = "lmy20030222";
            Connection con = DriverManager.getConnection(url , username , password ) ;
            String sql = "SELECT id,name,type,document,form,organ,text,viadata FROM policy order by viadata desc  LIMIT " + (curPage-1)*pageSize + ","+pageSize+";";
            System.out.println(sql);
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                Integer id= rs.getInt(1);
                String name= rs.getString(2);
                String type= rs.getString(3);
                String document= rs.getString(4);
                String form= rs.getString(5);
                String organ= rs.getString(6);
                String text= rs.getString(7);
                String viadata= rs.getString(8);
                //根据字段名称获取表中的数据
                Policy policy = new Policy(id, name,type,document,form,organ,text,viadata);
                //把当前行封装后的Student对象装载到 List集合中
                policyList.add(policy);
            }
            return policyList;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//
//        IPage<Policy> page = Page.of(curPage, pageSize);
//        page = policyDao.selectPage(new Page<>(1, 5), null);
//
////        System.out.println(page.getRecords());
//        System.out.println(curPage + "    "  + pageSize);



    }

    @PostMapping("/getByCon")
    public List<Policy> getByCon(@RequestBody Policy policy) {
        LambdaQueryWrapper<Policy> qr = new LambdaQueryWrapper<>();
        if (policy.getName() != null && !policy.getName().equals(""))
            qr.like(Policy::getName, policy.getName()).orderByDesc(Policy::getViadata);
        if (policy.getDocument() != null && !policy.getDocument().equals(""))
            qr.like(Policy::getDocument, policy.getDocument()).orderByDesc(Policy::getViadata);
        if (policy.getOrgan() != null && !policy.getOrgan().equals(""))
            qr.like(Policy::getOrgan, policy.getOrgan()).orderByDesc(Policy::getViadata);
        if (policy.getText() != null && !policy.getText().equals(""))
            qr.like(Policy::getText, policy.getText()).orderByDesc(Policy::getViadata);
        List<Policy> policies = policyDao.selectList(qr);
        return policies.subList(0, Math.min(5, policies.size()));
    }


}
