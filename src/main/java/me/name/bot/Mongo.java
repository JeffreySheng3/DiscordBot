package me.name.bot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/*
    A wrapper for MongoDB functions.
 */
public class Mongo {
    public MongoDatabase db;
    public final String connectionString = "mongodb+srv://Jeffrey:" + Config.get("PASSWORD") + "@freecluster.h5y8j.mongodb.net/FreeCluster?retryWrites=true&w=majority";

    public Mongo(){

    }

    public MongoDatabase getConnection(){
        return db;
    }

    /*
    Get the list of banned words from MongoDB and return it.
     */
    public List<String> getBannedWord(){
        try(MongoClient mongoClient = MongoClients.create(connectionString)){
            System.out.println("Connection established");
            MongoCollection<Document> words = mongoClient.getDatabase("Discord").getCollection("Banned Words");
            List<Document> bannedDocument = words.find().into(new ArrayList<>());
            List<String> bannedWords = new ArrayList<>();
            // Get the first Document which is where the words are stored.
//            Document wordMap = bannedDocument.get(0);
            for(Document d : bannedDocument){
                bannedWords.add((String)d.get("word"));
            }
            return bannedWords;
        }catch(Exception e){
            System.out.println("Caught mongo exception: " + e);
        }
        return new ArrayList<>();
    }

    /*
        Add a single banned word onto MongoDB with the mapping of ("word", word)
     */
    public void addBannedWord(String word){
        try(MongoClient mongoClient = MongoClients.create(connectionString)){
            System.out.println("Connection established");
            MongoCollection<Document> mCollection = mongoClient.getDatabase("Discord").getCollection("Banned Words");
            mCollection.insertOne(new Document("word", word));

        }catch(Exception e){
            System.out.println("Caught mongo exception: " + e);
        }
    }

}
