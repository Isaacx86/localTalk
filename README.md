# localTalk
A Local implementation of java library functions to create a serverside and clientside application which will communicate over TCP using given port and ip address.

An example below is a local wireshark(Packet and Traffic capture tool) Which shows the defined ip address and port communicating on a local network. This is shown by the SYN, SYN,ACK and ACK TCP Headers.
![image](https://user-images.githubusercontent.com/79987239/153721130-9476ed7d-60f6-4373-b7d8-54df750c1d21.png)


However, this is just an example of how a very simple serverside, clientside communication can work over TCP/IP, this should not be used in any secure application.
An example below shows the same transfer of a piece of secretive data to the serverside, and how insecure the transfer realy is 

As you can see the data transfer is succesful and the serverside can see the message sent by the clientside
![image](https://user-images.githubusercontent.com/79987239/153721198-fa6dcde4-503e-49e6-88c8-6559e32c7e58.png)

However, on our traffic capture tool wireshark we can see, the unencrypted clear text secret password that we sent!.
![image](https://user-images.githubusercontent.com/79987239/153721232-be35e4da-0f12-4491-ad12-aa6bb08b9014.png)
