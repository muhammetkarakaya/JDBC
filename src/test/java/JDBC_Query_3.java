import utilities.ReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Query_3 {
    public static void main(String[] args) throws SQLException {

        /*
        User tablosundaki hastalardan user id si 10 dan büyük ve
        15 den kücük olanlarin username ve password bilgilerini yazdirin.
         */

        Statement st = ReusableMethods.createStatement(ReusableMethods.getConnection());

        String query = "SELECT username, password FROM heallife_hospitaltraining.users WHERE user_id >10 AND user_id <15";

        ResultSet rs = st.executeQuery(query);

        //yazdiricaz ama kac tane oldugunu bilmiyoruz , o yüzden bir döngüde yazdiririz.
        //rs.next() manasi: sen üzerinden atlayacak birsey olmayincaya döngüye devam et/yazdir

        while (rs.next()){
            System.out.println(rs.getString("username")+" - "+rs.getString("password"));
            //username ve user_id tabloda vharchar oldugu icin getString ile alabiliriz

        }
        rs.close();
        st.close();





    }
}
