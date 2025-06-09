package com.librarysystemmocking;

import com.LibrarySystemMocking.LibraryRepository;
import com.LibrarySystemMocking.LibraryService;
import com.LibrarySystemMocking.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    private static final String BOOK_TITLE = "Java Programming";
    private static final int QUANTITY = 5;
    private static final String MEMBER_ID = "MEM001";
    private static final String MEMBER_NAME = "John Doe";


    // use inject mocks for the testing object
    @InjectMocks
    private LibraryService underTest;

    // use mock for the dependencies
    @Mock
    private LibraryRepository libraryRepo;


    @Test
    void addBook() {
        underTest.addBook(BOOK_TITLE, QUANTITY); // call the add book method in service class
        verify(libraryRepo).addBook(BOOK_TITLE, QUANTITY); // verify the add book method in the repo was called
    }

    @Test
    void lendBookWithValidMember() {
        underTest.registerMember(MEMBER_ID, MEMBER_NAME); // register a valid member
        when(libraryRepo.lendBook(BOOK_TITLE)).thenReturn(true); // mock the return value when lend book is called
        boolean result = underTest.lendBook(BOOK_TITLE, MEMBER_ID); // test the method
        assertTrue(result); // check expected result
        verify(libraryRepo).lendBook(BOOK_TITLE); // verify the lend book method in the repo was called
    }

    @Test
    void lendBookWithInvalidMember() {
        assertFalse(underTest.lendBook(BOOK_TITLE, MEMBER_ID)); // try to lend book without registering member
        verify(libraryRepo, never()).lendBook(BOOK_TITLE); // verify that library repo was not called
    }

    @Test
    void registerMember() {
        underTest.registerMember(MEMBER_ID, MEMBER_NAME);
        assertEquals(MEMBER_NAME, underTest.getMembers().get(MEMBER_ID).getName());
        assertTrue(underTest.getMembers().containsKey(MEMBER_ID));
    }

}
