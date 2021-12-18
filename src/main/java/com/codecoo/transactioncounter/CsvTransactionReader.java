package com.codecoo.transactioncounter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionReader implements TransactionReaderInterface {

    private Path transactionFile;
    private List<Transaction> transactionList;


    public CsvTransactionReader(String transactionFile) {

        this.transactionFile = Paths.get(transactionFile);
        this.transactionList = new ArrayList<>();
    }

    public List<Transaction> getTransactionList() {
        return this.transactionList;
    }

    @Override
    public void readTransactions() throws IOException {

        List<String> csvTransactionsStrings = Files.readAllLines(transactionFile);

        for (String str : csvTransactionsStrings) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length - 1; i++) {
                transactionList.add(new Transaction(split[i], Integer.parseInt(split[i + 1])));
            }
        }
    }
}