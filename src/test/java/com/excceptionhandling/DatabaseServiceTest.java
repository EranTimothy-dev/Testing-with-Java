package com.excceptionhandling;

import com.exceptionhandling.DatabaseConnection;
import com.exceptionhandling.DatabaseException;
import com.exceptionhandling.DatabaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatabaseServiceTest {

    @Mock
    private DatabaseConnection dbConnectionMock;

    @InjectMocks
    private DatabaseService underTest;

    @Test
    public void databaseConnectionFailure() throws Exception {
        when(dbConnectionMock.getConnection()).thenThrow(new DatabaseException("Connection failed"));
        assertThrows(DatabaseException.class, () -> underTest.getData());
    }
}
