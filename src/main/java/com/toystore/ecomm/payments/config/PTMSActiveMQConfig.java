package com.toystore.ecomm.payments.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class PTMSActiveMQConfig {
	@Value("${proarchs.activemq.broker-url}")
	private String brokerUrl;

	@Value("${proarchs.activemq.queue.stripe_event}")
	private String stripeEventQName;
	
	/*
	 * @Value("${queue.subscription_expiring}") private String
	 * subscriptionExpiringQueue;
	 */
	@Bean
	public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);

		return activeMQConnectionFactory;
	}

	@Bean
	public DefaultJmsListenerContainerFactory paymentDefaultJmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(receiverActiveMQConnectionFactory());
		factory.setConcurrency("3-10");

		return factory;
	}

	@Bean
	public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);

		return activeMQConnectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		return new CachingConnectionFactory(senderActiveMQConnectionFactory());
	}

	@Bean
	public JmsTemplate subscriptionExpiringJmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory());
		jmsTemplate.setDefaultDestinationName(stripeEventQName);

		return jmsTemplate;
	}

	// @Bean
	/*
	 * public DefaultMessageListenerContainer paymentMessageListenerContainer() {
	 * SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
	 * //endpoint.setMessageListener(new StatusMessageListener("DMLC"));
	 * endpoint.setDestination(stripeEventQName);
	 * 
	 * return
	 * paymentDefaultJmsListenerContainerFactory().createListenerContainer(endpoint)
	 * ; }
	 */
}
