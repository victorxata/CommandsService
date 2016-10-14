package ie.vhi.common.services.commands;

import static org.assertj.core.api.Assertions.assertThat;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ie.vhi.common.services.commands.models.Payload;
import ie.vhi.common.services.commands.services.MongoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoServiceTests {

	private MongoService _mongoService = new MongoService();

	@Test
	public void CanSaveToMongoDB() {

		String expected = "<xml>Fake payload</xml>";

		String savedId = _mongoService.Save(new Payload(expected));
		assertThat(savedId).isNotNull();

		Document saved = _mongoService.Get(savedId);
		assertThat(saved.get("Content")).isEqualTo(expected);

		_mongoService.Delete(savedId);
	}

	@Test
	public void CanGetFromMongoDB() {
		String _fakeId = MongoDBHelpers.SaveFakeEntity();
		Document payload = _mongoService.Get(_fakeId);
		assertThat(payload.get("Content")).isEqualTo(MongoDBHelpers._fakeEntity.getContent());
		
		_mongoService.Delete(_fakeId);
	}
}
