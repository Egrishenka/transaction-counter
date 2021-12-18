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

public class JsonTransactionReader implements TransactionReaderInterface{

    private Path transactionFile;
    private List<Transaction> transactionList;


    public JsonTransactionReader(String transactionFile) {

        this.transactionFile = Paths.get(transactionFile);
        this.transactionList = new ArrayList<>();
    }

    public List<Transaction> getTransactionList() {
        return this.transactionList;
    }

    @Override
    public void readTransactions() throws IOException {

        String jsonTransactionsString = Files.readString(transactionFile);
        Type listType = new TypeToken<List<Transaction>>() {}.getType();
        List<Transaction> transactionList = new Gson().fromJson(jsonTransactionsString, listType);


    }

}
