package com.aididi.ServerController;

import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.ServerEndpoint;

/**
 * @author xuzexiang
 * @Date: 2018-10-16 0016
 * @Description:    聊天室
 */
@RestController
@ServerEndpoint("/socket/{username}")
public class WebSocketServerEndPoint {

}
