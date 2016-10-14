package ie.vhi.common.services.commands;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ie.vhi.common.services.commands.models.Command;
import ie.vhi.common.services.commands.services.RabbitService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitServiceTests {

	private RabbitService _rabbitService = new RabbitService();

		@Test
	public void CanSaveACommandToRabbitMQ() {

	}

}
