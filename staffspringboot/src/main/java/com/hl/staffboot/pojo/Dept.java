package com.hl.staffboot.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName Dept
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
public class Dept {
    @ExcelProperty(value = {"部门信息详情","ID"},index = 0)
    private int deptno;
    @ExcelProperty(value = {"部门信息详情","部门名称"},index = 1)
    private String deptName;

}
