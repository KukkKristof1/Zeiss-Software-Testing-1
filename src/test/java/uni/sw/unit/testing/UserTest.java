package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    
    @Test
    public void testDefaultConstructor(){
        User user = new User();
        assertNotNull(user);

        assertNull(user.getUserName());
        assertNull(user.getPassword());
        assertEquals(user.getId(), 0);
        assertThrows(UnsupportedOperationException.class, user::isLoggedIn);
    }

}
