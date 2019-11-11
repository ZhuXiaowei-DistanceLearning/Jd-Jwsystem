package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.domain.AuthFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Mapper
public interface AuthFunctionMapper extends BaseMapper<AuthFunction> {
    @Select("SELECT DISTINCT af.id\n" +
            "        FROM `auth_function` af,\n" +
            "             `auth_role` ar,\n" +
            "             `role_function` rf\n" +
            "        WHERE ar.`id` = rf.`role_id`\n" +
            "          AND rf.`function_id` = af.`id`\n" +
            "          AND ar.`id` = #{id};")
    List<Integer> queryFunctionByRole(String id);

    @Select("select * from auth_function")
    List<AuthFunction> findAll();

    @Select("SELECT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id` LEFT OUTER JOIN\n" +
            "\t\t`teacher_role` ON ar.`id`=\n" +
            "\t\tteacher_role.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_teacher` ON\n" +
            "\t\tteacher_role.`teacher_id`=t_teacher.`tid`\n" +
            "\t\tWHERE\n" +
            "\t\tt_teacher.`tid`=\n" +
            "\t\t#{value};")
    List<AuthFunction> findListByTeacherid(String userid);

    @Select("SELECT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id` LEFT OUTER JOIN\n" +
            "\t\t`student_role` ON ar.`id`=\n" +
            "\t\tstudent_role.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_student` ON\n" +
            "\t\tstudent_role.`student_id`=t_student.`sid`\n" +
            "\t\tWHERE\n" +
            "\t\tt_student.`sid`=#{value};")
    List<AuthFunction> findListByStudentid(String userid);

    @Select("SELECT DISTINCT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\tFunction f LEFT OUTER JOIN\n" +
            "\t\tf.roles r\n" +
            "\t\tLEFT OUTER JOIN r.user s WHERE\n" +
            "\t\ts.id\n" +
            "\t\t= #{value}")
    List<AuthFunction> findListByUserid(String userid);

    @Select("SELECT * FROM\n" +
            "\t\t`auth_function` f WHERE f.generatemenu\n" +
            "\t\t= '1'\n" +
            "\t\tORDER BY\n" +
            "\t\tf.zindex DESC")
    List<AuthFunction> findAllMenu();

    @Select("SELECT\n" +
            "\t\tDISTINCT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id`\n" +
            "\t\tLEFT OUTER JOIN `user_role` ON ar.`id`=\n" +
            "\t\t`user_role`.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_user` ON\n" +
            "\t\t`user_role`.`user_id`=`t_user`.`id`\n" +
            "\t\tWHERE\n" +
            "\t\t`t_user`.`id`=#{value} AND\n" +
            "\t\tf.`generatemenu` = '1' ORDER\n" +
            "\t\tBY f.`zindex`\n" +
            "\t\tDESC;")
    List<AuthFunction> findMenuByUserid(String id);

    @Select("SELECT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id`\n" +
            "\t\tLEFT OUTER JOIN `teacher_role` ON ar.`id`=\n" +
            "\t\tteacher_role.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_teacher` ON\n" +
            "\t\tteacher_role.`teacher_id`=t_teacher.`tid`\n" +
            "\t\tWHERE\n" +
            "\t\tt_teacher.`tid`=#{value} AND f.`generatemenu` = '1' ORDER\n" +
            "\t\tBY f.`zindex`\n" +
            "\t\tDESC;")
    List<AuthFunction> findMenuByTeacherid(String id);

    @Select("SELECT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id`\n" +
            "\t\tLEFT OUTER JOIN `student_role` ON ar.`id`=\n" +
            "\t\tstudent_role.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_student` ON\n" +
            "\t\tstudent_role.`student_id`=t_student.`sid`\n" +
            "\t\tWHERE\n" +
            "\t\tt_student.`sid`=#{value} AND f.`generatemenu` = '1' ORDER\n" +
            "\t\tBY f.`zindex`\n" +
            "\t\tDESC;")
    List<AuthFunction> findMenuByStudentid(String id);
}
