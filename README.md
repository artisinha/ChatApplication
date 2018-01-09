Chat Application 
===================
Chat Application in Spring boot and HTML/CS/JS.

----------


1.Introduction
-------------
This  **Chat application** contains two basic parts:

 - Backend(Spring boot)  
 -   Front-end(HTML,jquery)



**1.1.Frontend**
A simple HTML ,CSS,Bootstrap application.

 - Prerequest
---------
Technology used:
**Spring boot,html,css,js**

 - Installation Steps:
---------
*3.1* Adding a new application
Adding a new application through spring initializer:
https://start.spring.io/

*3.2* Adding external libraries:
Two external libraries are added:

 - stockjs
 -  stompjs

*3.3* Adding js in an application:

 - sockjs:https://github.com/sockjs/sockjs-client/blob/master/dist/sockjs.min.js

 - stompjs:https://github.com/jmesnil/stomp-websocket/blob/master/lib/stomp.min.js
 - These are added in application after downloading.

*3.4* Important points added in Chat Application:

**Websocket**: Websocket is a communication protocol that makes it possible to establish a two-way communication channel between a server and a client.

**EnableWebSocketMessageBroker**: It is used to enable our WebSocket server.

**SockJS**: It is used to enable fallback options for browsers that don’t support websocket.

 **STOMP**:STOMP stands for Simple Text Oriented Messaging Protocol. It is a messaging protocol that defines the format and rules for data exchange.

In model of Application:The enum used are
 - CHAT
 -  JOIN 
 - LEAVE

**WebsocketEventListener**: Using event listeners to listen for socket connect and disconnect events so that we can log these events and also broadcast them when a user joins or leaves the chat room .
We’re already broadcasting user join event in the **addUser()** method defined inside **ChatController**. So, we don’t need to do anything in the SessionConnected event.

**For Frontend:**
Adding frontend files in the following path: src/main/resources
**static**
	 ***css***
		   main.css 	
   		js			 
   	
 - main.js
 - sockjs.min.js 
 - stompjs.min.js

   	 *index.html*
   	 
 **How to start application**

 - Run the server in eclipse to run Spring boot Application.
 - Open a browser (chrome preferably)
 - Go to the link :  http://localhost:8080
 - When the link open it will show the page:
![enter image description here](https://lh3.googleusercontent.com/--N7CcHi1vXE/WlRQNGfas0I/AAAAAAAAClg/lZn7kWBrIcsKasCJO6vduZzovosP4M5CACLcBGAs/s0/img.png "img.png")

 - Then enter the username and start chatting.
 - New page will open which first show user connecting.....then joined.
![enter image description here](https://lh3.googleusercontent.com/-dOMUbYh8eRM/WlRRAjGszLI/AAAAAAAACls/bG1973F2dQ4TNFmZCuTmZcCiRXjsmKobQCLcBGAs/s0/img1.png "img1.png")


Once connected then start chatting i.e typing the required statements and then enter or send.Two add another user we have to add localhost in another/new tab.

![enter image description here](https://lh3.googleusercontent.com/-pn9QDDNWN6g/WlRUeMn6naI/AAAAAAAACmA/kmKqvWPEAVwwke62fubVf9a9fVuI_KTBQCLcBGAs/s0/img2.png "img2.png")

And if someone left the page will show:
![enter image description here](https://lh3.googleusercontent.com/-M3HqL38q9zc/WlRVQFMN7NI/AAAAAAAACmQ/6ey_L2rZcGk0IKR4AGLO3mX6ItQuEiU8wCLcBGAs/s0/img3.png "img3.png")

**The steps how the application is running :**
1.Opening the Websocket.
2.Web socket opened.
3.Connect
4.Connected.
5.Connected to server.
6.Subscribe:i.e with id and destination to start chat
7.Send:sender:'*username*' and type:'*JOIN*.'
8.Message:here,type:*'CHAT*',sender:'*username*',content:'*message* *typed*'
9.If someone left then:type:'*LEAVE*',content:'*null*',sender:'*username*'.
10.To leave the chat simply close the tab.



