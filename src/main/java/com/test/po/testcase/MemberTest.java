package com.test.po.testcase;

import com.test.po.page.ContactPage;
import com.test.po.page.MainPage;
import com.test.po.page.WeWork;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @program: web.testcase.MemberTest
 * @description:
 * @author: zhuruiqi
 * @create: 2021-05-04 16:29
 **/
public class MemberTest {
    @Test
    public void add(){
        //todo: 登录企业微信
        WeWork weWork = new WeWork();
        MainPage mainPage = weWork.login();

        //todo: 进入通讯录
        ContactPage contactPage = mainPage.toMemberAdd();


        //todo：添加成员  头像（有无）  姓名（中英文 特殊字符 长度） 帐号（唯一性、命名规则） 手机（正确 错误 重复） 部门（父子）
        //todo: 参数化 排列组合
        contactPage.add();

        //todo: 保存


        //todo: 判断结果 若干断言
        contactPage.search();
        String s =contactPage.getMember();
        assertThat(s,equalTo("123"));
    }

    @Test
    public void addLink(){
        String res = new WeWork().login().toMemberAdd().add().search().getMember();
        assertThat(res,equalTo("123"));
    }
}
