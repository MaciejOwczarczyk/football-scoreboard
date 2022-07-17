package pl.scoreboard.worldcup.person;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StaffTest {

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    void shouldCheckEqualsAndHashCodeContract() {
        EqualsVerifier.simple().forClass(Staff.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

}