package seedu.sudohr.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.sudohr.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.sudohr.commons.exceptions.IllegalValueException;
import seedu.sudohr.commons.util.JsonUtil;
import seedu.sudohr.model.SudoHr;
import seedu.sudohr.testutil.TypicalPersons;

public class JsonSerializableSudoHrTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableSudoHrTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableSudoHr dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableSudoHr.class).get();
        SudoHr sudoHrFromFile = dataFromFile.toModelType();
        SudoHr typicalPersonsSudoHr = TypicalPersons.getTypicalAddressBook();
        assertEquals(sudoHrFromFile, typicalPersonsSudoHr);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableSudoHr dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableSudoHr.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableSudoHr dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableSudoHr.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableSudoHr.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }

}
