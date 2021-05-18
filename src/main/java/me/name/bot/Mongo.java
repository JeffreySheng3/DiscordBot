package me.name.bot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Mongo {

//    public Mongo(){
//        String connectionString = "mongodb+srv://Jeffrey:" + Config.get("PASSWORD") + "@freecluster.h5y8j.mongodb.net/FreeCluster?retryWrites=true&w=majority";
//        try(MongoClient mongoClient = MongoClients.create(connectionString)){
//            MongoCollection<Document> data = mongoClient.getDatabase("Discord").getCollection("Banned Words");
//        }
//    }

    public void createDocument(MongoCollection<Document> words){
        List<Document> wordList = new ArrayList<>();
        wordList.add(new Document("test", 1));
        words.insertMany(wordList);
    }
}
