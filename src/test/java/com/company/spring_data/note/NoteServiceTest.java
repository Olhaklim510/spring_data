package com.company.spring_data.note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.NoSuchElementException;

@SpringBootTest
class NoteServiceTest {
    @Autowired
    NoteService noteService;
    @Autowired
    NoteRepository noteRepository;

    @BeforeEach
    public void beforeEach() {
        noteRepository.deleteAll();
    }

    @Test
    void ThatAddHandledCorrectly() {
        Note noteAdd=new Note();
        noteAdd.setTitle("TestNoteAdd");
        noteAdd.setContent("TestNoteContentAdd");
        noteService.add(noteAdd);
        Long id= noteAdd.getId();

        Assertions.assertEquals(noteAdd,noteService.getById(id));
    }

    @Test
    void ThatDeleteByIdHandledCorrectly() {
        Note noteDelete=new Note();
        noteDelete.setTitle("TestNoteDelete");
        noteDelete.setContent("TestNoteContentDelete");
        noteService.add(noteDelete);
        Long id= noteDelete.getId();
        noteService.deleteById(id);

        Assertions.assertThrows(NoSuchElementException.class, () ->noteService.getById(id));
    }

    @Test
    void ThatUpdateHandledCorrectly() {
        Note noteForUpdate=new Note();
        noteForUpdate.setTitle("TestNoteUpdate");
        noteForUpdate.setContent("TestNoteContentUpdate");
        noteService.add(noteForUpdate);
        Long id= noteForUpdate.getId();
        Note noteUpdate = new Note();
        noteUpdate.setId(id);
        noteUpdate.setTitle("TestNoteUpdateNew");
        noteUpdate.setContent("TestNoteContentUpdateNew");
        noteService.update(noteUpdate);

        Assertions.assertEquals(noteUpdate, noteService.getById(id));
    }

    @Test
    void ThatGetByIdHandledCorrectly() {
        Note noteGetById=new Note();
        noteGetById.setTitle("TestNoteGetById");
        noteGetById.setContent("TestNoteContentGetById");
        noteService.add(noteGetById);
        Long id= noteGetById.getId();

        Assertions.assertEquals(noteGetById,noteService.getById(id));

    }

    @Test
    void ThatListAllHandledCorrectly() {

        Note note1FromList=new Note();
        note1FromList.setTitle("TestNote1FromList");
        note1FromList.setContent("TestNote1FromListContent");
        noteService.add(note1FromList);

        Note note2FromList=new Note();
        note2FromList.setTitle("TestNote2FromList");
        note2FromList.setContent("TestNote2FromListContent");
        noteService.add(note2FromList);

        Note note3FromList = new Note();
        note3FromList.setTitle("TestNote3FromList");
        note3FromList.setContent("TestNote3FromListContent");
        noteService.add(note3FromList);

        Assertions.assertEquals(3, noteService.listAll().size());
    }
    @Test
    void ThatSearchHandledCorrectly() {
        Note note1FromList=new Note();
        note1FromList.setTitle("TestNote1FromList");
        note1FromList.setContent("TestNote1FromListContent");
        noteService.add(note1FromList);
        Long id1= note1FromList.getId();

        String pattern="Test";

        Assertions.assertEquals(note1FromList, noteService.searchNote(pattern).get(0));
    }

}