package iloveyouboss;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProfileTest {

    @Test
    void matches() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got milk?");

        // must-match 항목이 맞지 않으면 false
        profile.add(new Answer(question, Bool.FALSE));
        Criteria criteria = new Criteria();
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        assertThat(profile.matches(criteria)).isFalse();

        // don't care 항목에 대해서는 true
        profile.add(new Answer(question, Bool.FALSE));
        criteria = new Criteria();
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        assertThat(profile.matches(criteria)).isTrue();
    }
}
