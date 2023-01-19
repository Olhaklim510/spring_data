package com.company.spring_data.note.dto;

import com.company.spring_data.note.Note;
import java.util.Objects;

public class NoteDTO {
    private Long id;
    private String title;
    private String content;

    public static NoteDTO fromNote(Note note){
        NoteDTO result = new NoteDTO();
        result.setId(note.getId());
        result.setTitle(note.getTitle());
        result.setContent(note.getContent());
        return result;
    }

    public static Note fromDTO(NoteDTO noteDTO){
        Note note=new Note();
        note.setId(noteDTO.getId());
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());
        return note;
    }

    public NoteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDTO noteDTO = (NoteDTO) o;
        return Objects.equals(id, noteDTO.id) && Objects.equals(title, noteDTO.title) && Objects.equals(content, noteDTO.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
