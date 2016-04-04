/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 *             AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
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
 */
package net.daw.bean.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.daw.bean.publicinterface.GenericBean;
import net.daw.dao.implementation.EstadoDao;
import net.daw.dao.implementation.TipousuarioDao;
import net.daw.helper.statics.EncodingUtilHelper;

public class UsuarioBean implements GenericBean {

@Expose
    private Integer id;
    @Expose
    private String nombre;
    @Expose
    private String apellidos;
    @Expose
    private String dni;
    @Expose
    private Integer telefono;
    @Expose
    private String login;
    @Expose
    private String password;
    @Expose
    private String email;
    @Expose
    private String provincia;
    @Expose(serialize = false)
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    private TipousuarioBean obj_tipousuario = null;

    public UsuarioBean(){
        this.id = 0;
    }
    
    public UsuarioBean(Integer id){
        this.id = id;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(Integer id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public TipousuarioBean getObj_tipousuario() {
        return obj_tipousuario;
    }

    public void setObj_tipousuario(TipousuarioBean obj_tipousuario) {
        this.obj_tipousuario = obj_tipousuario;
    }
    
    public String toJson (Boolean expand){
        String strJson = "{";
        strJson += "id:" + id + ",";
        strJson += "nombre:" + EncodingUtilHelper.quotate(nombre) + ",";
        strJson += "apellidos:" + EncodingUtilHelper.quotate(apellidos) + ",";
        strJson += "dni:" + EncodingUtilHelper.quotate(dni) + ",";
        strJson += "telefono:" + telefono + ",";
        strJson += "login:" + EncodingUtilHelper.quotate(login) + ",";
        strJson += "password:" + EncodingUtilHelper.quotate(password) + ",";
        strJson += "email:" + EncodingUtilHelper.quotate(email) + ",";
        strJson += "provincia:" + EncodingUtilHelper.quotate(provincia) + ",";
        
        if(expand) {
            strJson += "obj_tipousuario:" + obj_tipousuario.toJson(false) + ",";
        } else {
            strJson += "id_tipousuario:" + id_tipousuario + ",";
        }
        
        strJson += "}";        
        return strJson;
    }
    
    @Override
    public String getColumns() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String strColumns = "";

        strColumns += "id";
        strColumns += "nombre";
        strColumns += "apellidos";
        strColumns += "dni";
        strColumns += "telefono";
        strColumns += "login";
        strColumns += "password";
        strColumns += "email";
        strColumns += "provincia";
        strColumns += "id_tipousuario";
        
        return strColumns;        
    }

    @Override
    public String getValues() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String strColumns = "";
        
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.quotate(nombre) + ",";
        strColumns += EncodingUtilHelper.quotate(apellidos) + ",";
        strColumns += EncodingUtilHelper.quotate(dni) + ",";
        strColumns += telefono + ",";
        strColumns += EncodingUtilHelper.quotate(login) + ",";
        strColumns += EncodingUtilHelper.quotate(password) + ",";
        strColumns += EncodingUtilHelper.quotate(email) + ",";
        strColumns += EncodingUtilHelper.quotate(provincia) + ",";
        strColumns += id_tipousuario;
        
        return strColumns;
    }

    @Override
    public String toPairs() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String strPairs = "";
        
        strPairs += "id=" + id + ",";
        strPairs += "nombre=" + EncodingUtilHelper.quotate(nombre) + ",";
        strPairs += "apellidos=" + EncodingUtilHelper.quotate(apellidos) + ",";
        strPairs += "dni=" + EncodingUtilHelper.quotate(dni) + ",";
        strPairs += "telefono=" + telefono + ",";
        strPairs += "login=" + EncodingUtilHelper.quotate(login) + ",";
        strPairs += "password=" + EncodingUtilHelper.quotate(password) + ",";
        strPairs += "email=" + EncodingUtilHelper.quotate(email) + ",";
        strPairs += "provincia=" + EncodingUtilHelper.quotate(provincia) + ",";
        strPairs += "nombre=" + id_tipousuario;
        
        return strPairs;
    }

    @Override
    public UsuarioBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        this.setId(oResultSet.getInt("id"));
        this.setNombre(oResultSet.getString("nombre"));
        this.setApellidos(oResultSet.getString("apellidos"));
        this.setDni(oResultSet.getString("dni"));
        this.setTelefono(oResultSet.getInt("telefono"));
        this.setLogin(oResultSet.getString("login"));
        this.setPassword(oResultSet.getString("password"));
        this.setEmail(oResultSet.getString("email"));
        this.setProvincia(oResultSet.getString("provincia"));
        if (expand > 0){
            TipousuarioBean oTipousuarioBean = new TipousuarioBean();
            TipousuarioDao oTipousuarioDao = new TipousuarioDao(pooledConnection);
            oTipousuarioBean.setId(oResultSet.getInt("id_tipousuario"));
            oTipousuarioBean = oTipousuarioDao.get(oTipousuarioBean, expand - 1);
            this.setObj_tipousuario(oTipousuarioBean);
        } else {
            this.setId_tipousuario(oResultSet.getInt("id_tipousuario"));
        }
        
        return this;
    }    
    
    
    
    
    
    
    
    
    
