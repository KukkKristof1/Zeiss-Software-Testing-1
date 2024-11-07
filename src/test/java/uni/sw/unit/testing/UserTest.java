package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;  

public class UserTest {
    
    @Test
    @DisplayName("Default constructor test")
    public void testDefaultConstructor(){
        User user = new User();
        //assertNotNull(user);

        assertNull(user.getUserName());
        assertNull(user.getPassword());
        assertEquals(user.getId(), 0);
        assertThrows(UnsupportedOperationException.class, user::isLoggedIn);
    }

    @Test
    @DisplayName("Mock test")
    public void testMocking(){
        User user = mock(User.class);

        when(user.getUserName()).thenReturn("Edina");
        when(user.getPassword()).thenReturn("korikedinajelszo");
        when(user.getId()).thenReturn(123);
        when(user.isLoggedIn()).thenReturn(true);

        assertEquals( "Edina", user.getUserName(), "Username should be 'Edina'");
        assertEquals("korikedinajelszo", user.getPassword(), "Password should be 'korikedinajelsoz'");
        assertEquals(123, user.getId(), "Id should be 123");
        assertTrue(user.isLoggedIn(), "Logged in should be true");

        verify(user).getUserName();
        verify(user).getPassword();
        verify(user).getId();
        verify(user).isLoggedIn();

        assertEquals(16, user.getPassword().length());
        verify(user, times(2)).getPassword();

        doThrow(new UnsupportedOperationException()).when(user).isLoggedIn();
        assertThrows(UnsupportedOperationException.class, user::isLoggedIn, "Method should throw UnsupportedOperationException");

        when(user.getAcademicAverage(anyInt())).thenReturn(4.6);
        assertEquals(4.6, user.getAcademicAverage(2));
        assertEquals(4.6, user.getAcademicAverage(3));

        when(user.update(anyString(), eq(true))).thenReturn(true);
        when(user.update(anyString(), eq(false))).thenReturn(false);
        
        assertFalse(user.update("newPass", false), "Update function should return false (not logged in)");
        assertTrue(user.update("newPass", true), "Update function should return true (logged in)");

        doThrow(new UnsupportedOperationException()).when(user).update(anyString(), anyBoolean());
        assertThrows(UnsupportedOperationException.class,
        () -> {user.update("", false);},
        "Method should throw UnsupportedOperationException");

    }
}
