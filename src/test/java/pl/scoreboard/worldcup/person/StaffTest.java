package pl.scoreboard.worldcup.person;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class StaffTest {

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    public void shouldCheckEqualsAndHashCodeContract() {
        EqualsVerifier.simple().forClass(Staff.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

}