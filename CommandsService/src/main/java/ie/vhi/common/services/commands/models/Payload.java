package ie.vhi.common.services.commands.models;

import org.springframework.data.annotation.Id;

public class Payload {

	@Id
    public String id;
	
	private String Content;

	public Payload(String string) {
		setContent(string);
	}
	
	public Payload(){
		
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
