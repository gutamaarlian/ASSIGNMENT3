package com.bca.tama.testing.util;

import com.bca.tama.testing.Entity.Mahasiswa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MahasiswaDAO extends PagingAndSortingRepository<Mahasiswa, Integer> {

}
