package ie.vhi.common.services.commands.services;

import ie.vhi.common.services.commands.CommandsServiceController;
import ie.vhi.common.services.commands.models.Payload;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.Console;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoService{

	protected Logger _logger = Logger.getLogger(CommandsServiceController.class
			.getName());
	
	private MongoClient _client;
	private MongoDatabase _db;
	private String _server;
	private Integer _port;
	private String _database;
	private String _collection;
	private Boolean _initialized = false;
	
	public MongoService(String server, Integer port, String database, String collection){
		_server = server;
		_port = port;
		_database = database;
		_collection = collection;
	}
	
	public MongoService(){
		_server = "localhost";
		_port = 27017;
		_database = "fitbit";
		_collection = "test";
	}
	
	private void Initialize(){
		if (!_initialized){
			_client = new MongoClient(_server, _port);
			_db = _client.getDatabase(_database);
		}
	}
	
	public String Save(Payload payload) {
		Initialize();
		Document doc = new Document().append("Content", payload.getContent());
		_db.getCollection(_collection).insertOne(doc);
		return doc.get("_id").toString();
	}
	
//	public Document Get(String _id){
//		Initialize();
//		BasicDBObject query=new BasicDBObject("_id",new ObjectId(_id));
//		Document doc = _db.getCollection(_collection).find(query).first();
//		return doc;
//	}

	public void Delete(String savedId) {
		Initialize();
		BasicDBObject query=new BasicDBObject("_id",new ObjectId(savedId));
		_db.getCollection(_collection).deleteOne(query);
		
	}
	
	public Document Get(String id) {
		Initialize();
	    BasicDBObject query = new BasicDBObject();
	    _logger.info("MongoService::Get ==> " + id);
	    query.put("_id", new ObjectId(id));
	    Document dbObj = _db.getCollection(_collection).find(query).first();
	    return dbObj;
	}
	
}