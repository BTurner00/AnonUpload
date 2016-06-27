package com.theironyard.services;

import com.theironyard.entities.AnonFile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 6/27/16.
 */
public interface AnonFileRepository extends CrudRepository<AnonFile, Integer> {
}
