package com.naveen.rewards.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naveen.rewards.model.RewardPoints;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class RewardsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void getRewardPointsOnDollarsSpentBelow50() throws Exception {
		ObjectMapper om = new ObjectMapper();

		int id = 5;

		RewardPoints expectedRewardPoints = new RewardPoints();
		expectedRewardPoints.setTotalRewardPoints(0);

		RewardPoints actualRewardPoints = om.readValue(mockMvc.perform(get("/api/v1/rewards/" + id))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), RewardPoints.class);

		Assert.assertTrue(expectedRewardPoints.getTotalRewardPoints() == actualRewardPoints.getTotalRewardPoints());
	}

	@Test
	public void getRewardPointsOnDollarsAbove50Below100() throws Exception {
		ObjectMapper om = new ObjectMapper();

		int id = 6;

		RewardPoints expectedRewardPoints = new RewardPoints();
		expectedRewardPoints.setTotalRewardPoints(10);

		RewardPoints actualRewardPoints = om.readValue(mockMvc.perform(get("/api/v1/rewards/" + id))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), RewardPoints.class);

		Assert.assertTrue(expectedRewardPoints.getTotalRewardPoints() == actualRewardPoints.getTotalRewardPoints());

	}

	@Test
	public void getRewardPointsOnDollarsSpent100() throws Exception {
		ObjectMapper om = new ObjectMapper();

		int id = 7;

		RewardPoints expectedRewardPoints = new RewardPoints();
		expectedRewardPoints.setTotalRewardPoints(50);

		RewardPoints actualRewardPoints = om.readValue(mockMvc.perform(get("/api/v1/rewards/" + id))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), RewardPoints.class);

		Assert.assertTrue(expectedRewardPoints.getTotalRewardPoints() == actualRewardPoints.getTotalRewardPoints());

	}

	@Test
	public void getRewardPointsOnDollarsSpentAbove100() throws Exception {
		ObjectMapper om = new ObjectMapper();
		
		int id = 1;
		
		RewardPoints expectedRewardPoints = new RewardPoints();
		expectedRewardPoints.setTotalRewardPoints(155);

        RewardPoints actualRewardPoints = om.readValue(mockMvc.perform(get("/api/v1/rewards/" + id))
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString(), RewardPoints.class);
        
        Assert.assertTrue(expectedRewardPoints.getTotalRewardPoints() == actualRewardPoints.getTotalRewardPoints());

	}
}