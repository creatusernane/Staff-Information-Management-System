package com.hl.staffboot.service.Impl;

import com.hl.staffboot.dao.EmpDao;
import com.hl.staffboot.pojo.Emp;
import com.hl.staffboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author yx
 * @Date 2023/10/24 16:12
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> findEmp() {
        return empDao.findEmp();
    }

    @Override
    public String addEmp(Emp emp) {
        int result=empDao.addEmp(emp);
        if(result==1){
            return "success";
        }else{
            return "failed";
        }
    }

    @Override
    public String updateEmp(Emp emp) {
        int result=empDao.updateEmp(emp);
        System.out.println(result);
        if(result==1){
            return "success";
        }else{
            return "failed";
        }
    }

    @Override
    public String deleteEmp(int id) {
        int result=empDao.deleteEmp(id);
        if(result==1){
            return "success";
        }else{
            return "failed";
        }
    }

    @Override
    public List<Emp> findByCondition(String empName, Integer deptno, Integer id) {
        return empDao.findByCondition(empName,deptno,id);
    }
}
