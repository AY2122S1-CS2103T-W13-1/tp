package seedu.address.model.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.interview.CommandTestUtil.*;
import static seedu.address.testutil.TypicalInterviews.ASSISTANT_INTERVIEW;
import static seedu.address.testutil.TypicalInterviews.BOOKKEEPER_INTERVIEW;
import static seedu.address.testutil.TypicalPersons.getTypicalPersons;
import static seedu.address.testutil.TypicalPositions.BOOKKEEPER;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.InterviewBuilder;

public class InterviewTest {

    @Test
    public void isSameInterview() {
        // same object -> returns true
        assertTrue(ASSISTANT_INTERVIEW.isSameInterview(ASSISTANT_INTERVIEW));

        // null -> returns false
        assertFalse(ASSISTANT_INTERVIEW.isSameInterview(null));

        // same name, different candidates -> returns true
        Interview editedAssistanceInterview = new InterviewBuilder(ASSISTANT_INTERVIEW).build();
        assertTrue(ASSISTANT_INTERVIEW.isSameInterview(editedAssistanceInterview));

        // different position, all other attributes same -> returns false
        editedAssistanceInterview = new InterviewBuilder(ASSISTANT_INTERVIEW).withPosition(BOOKKEEPER).build();
        assertFalse(ASSISTANT_INTERVIEW.isSameInterview(editedAssistanceInterview));

        // different candidate, all other attributes same -> returns true
        editedAssistanceInterview = new InterviewBuilder(ASSISTANT_INTERVIEW)
                .withCandidates(VALID_CANDIDATES_SET).build();
        assertTrue(ASSISTANT_INTERVIEW.isSameInterview(editedAssistanceInterview));

        // different start time, all other attributes same -> returns false
        editedAssistanceInterview = new InterviewBuilder(ASSISTANT_INTERVIEW).withStartTime(VALID_START_TIME).build();
        assertFalse(ASSISTANT_INTERVIEW.isSameInterview(editedAssistanceInterview));

        // different duration, all other attributes same -> returns false
        editedAssistanceInterview = new InterviewBuilder(ASSISTANT_INTERVIEW).withDuration(VALID_DURATION).build();
        assertFalse(ASSISTANT_INTERVIEW.isSameInterview(editedAssistanceInterview));

        // different status, all other attribute same -> return true
        editedAssistanceInterview = new InterviewBuilder(ASSISTANT_INTERVIEW)
                .withStatus(VALID_STATUS_COMPLETED).build();
        assertTrue(ASSISTANT_INTERVIEW.isSameInterview(editedAssistanceInterview));

    }

    @Test
    public void equals() {
        // same values -> returns true
        Interview assistantInterviewCopy = new InterviewBuilder(ASSISTANT_INTERVIEW).build();
        assertTrue(ASSISTANT_INTERVIEW.equals(assistantInterviewCopy));

        // same object -> returns true
        assertTrue(ASSISTANT_INTERVIEW.equals(ASSISTANT_INTERVIEW));

        // null -> returns false
        assertFalse(assistantInterviewCopy.equals(null));

        // different type -> returns false
        assertFalse(assistantInterviewCopy.equals(5));

        // different interview -> returns false
        assertFalse(ASSISTANT_INTERVIEW.equals(BOOKKEEPER_INTERVIEW));

        // different position -> returns false
        Interview editedAssistantInterview = new InterviewBuilder(ASSISTANT_INTERVIEW).withPosition(BOOKKEEPER).build();
        assertFalse(ASSISTANT_INTERVIEW.equals(editedAssistantInterview));

        // different candidate -> returns false
        editedAssistantInterview = new InterviewBuilder(ASSISTANT_INTERVIEW)
                .withCandidates(new HashSet<>(getTypicalPersons())).build();
        assertFalse(ASSISTANT_INTERVIEW.equals(editedAssistantInterview));

        // different start time -> return false
        editedAssistantInterview = new InterviewBuilder(ASSISTANT_INTERVIEW)
                .withStartTime(VALID_START_TIME_OTHER_START_TIME).build();
        assertFalse(ASSISTANT_INTERVIEW.equals(editedAssistantInterview));

        // different date -> return false
        editedAssistantInterview = new InterviewBuilder(ASSISTANT_INTERVIEW)
                .withDate(VALID_LOCAL_DATE_OTHER_DATE).build();
        assertFalse(ASSISTANT_INTERVIEW.equals(editedAssistantInterview));

        // different duration -> return false
        editedAssistantInterview = new InterviewBuilder(ASSISTANT_INTERVIEW)
                .withDuration(VALID_DURATION_OTHER_DURATION).build();
        assertFalse(ASSISTANT_INTERVIEW.equals(editedAssistantInterview));

        // different status -> return false
        editedAssistantInterview = new InterviewBuilder(ASSISTANT_INTERVIEW).withStatus(VALID_STATUS_COMPLETED).build();
        assertFalse(ASSISTANT_INTERVIEW.equals(editedAssistantInterview));
    }

}
