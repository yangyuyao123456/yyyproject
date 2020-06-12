package test.com.yyy.student.service.impl; 

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.student.controller.DTO.StudentListRequest;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.controller.DTO.StudentRequest;
import com.yyy.student.entity.Class;
import com.yyy.student.entity.Student;
import com.yyy.student.mapper.ClassMapper;
import com.yyy.student.mapper.StudentMapper;
import com.yyy.student.service.impl.StudentServiceImpl;
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
* StudentServiceImpl Tester. 
* 
* @author yuyao.yang
* @since <pre>20200612</pre>
* @version 1.0 
*/
@Slf4j
@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentServiceImplTest {

    @Mock
    StudentServiceImpl studentServiceimpl;
    @Mock
    StudentMapper studentMapper;
    @Mock
    ClassMapper classMapper;

    /**
    *
    * 查询学生列表单元测试
    *
    */
    @Test
    public void testQueryStudentList() throws Exception {
    StudentListRequest studentRequest =new StudentListRequest();
    studentRequest.setPageNo(1);
    studentRequest.setPageSize(3);
    Integer pageNo = studentRequest.getPageNo();
    Integer pageSize = studentRequest.getPageSize();
    log.info("分页每页条数:{}",pageSize);
    Student student = new Student();
    BeanUtils.copyProperties(studentRequest,student);
    log.info("查询条件对象:{}",student);
    //开启分页
    //对mapper列表查询进行分页处理，查询每页pageSize条时第pageNo页的数据列表
    PageHelper.startPage(pageNo, pageSize);
    List<Student> studentSelectList = studentMapper.queryList(student);
    log.info("查询列表:{}",studentSelectList);
    //初始化返回对象列表
    List<StudentListResponse> responseList = new ArrayList<>();
    for (Student student1 : studentSelectList) {
        StudentListResponse listStudent = new StudentListResponse();
        //将查询出的列表对象复制给返回对象
        BeanUtils.copyProperties(student1,listStudent);
        //将返回对象添加到返回对象列表中
        responseList.add(listStudent);
    }
    log.info("复制后的返回列表:{}",responseList);
    //初始化查询对象列表第pageNo页的PageInfo对象
    PageInfo<Student> studentPageInfo = new PageInfo<>(studentSelectList, pageNo);
    //初始化返回对象列表第pageNo页的PageInfo对象
    PageInfo<StudentListResponse> studentResPage = new PageInfo<>(responseList,pageNo);
    //将对象列表PageInfo对象的总页数和总条数设置给返回对象列表的PageInfo对象
    studentResPage.setPages(studentPageInfo.getPages());
    studentResPage.setTotal(studentPageInfo.getTotal());
    log.info("实现类层-学生列表响应对象:{}",studentResPage);
    }

    /**
     *
     * 查询学生信息单元测试
     *
     */
    @Test
    public void testQueryStudent() throws Exception {
    Mockito.when( studentMapper.selectByStudentNo("2")).thenReturn( new Student() );

    }

    /**
    *
    * 修改学生信息单元测试
    *
    */
    @Test
    public void testEditStudent() throws Exception {
    int i=0;
    StudentRequest studentRequest =new StudentRequest();
    studentRequest.setClassNo("1");
    Class aClass = classMapper.selectByClassNo(studentRequest.getClassNo());
    if (null != aClass){
        Student student = new Student();
        BeanUtils.copyProperties(studentRequest,student);
        i = studentMapper.updateStudentByStudentNo(student);
    }else{
        log.info("更新学生失败，指定班级不存在");
    }

    }

    /**
    *
    * 添加学生信息单元测试
    *
    */
    @Test
    public void testAddStudent() throws Exception {
    StudentRequest studentRequest =new StudentRequest();
    Integer i = 0;
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
    * 删除学生信息单元测试
    *
    */
    @Test
    public void testDeleteStudent() throws Exception {
    log.info("实现类层-更新学生信息请求对象:{}","1");
    Integer i = studentMapper.deleteStudent("1");
    log.info("实现类层-更新学生信息返回对象:{}",i);

    }


    }
