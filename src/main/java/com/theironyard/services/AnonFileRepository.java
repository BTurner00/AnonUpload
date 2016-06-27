package com.theironyard.services;

import com.theironyard.entities.AnonFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 6/27/16.
 */
public interface AnonFileRepository extends CrudRepository<AnonFile, Integer> {
    int countByPermFileFalse();
    AnonFile findFirstByPermFileFalseOrderByIdAsc();

   //@Query("SELECT min(id) FROM files")
    //int getMinId();
}
