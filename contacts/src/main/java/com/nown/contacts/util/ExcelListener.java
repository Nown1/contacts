package com.nown.contacts.util;

import java.util.ArrayList;
import java.util.List;

import com.nown.contacts.entity.Student;
import com.nown.contacts.service.StudentService;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.factory.annotation.Autowired;



// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class ExcelListener extends AnalysisEventListener<Student> {

    private static final int BATCH_COUNT = 1;
    private List<Student> list;

    private StudentService studentService;

    @Autowired
    public ExcelListener(StudentService studentService) {

        this.studentService=studentService;
        this.list = new ArrayList<Student>();
    }


    @Override
    public void invoke(Student student, AnalysisContext context) {
        list.add(student);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
       System.out.println("插入完成");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        System.out.println("{}条数据，开始存储数据库！");
        studentService.save(list);
        System.out.println("存储数据库成功！");
    }
}
