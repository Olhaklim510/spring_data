package com.company.spring_data.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;


    public synchronized void add(Note note) {
        noteRepository.save(note);
    }

    public synchronized void deleteById(Long id) {
        if (!noteRepository.findById(id).get().getId().equals(id)) {
            throw new NoSuchElementException("This note doesn't exist");
        }
        noteRepository.deleteById(id);
    }

    public synchronized void update(Note note) {
        if (!noteRepository.findById(note.getId()).get().getId().equals(note.getId())) {
            throw new NoSuchElementException("This note doesn't exist");
        }
        noteRepository.save(note);
    }

    public synchronized Note getById(Long id) {
        if (!noteRepository.findById(id).get().getId().equals(id)) {
            throw new NoSuchElementException("This note doesn't exist");
        }
        return noteRepository.findById(id).get();
    }

    public synchronized List<Note> listAll() {
        return noteRepository.findAll();
    }

    public synchronized List<Note> searchNote(String pattern) {
        return listAll()
                        .stream()
                        .filter(note ->
                                note.getContent().toLowerCase().contains(pattern.toLowerCase())
                                        || note.getTitle().toLowerCase().contains(pattern.toLowerCase()))
                .toList();
    }

//    @PostConstruct
//    public void main() {
//        Note note1 = new Note();
//        note1.setTitle("Test1");
//        note1.setContent("Test1 content");
//        Note note2 = new Note();
//        note2.setTitle("Test2");
//        note2.setContent("Test2 content");
//        Note note3 = new Note();
//        note3.setTitle("Test3");
//        note3.setContent("Test3 content");
//        add(note1);
//        add(note2);
//        add(note3);
//        System.out.println("AFTER ADD");
//        System.out.println("notes = " + notes);
//        System.out.println(notes);
//
//
//        System.out.println("AFTER DELETE");
//        new NoteService().deleteById(3L);
//        System.out.println("notes = " + notes);
//        System.out.println();
//
//        System.out.println("AFTER GET_BY_ID");
//        System.out.println("new NoteService().getById(2) = " + new NoteService().getById(2L));
//        System.out.println();
//
//        System.out.println("AFTER UPDATE");
//        Note noteUpdate = new Note();
//        noteUpdate.setId(2L);
//        noteUpdate.setTitle("TestForUpdate");
//        noteUpdate.setContent("TestForUpdate content");
//        new NoteService().update(noteUpdate);
//        System.out.println("notes = " + notes);
//        System.out.println();
//
//        System.out.println("GET ALL_NOTES");
//        System.out.println("notes = " + new NoteService().listAll());
//    }
}
