package ru.aikamsoft.parser.json.operation;

import ru.aikamsoft.exception.WrongArgumentCountException;
import ru.aikamsoft.exception.WrongArgumentException;
import ru.aikamsoft.exception.WrongDateFormatException;
import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.result.Result;

import java.io.IOException;

public interface OperationJsonParser {
    Operation initOperation(String inputSrcName)
            throws
            WrongArgumentCountException,
            WrongArgumentException,
            IOException,
            WrongDateFormatException;

    void saveOperationResult(Result result, String outputSrcName);

}
