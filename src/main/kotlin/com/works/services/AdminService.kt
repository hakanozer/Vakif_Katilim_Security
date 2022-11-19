package com.works.services

import com.works.utils.DB
import org.springframework.stereotype.Service

@Service
class AdminService {

    /*
    fun login(email:String, password: String):Boolean {
        var status:Boolean = false
        var db = DB()
        try {
            var sql = "select * from admin where email = '"+email+"' and password = '"+password+"'"
            var st = db.connect().createStatement();
            var rs = st.executeQuery(sql);
            status = rs.next();
        }catch (ex:Exception) {

        }finally {
            db.close()
        }
        return status
    }
     */

    fun login(email:String, password: String):Boolean {
        var status:Boolean = false
        var db = DB()
        try {
            var sql = "select * from admin where email = ? and password = ?"
            var st = db.connect().prepareStatement(sql);
            st.setString(1, email)
            st.setString(2, password)
            var rs = st.executeQuery();
            status = rs.next();
        }catch (ex:Exception) {

        }finally {
            db.close()
        }
        return status
    }

}