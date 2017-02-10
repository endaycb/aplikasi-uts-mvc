/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.uts.dao;

/**
 *
 * @author mashiro
 */
import com.endaycb.belajar.uts.implement.ImplementMahasiswa;
import com.endaycb.belajar.uts.model.Mahasiswa;
import com.endaycb.belajar.uts.connection.Conn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMahasiswa implements ImplementMahasiswa {
    Connection connection;
    
    final private String readAll = "SELECT * FROM mahasiswa";
    final private String readByName = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
    final private String insert = "INSERT INTO mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, alamat) VALUES (?,?,?,?,?,?)";
    final private String update = "UPDATE mahasiswa SET npm=?, nama=?, tempat_lahir=?, tanggal_lahir=?, jenis_kelamin=?, alamat=? WHERE id=?";
    final private String delete = "DELETE FROM mahasiswa WHERE id=?";
    
    public DaoMahasiswa(){
        Conn conn = new Conn();
        this.connection = conn.Conn();
    }
    
    /**
     *
     * @return
     */
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> listMahasiswa = null;
        
        Statement st = null;
        try{
            listMahasiswa = new ArrayList<Mahasiswa>();
            st = connection.createStatement();
          
            ResultSet rs = st.executeQuery(readAll);
            
            while(rs.next()){
                Mahasiswa m = new Mahasiswa();
                m.setId(rs.getInt("id"));
                m.setNpm(rs.getString("npm"));
                m.setNama(rs.getString("nama"));
                m.setTempatLahir(rs.getString("tempatLahir"));
                m.setTanggalLahir(rs.getDate("tanggalLahir"));
                m.setJenisKelamin(rs.getString("jenisKelamin"));
                m.setAlamat(rs.getString("alamat"));
                
                listMahasiswa.add(m);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DaoMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listMahasiswa;
        
    }

    public List<Mahasiswa> getByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insert(Mahasiswa mahasiswa) {
        PreparedStatement ps = null;
        
        try{
            ps = connection.prepareStatement(insert);
            ps.setString(1, mahasiswa.getNpm());
            ps.setString(2, mahasiswa.getNama());
            ps.setString(3, mahasiswa.getTempatLahir());
            ps.setDate(4, (Date) new java.sql.Date(mahasiswa.getTanggalLahir().getTime()));
            ps.setString(5, mahasiswa.getJenisKelamin());
            ps.setString(6, mahasiswa.getAlamat());
            
            ps.executeUpdate();
        
         }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(Mahasiswa mahasiswa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
