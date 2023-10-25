package com.hl.staffboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.hl.staffboot.dao.DegreeDao;
import com.hl.staffboot.dao.DeptDao;
import com.hl.staffboot.dao.EmpDao;
import com.hl.staffboot.dao.SexDao;
import com.hl.staffboot.pojo.Degree;
import com.hl.staffboot.pojo.Dept;
import com.hl.staffboot.pojo.Emp;
import com.hl.staffboot.pojo.Sex;
import com.hl.staffboot.service.EmpService;
import com.hl.staffboot.util.EmpExcelListener;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author yx
 * @Date 2023/10/24 14:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/emp")
@CrossOrigin("*")
public class EmpController {
    @Autowired
    private SexDao sexDao;
    @Autowired
    private DegreeDao degreeDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmpService empService;

    //查询性别
    @GetMapping("/findsex")
    public List<Sex> findSex(){
        return sexDao.findSex();
    }

    //查询学历
    @GetMapping("/finddegree")
    public List<Degree> findDegree(){
        return degreeDao.findDegree();
    }

    //查询部门
    @GetMapping("/finddept")
    public List<Dept> findDept(){
        return deptDao.findDept();
    }

    //查询职工
    @GetMapping("/findemp")
    public Map<String,Object> findEmp(){
        List<Emp> emps=empService.findEmp();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("data",emps);
        map.put("total",emps.size());
        return map;
    }

    //增加职工
    @PostMapping("/addemp")
    public String addEmp(@RequestBody Emp emp){
        return empService.addEmp(emp);
    }

    //修改职工信息
    @PutMapping("/updateemp")
    public String updateEmp(@RequestBody Emp emp){
        return empService.updateEmp(emp);
    }

    //删除员工信息
    @DeleteMapping("/deleteemp")
    public String deleteEmp(int id){
        return empService.deleteEmp(id);
    }

    //模糊查询
    @GetMapping("/findbycondition/{empName}/{deptno}/{id}")
    public Map<String,Object> findByCondition(@PathVariable("empName") String empName,
                                              @PathVariable("deptno") Integer deptno,
                                              @PathVariable("id") Integer id){
        List<Emp> emps=empService.findByCondition(empName,deptno,id);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("data",emps);
        map.put("total",emps.size());
        return map;
    }

    //导出信息
    @GetMapping("/downLoad")
    public void downLoadAllSchool(HttpServletResponse response) throws IOException {
        //1.获取到要导出的数据
        List<Emp> emps=empService.findEmp();
//        List<Degree> degrees=degreeDao.findDegree();
        //2.设置Http响应协议，响应的内容是Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //3.设置到处的Excel的编码方式
        response.setCharacterEncoding("utf-8");
        //4.设置浏览器另存窗口的属性信息
        String fileName= URLEncoder.encode("职工信息汇总","UTF-8").replace("\\+","%20");
        //5、设置响应协议的协议头，设置后另存窗口就显示设置的文件名及扩展名
        response.setHeader("Content-disposition","attachment;filename*=utf-8''" + fileName + ".xlsx");
        //6.创建Exccel写入器：用于导出
        //参数1：通过response对象获取的输出流，通过此输出流进行excel的导出
        //参数2：控制、限定流里输出的类型，类对象
        ExcelWriter excelWriter= EasyExcel.write(response.getOutputStream(),Emp.class).build();
//        ExcelWriter excelWriter1= EasyExcel.write(response.getOutputStream(),Degree.class).build();
        //7.声明导出的Excel表中的sheet页信息
        WriteSheet sheet=EasyExcel.writerSheet("职工信息").build();
//        WriteSheet sheet1=EasyExcel.writerSheet("学历信息").build();
        //8.导出
        excelWriter.write(emps,sheet);
//        excelWriter.write(degrees,sheet1);
        //9.关闭流
        excelWriter.finish();
//        excelWriter1.finish();
    }

    //Excel导入
    @PostMapping("/upload")
    public String uploadExcel(@RequestPart("file") MultipartFile file){
        System.out.println("开始导入......");
        String result="";
        //创建Excel读取器ExcelReader，用于从file中读取file文件
        ExcelReader excelReader=null;
        //参数1：从形参中获取得到导入的excel，通过输入流
        //参数2：读取到Excel的一行数据之后，转换成的对象类型
        //参数3：读取Excel监听器，当监听到，已经读取了一行数据，那么监听器就开始处理读取到的数据
        try {
            excelReader=EasyExcel.read(file.getInputStream(),Emp.class,new EmpExcelListener(empService)).build();
            //声明从Excel表的哪个sheet页中读取数据
            //0 代表Excel中的第一个sheet页
            ReadSheet readSheet=EasyExcel.readSheet(0).build();

            //开始导入
            excelReader.read(readSheet);
            result="success";

        } catch (IOException e) {
            result="failed";
            e.printStackTrace();
        }

        return result;
    }

}
