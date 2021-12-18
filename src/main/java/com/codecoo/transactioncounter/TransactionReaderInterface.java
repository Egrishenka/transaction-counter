package com.codecoo.transactioncounter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface TransactionReaderInterface {
    void readTransactions() throws IOException;
}
