package com.bca.tama.testing.util;

import com.bca.tama.testing.Entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

}
