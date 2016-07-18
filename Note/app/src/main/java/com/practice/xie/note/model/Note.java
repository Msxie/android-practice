package com.practice.xie.note.model;

/**
 * Created by xie on 2016/7/14.
 */
public class Note {
    private int id;
    private String noteDetail;
    private String noteName;
    private String noteDate;

    public int getId() {
        return id;
    }

    public String getNoteDetail() {
        return noteDetail;
    }

    public void setNoteDetail(String noteDetail) {
        this.noteDetail = noteDetail;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
