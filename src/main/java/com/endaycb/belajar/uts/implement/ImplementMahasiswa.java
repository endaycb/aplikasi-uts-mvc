/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.uts.implement;

/**
 *
 * @author mashiro
 */

import com.endaycb.belajar.uts.model.Mahasiswa;
import java.util.List;

public interface ImplementMahasiswa {
    public List<Mahasiswa> getAll();
    public List<Mahasiswa> getByName();
    public void insert(Mahasiswa mahasiswa);
    public void update(Mahasiswa mahasiswa);
    public void delete(Integer id);
}
