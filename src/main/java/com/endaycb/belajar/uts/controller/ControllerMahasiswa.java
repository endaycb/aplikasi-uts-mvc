/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.uts.controller;

import com.endaycb.belajar.uts.dao.DaoMahasiswa;
import com.endaycb.belajar.uts.implement.ImplementMahasiswa;
import com.endaycb.belajar.uts.model.Mahasiswa;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mashiro
 */
public class ControllerMahasiswa extends HttpServlet{
    
    private ImplementMahasiswa mDao  = new DaoMahasiswa();
    
    //@Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        
    }
    
    //@Override
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        try{
            Mahasiswa m = new Mahasiswa();
            m.setNpm(req.getParameter("npm"));
            m.setNama(req.getParameter("nama"));
            m.setTempatLahir(req.getParameter("tempat_lahir"));

            String strTanggalLahir = req.getParameter("tanggal_lahir");
            SimpleDateFormat formatterTanggal = new SimpleDateFormat("yyyy-MM-dd");

            m.setTanggalLahir(formatterTanggal.parse(strTanggalLahir));

            m.setJenisKelamin(req.getParameter("jenis_kelamin"));
            m.setAlamat(req.getParameter("alamat"));

            mDao.insert(m);

            res.sendRedirect("MahasiswaFormView.html");
        } catch (Exception ex){
                ex.printStackTrace();
        }
    }
}
