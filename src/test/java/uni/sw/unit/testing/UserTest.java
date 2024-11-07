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
        assertNotNull(user);

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

        assertEquals(user.getUserName(),  "Edina", "Username should be 'Edina'");
        assertEquals(user.getPassword(), "korikedinajelszo", "Password should be 'korikedinajelsoz'");
        assertEquals(user.getId(), 123, "Id should be 123");
        assertTrue(user.isLoggedIn(), "Logged in should be true");

        verify(user).getUserName();
        verify(user).getPassword();
        verify(user).getId();
        verify(user).isLoggedIn();

    }

}
