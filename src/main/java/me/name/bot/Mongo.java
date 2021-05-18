package me.name.bot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mongo {

//    public Mongo(){
//        String connectionString = "mongodb+srv://Jeffrey:" + Config.get("PASSWORD") + "@freecluster.h5y8j.mongodb.net/FreeCluster?retryWrites=true&w=majority";
//        try(MongoClient mongoClient = MongoClients.create(connectionString)){
//            MongoCollection<Document> data = mongoClient.getDatabase("Discord").getCollection("Banned Words");
//        }
//    }
    /*
    Get the list of banned words from MongoDB and return it.
     */
    public List<String> getBannedWords(MongoDatabase db){
        MongoCollection<Document> words = db.getCollection("Banned Words");

//        words.insertOne(new Document().append("Key", "Value").append("String", "Not String"));
        List<Document> bannedDocument = words.find().into(new ArrayList<>());
        List<String> bannedWords = new ArrayList<>();
        // Get the first Document which is where the words are stored.
        Document wordMap = bannedDocument.get(0);
        for(Map.Entry<String,Object> entry : wordMap.entrySet()){
            if(entry.getValue() instanceof String){
                bannedWords.add(entry.getValue().toString());
            }
        }

        return bannedWords;

    }
}
