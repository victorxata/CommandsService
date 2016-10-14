

package ie.vhi.common.services.commands;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.vhi.common.services.commands.models.Command;
import ie.vhi.common.services.commands.services.MongoService;
import ie.vhi.common.services.commands.services.RabbitService;

@RestController
public class CommandsServiceController {
	
	protected Logger logger = Logger.getLogger(CommandsServiceController.class
			.getName());
	private MongoService _mongoService = new MongoService();
	
	
	@RequestMapping(value="/commands", method=RequestMethod.POST)
    public String commands(@RequestBody Command command) {
		logger.info("Request to save command in queue: " + command.getCommand());
		
		String correlationId = _mongoService.Save(command.getPayload());
		
		String id = RabbitService.AddCommand(correlationId, command.getCommand());		
		
        return id;		
    }

}