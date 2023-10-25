package com.hl.staffboot.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author yx
 * @Date 2023/10/24 14:33
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ContentRowHeight(30)//设置Excel表格的行高
@HeadRowHeight(50)//设置EXcel标题行的高度
@ColumnWidth(20)//设置列宽
public class Emp {
    @ExcelProperty(value = {"职工信息详情","ID"},index = 0)
    private int id;
    @ExcelProperty(value = {"职工信息详情","姓名"},index = 1)
    private String empName;
    @ExcelProperty(value = {"职工信息详情","性别"},index = 2)
    private int sex;
    @ExcelProperty(value = {"职工信息详情","年龄"},index = 3)
    private int age;
    @ExcelProperty(value = {"职工信息详情","部门"},index = 4)
    private int deptName;
    @ExcelProperty(value = {"职工信息详情","学历"},index = 5)
    private int empDegreeName;

    //一对一映射
    @ExcelIgnore
    private Sex sex1;
    @ExcelIgnore
    private Dept dept;
    @ExcelIgnore
    private Degree degree;

}
