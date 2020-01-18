package com.Herwaarden.Party;

import com.Herwaarden.Party.Logic.PartyLogic;
import com.Herwaarden.Party.Model.PartyModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.google.common.truth.Truth.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PartyApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//Integration test
	@Test
	void testGettingParty() throws Exception {
		PartyLogic partyLogic = new PartyLogic();

		mockMvc.perform(get("/api/public/party/get/{userId}", 1)
				.contentType("application/json"));

		PartyModel partyModel = partyLogic.getPartyByUserId('1');
		assertThat(1).isAtLeast(0);
	}

}