/*
    @Expose
    private Integer id;
    @Expose
    private String login = "";
    @Expose
    private String nombre = "";
    @Expose
    private String apellidos = "";
    @Expose
    private String email = "";
    @Expose
    private String password = "";
    @Expose(serialize = false)
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    private TipousuarioBean obj_tipousuario = null;
    @Expose(serialize = false)
    private Integer id_estado = 0;
    @Expose(deserialize = false)
    private EstadoBean obj_estado = null;
    @Expose
    private String ciudad = "";
    @Expose
    private String firma = "";
    @Expose
    private String skin = "";

    public UsuarioBean() {
        this.id = 0;
    }

    public UsuarioBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(Integer id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public TipousuarioBean getObj_tipousuario() {
        return obj_tipousuario;
    }

    public void setObj_tipousuario(TipousuarioBean obj_tipousuario) {
        this.obj_tipousuario = obj_tipousuario;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public EstadoBean getObj_estado() {
        return obj_estado;
    }

    public void setObj_estado(EstadoBean obj_estado) {
        this.obj_estado = obj_estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toJson(Boolean expand) {
        String strJson = "{";
        strJson += "id:" + id + ",";
        strJson += "login:" + EncodingUtilHelper.quotate(login) + ",";
        strJson += "nombre:" + EncodingUtilHelper.quotate(nombre) + ",";
        strJson += "apellidos:" + EncodingUtilHelper.quotate(apellidos) + ",";
        strJson += "email:" + EncodingUtilHelper.quotate(email) + ",";
        strJson += "password:" + EncodingUtilHelper.quotate(password) + ",";
        strJson += "ciudad:" + EncodingUtilHelper.quotate(ciudad) + ",";
        strJson += "firma:" + EncodingUtilHelper.quotate(firma) + ",";
        strJson += "skin:" + EncodingUtilHelper.quotate(skin) + ",";
        if (expand) {
            strJson += "obj_estado:" + obj_estado.toJson(false) + ",";
            strJson += "obj_tipousuario:" + obj_tipousuario.toJson(false) + ",";
        } else {
            strJson += "id_estado:" + id_estado + ",";
            strJson += "id_tipousuario:" + id_tipousuario + ",";
        }
        strJson += "}";
        return strJson;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "nombre,";
        strColumns += "apellidos,";
        strColumns += "email,";
        strColumns += "login,";
        strColumns += "password,";
        strColumns += "ciudad,";
        strColumns += "firma,";
        strColumns += "skin,";
        strColumns += "id_estado,";
        strColumns += "id_tipousuario";

        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += id + ",";
        strColumns += EncodingUtilHelper.quotate(nombre) + ",";
        strColumns += EncodingUtilHelper.quotate(apellidos) + ",";
        strColumns += EncodingUtilHelper.quotate(email) + ",";
        strColumns += EncodingUtilHelper.quotate(login) + ",";
        strColumns += EncodingUtilHelper.quotate(password) + ",";
        strColumns += EncodingUtilHelper.quotate(ciudad) + ",";
        strColumns += EncodingUtilHelper.quotate(firma) + ",";
        strColumns += EncodingUtilHelper.quotate(skin) + ",";
        strColumns += id_estado + ",";
        strColumns += id_tipousuario;

        return strColumns;
    }

    @Override
    public String toPairs() {
        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "login=" + EncodingUtilHelper.quotate(nombre) + ",";
        strPairs += "login=" + EncodingUtilHelper.quotate(apellidos) + ",";
        strPairs += "login=" + EncodingUtilHelper.quotate(email) + ",";
        strPairs += "login=" + EncodingUtilHelper.quotate(login) + ",";
        strPairs += "password=" + EncodingUtilHelper.quotate(password) + ",";
        strPairs += "ciudad=" + EncodingUtilHelper.quotate(ciudad) + ",";
        strPairs += "firma=" + EncodingUtilHelper.quotate(firma) + ",";
        strPairs += "skin=" + EncodingUtilHelper.quotate(skin) + ",";
        strPairs += "id_estado=" + id_estado + ",";
        strPairs += "id_tipousuario=" + id_tipousuario;

        return strPairs;
    }

    @Override
    public UsuarioBean fill(ResultSet oResultSet, Connection pooledConnection, Integer expand) throws SQLException, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setNombre(oResultSet.getString("nombre"));
        this.setApellidos(oResultSet.getString("apellidos"));
        this.setEmail(oResultSet.getString("email"));
        this.setLogin(oResultSet.getString("login"));
        this.setPassword(oResultSet.getString("password"));
        this.setCiudad(oResultSet.getString("ciudad"));
        this.setFirma(oResultSet.getString("firma"));
        this.setSkin(oResultSet.getString("skin"));
        if (expand > 0) {
            EstadoBean oEstadoBean = new EstadoBean();
            EstadoDao oEstadoDao = new EstadoDao(pooledConnection);
            oEstadoBean.setId(oResultSet.getInt("id_estado"));
            oEstadoBean = oEstadoDao.get(oEstadoBean, expand - 1);
            this.setObj_estado(oEstadoBean);
        } else {
            this.setId_estado(oResultSet.getInt("id_estado"));
        }
        if (expand > 0) {
            TipousuarioBean oTipousuarioBean = new TipousuarioBean();
            TipousuarioDao oTipousuarioDao = new TipousuarioDao(pooledConnection);
            oTipousuarioBean.setId(oResultSet.getInt("id_tipousuario"));
            oTipousuarioBean = oTipousuarioDao.get(oTipousuarioBean, expand - 1);
            this.setObj_tipousuario(oTipousuarioBean);
        } else {
            this.setId_tipousuario(oResultSet.getInt("id_tipousuario"));
        }
        return this;

    }
*/
}
