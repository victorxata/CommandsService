package ie.vhi.common.services.commands;

import ie.vhi.common.services.commands.models.Payload;
import ie.vhi.common.services.commands.services.MongoService;

public class MongoDBHelpers{
	
	public static Payload _fakeEntity = new Payload("<xml>content</xml>");	
	public static String _id;
	public static MongoService _service = new MongoService();
	
	public static String SaveFakeEntity(){
		return _service.Save(_fakeEntity);
		
	}
	

}