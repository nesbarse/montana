/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */

package net.daw.bean.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import net.daw.bean.publicinterface.GenericBean;
import net.daw.dao.implementation.PostDao;

/**
 *
 * @author a022595832b
 */
public class ComentarioBean implements GenericBean{
    
    @Expose
    private Integer id;
    @Expose
    private String mensaje;
    @Expose
    private Date fecha;
    @Expose(serialize = false)
    private Integer id_post = 0;
    @Expose(deserialize = false)
    private PostBean obj_post = null;
    
    public ComentarioBean(){
        this.id = 0;
    }
    
    public ComentarioBean(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public PostBean getObj_post() {
        return obj_post;
    }

    public void setObj_post(PostBean obj_post) {
        this.obj_post = obj_post;
    }
    
    public String toJson(Boolean expand){
        String strJson = "{";
        
        strJson += "id:" + id + ",";
        strJson += "mensaje:" + mensaje + ",";
        strJson += "fecha:" + fecha + ",";
        
        if(expand){
            strJson += "obj_post:" + obj_post.toJson(false) + ",";
        } else{
            strJson += "id_post:" + id_post + ",";
        }
        
        strJson += "}";
        return strJson;
    }

    @Override
    public String getColumns() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String strColumns = "";
    
        strColumns += "id,";
        strColumns += "mensaje,";
        strColumns += "fecha,";
        strColumns += "id_post";
    
        return strColumns;
    }

    @Override
    public String getValues() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String strColumns = "";
        
        strColumns += id + ",";
        strColumns += mensaje + ",";
        strColumns += fecha + ",";
        strColumns += id_post;
    
        return strColumns;
    }

    @Override
    public String toPairs() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String strPairs = "";
        
        strPairs += "id=" + id + ",";
        strPairs += "mensaje=" + mensaje + ",";
        strPairs += "fecha=" + fecha + ",";
        strPairs += "id_post=" + id_post;
    
        return strPairs;
    }

    @Override
    public ComentarioBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        this.setId(oResultSet.getInt("id"));
        this.setMensaje(oResultSet.getString("mensaje"));
        this.setFecha(oResultSet.getDate("fecha"));
        
        if(expand > 0){
            PostBean oPostBean = new PostBean();
            PostDao oPostDao = new PostDao(pooledConnection);
            oPostBean.setId(oResultSet.getInt("id_post"));
            oPostBean = oPostDao.get(oPostBean, expand - 1);
            this.setObj_post(oPostBean);
        } else {
            this.setId_post(oResultSet.getInt("id_post"));
        }
        
        return this;
    }
    
    
    
}
