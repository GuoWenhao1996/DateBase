
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Test {

    public static void main(String[] args) {

        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        String sql = null;
        DBHelper dbhelpr = new DBHelper();
        dbhelpr.TestConn();

        //查询student表
        try {
            System.out.println("\n查询学生信息管理表表中内容：");
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            sql = "select xh,xsxm,xxmc,xymc,zymc,bjmc,xb,nl,csrq,mzmc,zzmmmc,jtzz \n"
                    + "	from xs a,mz b,zzmm c,bj d,xx e,xy f,zy g \n"
                    + "	where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm and e.xxdm=f.xxdm and f.xydm=g.xydm and g.zydm=d.zydm\n";
            dbRs = dbState.executeQuery(sql);
                            System.out.println("学号：\t\t姓名：\t学校：\t\t学院：\t\t\t专业：\t\t\t班级：\t\t性别：\t出生日期：\t民族：\t政治面貌：\t家庭住址：" );
            while (dbRs.next()) {
                System.out.print("" + dbRs.getString("xh"));
                System.out.print("\t" + dbRs.getString("xsxm"));
                System.out.print("\t" + dbRs.getString("xxmc"));
                System.out.print("\t" + dbRs.getString("xymc"));
                System.out.print("\t" + dbRs.getString("zymc"));
                System.out.print("\t" + dbRs.getString("bjmc"));
                System.out.print("\t" + dbRs.getString("xb"));
                System.out.print("\t" + dbRs.getString("csrq"));
                System.out.print("\t" + dbRs.getString("mzmc"));
                System.out.print("\t" + dbRs.getString("zzmmmc"));
                System.out.println("\t" + dbRs.getString("jtzz"));
            }
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("\n程序正常结束！");
    }

}
