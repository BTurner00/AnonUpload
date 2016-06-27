package com.theironyard.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ben on 6/27/16.
 */
@Entity
@Table(name="files")
public class AnonFile {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable=false)
    String originalFileName;
    @Column(nullable=false)
    String realFileName;
    @Column
    String comment;
    @Column (nullable=false)
    Boolean permFile;

    public AnonFile() {
    }

    public AnonFile(String originalFileName, String realFileName, String comment, Boolean permFile) {
        this.originalFileName = originalFileName;
        this.realFileName = realFileName;
        this.comment = comment;
        this.permFile = permFile;
    }

    public Boolean getPermFile() {
        return permFile;
    }

    public void setPermFile(Boolean permFile) {
        this.permFile = permFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getRealFileName() {
        return realFileName;
    }

    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
