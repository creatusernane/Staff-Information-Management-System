package com.hl.staffboot.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.ListUtils;
import com.hl.staffboot.pojo.Emp;
import com.hl.staffboot.service.EmpService;

import java.util.List;

/**
 * @ClassName SchoolExcelListener
 * @Description TODO
 * @Author yx
 * @Date 2023/6/28 14:09
 * @Version 1.0
 */

public class EmpExcelListener extends AnalysisEventListener<Emp> {

    //当监听到ExcelReader独骑到了一行数据后，就会调用监听里的方法
    //把ExcelReader读取到的数据获取到，调用service插入到数据库里
    public EmpExcelListener(EmpService empService){
        this.empService=empService;
    }

    private EmpService empService;

    //设置缓存机制：因为ExcelReader读取Excel的速度是大于此监听器处理（调用service--->dao插入到数据库）的速度的
    //声明常量，用于控制缓存里数据的个数
    private final static int CACHECOUNT=100;

    //声明一个集合，作为缓存使用,ExcelReader读取的数据，存于此集合中
    private List<Emp> cacheDataList= ListUtils.newArrayListWithExpectedSize(CACHECOUNT);

    @Override
    //当监听器监听到ExcelReader读取一行数据后，就调用此方法
    public void invoke(Emp emp, AnalysisContext analysisContext) {
        //把形参存入缓存中
        //就已经调用doAfterAllAnalysed函数

        cacheDataList.add(emp);

        //判断缓存是否满
        if(cacheDataList.size()>CACHECOUNT){
            //清空缓存
            cacheDataList=ListUtils.newArrayListWithExpectedSize(CACHECOUNT);

        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //把缓存里的数据，插入到数据中
        for (Emp emp:cacheDataList){
            this.empService.addEmp(emp);
        }
    }
}
