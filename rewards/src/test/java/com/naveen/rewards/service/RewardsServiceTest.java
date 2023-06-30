package com.naveen.rewards.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.ArgumentMatchers.any;

import com.naveen.rewards.model.Customer;
import com.naveen.rewards.model.MonthlyRewardPoints;
import com.naveen.rewards.model.Order;
import com.naveen.rewards.model.RewardPoints;
import com.naveen.rewards.repository.OrderRepository;

@ContextConfiguration(classes = { RewardsService.class })
@ExtendWith(SpringExtension.class)
public class RewardsServiceTest {

	@Autowired
	RewardsService rewardsService;

	@MockBean
	OrderRepository orderRepository;

	// total reward points : 10
	@Test
	public void TestFetchRewardPoints() {
		List<Order> orders = getOrders();
		RewardPoints rewardPoints = new RewardPoints();
		rewardPoints.setTotalRewardPoints(10);
		MonthlyRewardPoints monthlyRewardPoints = new MonthlyRewardPoints(1, "jan", 20);
		List<MonthlyRewardPoints> list = new ArrayList<>();
		list.add(monthlyRewardPoints);
		rewardPoints.setMonthlyRewardPoints(list);
		when(orderRepository.findByCustomerId(any())).thenReturn(orders);
		RewardPoints rewardPointsResult = rewardsService.getRewardPoints(1L);
		assertEquals(rewardPoints.getTotalRewardPoints(), rewardPointsResult.getTotalRewardPoints());
	}

	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("david");
		return customer;
	}

	private List<Order> getOrders() {
		Customer customer = getCustomer();
		List<Order> orders = new ArrayList<>();

		Order order = new Order();
		order.setCustomer(customer);
		order.setId(1L);
		order.setOrderDate(new Date());
		order.setOrderPrice(40d);
		orders.add(order);

		order = new Order();
		order.setCustomer(customer);
		order.setId(2L);
		order.setOrderDate(new Date());
		order.setOrderPrice(60d); // expected reward points : 10
		orders.add(order);
		return orders;

	}
}
