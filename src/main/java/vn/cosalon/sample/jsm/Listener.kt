package vn.cosalon.sample.jsm

import com.google.gson.Gson
import org.springframework.jms.JmsException
import javax.jms.Message;
import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.annotation.JmsListeners
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import javax.jms.TextMessage

@Component
open class Listener {
    @JmsListener(destination = "inbound.queue")
    @SendTo("outbound.queue")
    @Throws(JmsException::class)
    open fun receiveMessage(jsonMessage: Message): String? {
        var messageData: String?
        println("Received message: $jsonMessage")
        var response: String? = null
        if (jsonMessage is TextMessage) {
            messageData = jsonMessage.text
            val map = Gson().fromJson(messageData, Map::class.java)
            response = "Hello " + map["name"]
        }
        return response
    }
}