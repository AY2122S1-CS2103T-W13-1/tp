package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.interview.DeleteInterviewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class DeleteInterviewCommandParser implements Parser<DeleteInterviewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteInterviewCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteInterviewCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, pe.getMessage())
                    + DeleteInterviewCommand.MESSAGE_USAGE, pe);
        }
    }
}
