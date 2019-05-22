package vn.cosalon.sample.configuration

import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate

@Configuration
@EnableJms // detect annotation @JmsListener exists in source code
open class JmsConfig {

    @Value("\${spring.activemq.broker-url}")
    private lateinit var BROKER_URL: String

    @Value("\${spring.activemq.user}")
    private lateinit var BROKER_USERNAME: String

    @Value("\${spring.activemq.password}")
    private lateinit var BROKER_PASSWORD: String

    @Bean
    @Throws(RuntimeException::class)
    open fun connectionFactory(): ActiveMQConnectionFactory {
        val connectionFactory = ActiveMQConnectionFactory()
        connectionFactory.brokerURL = BROKER_URL
        connectionFactory.userName = BROKER_USERNAME
        connectionFactory.password = BROKER_PASSWORD

        return connectionFactory
    }

    @Bean
    @Throws(RuntimeException::class)
    open fun jmsTemplate(): JmsTemplate {
        val template = JmsTemplate()
        template.connectionFactory = connectionFactory()

        return template
    }

    @Bean
    open fun jmsListenerContainerFactory(): DefaultJmsListenerContainerFactory {
        val factory = DefaultJmsListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory())
        factory.setConcurrency("1-1")
        // true: use jms topic; false: use jms queue
        factory.setPubSubDomain(true)

        return factory
    }

}
