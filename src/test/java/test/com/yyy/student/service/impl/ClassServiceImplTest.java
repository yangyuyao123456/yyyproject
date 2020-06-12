package test.com.yyy.student.service.impl; 

import com.alibaba.druid.util.StringUtils;
import com.yyy.student.controller.DTO.ClassRequest;
import com.yyy.student.controller.DTO.ClassResponse;
import com.yyy.student.controller.DTO.StudentRequest;
import com.yyy.student.entity.Class;
import com.yyy.student.entity.Student;
import com.yyy.student.mapper.ClassMapper;
import com.yyy.student.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.List;

/** 
* ClassServiceImpl Tester. 
* 
* @author <Authors name>
* @version 1.0 
*/
@Slf4j
@RunWith(MockitoJUnitRunner.Silent.class)
public class ClassServiceImplTest {
    @Mock
     ClassMapper classMapper;
    @Mock
     StudentMapper studentMapper;

    /**
    *
    * 班级列表查询单元测试
    *
    */
    @Test
    public void testSelectAll() throws Exception {
        List<Class> classes = classMapper.selectAll();
        List<ClassResponse> list = new ArrayList<>();
        for (Class aClass : classes) {
            ClassResponse classResponse = new ClassResponse();
            if (aClass != null){
                BeanUtils.copyProperties(aClass,classResponse);
                list.add(classResponse);
            }
        }
        if (list.size() == 0){
            log.info("未查询到符合条件的列表");
        }
        log.info("实现类层-班级列表返回对象:{}",list);
    }

    /**
    *
    * 班级查询单元测试
    *
    */
    @Test
    public void testSelectByClassId()  {
        log.info("实现类层-班级查询请求对象:{}",2);
        Mockito.when(classMapper.selectByClassId(2)).thenReturn( new Class());
    }

    /**
    *
    * 班级修改单元测试
    *
    */
    @Test
    public void testEditClass() throws Exception {
        Integer edit = 0;
        ClassRequest classRequest=new ClassRequest();
        classRequest.setClassId("3");
        classRequest.setClassNo("第三班");
        log.info("实现类层-班级修改请求对象:{}",classRequest);
        Class aClass = new Class();
        if (classRequest != null){
        BeanUtils.copyProperties(classRequest,aClass);
        //根据classId查询对应的修改前的班级编号
        Mockito.when( classMapper.selectByClassId(aClass.getClassId())).thenReturn(new Class());
        Student student = new Student();
        student.setClassNo(classRequest.getClassNo());
        //根据班级编号查询学生列表
        List<Student> students = studentMapper.queryList(student);
            if (students.size()==0){
                edit = classMapper.updateByPrimaryKey(aClass);
            }else{
                log.info("当前班级有学生，不可修改");
            }
        }else{
        log.info("所传对象为空");
        }
        log.info("实现类层-班级修改返回对象:{}",edit);
    }

    /**
    *
    * 班级新增单元测试
    *
    */
    @Test
    public void testAddClass() throws Exception {
        StudentRequest studentRequest =new StudentRequest();
        Integer i = 0;
        studentRequest.setClassNo("1");
        studentRequest.setName("吴欣欣");
        studentRequest.setSex(1);
        studentRequest.setStudentNo("201977701");
        studentRequest.setGradeNo("1");
        log.info("实现类层-新增学生信息请求对象:{}",studentRequest);
        if (StringUtils.isEmpty(studentRequest.getClassNo())){
        String classNo = studentRequest.getClassNo();
        Class aClass = classMapper.selectByClassNo(classNo);
        if (null != aClass){
            Student student = new Student();
            BeanUtils.copyProperties(studentRequest,student);
            int   j = studentMapper.insertStudent(student);
        }else{
            log.info("新增学生失败，指定班级不存在");
        }
        }
        log.info("实现类层-新增学生信息返回对象:{}",i);

        }
    /**
     *
     * 班级删除单元测试
     *
     */
    @Test
    public void testDeleteClass() throws Exception {

        log.info("实现类层-班级删除请求对象:{}",1);
        //根据classId查询对应的删除前的班级编号
        Mockito.when(classMapper.selectByClassId(1)).thenReturn(new Class());
        Student student = new Student();
        student.setClassNo("1");
        //根据班级编号查询学生列表
        Integer i = 0;
        //根据班级编号查询学生列表
        List<Student> students = studentMapper.queryList(student);
        if (students.size()==0){
            i = classMapper.deleteByPrimaryKey(1);
        }else{
            log.info("当前班级有学生，不可删除");
        }
        log.info("实现类层-班级删除返回对象:{}",i);
    }


} 
