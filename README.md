# Simple Chat

The SimpleChatServer listens on a specified port for client connections. Once a client connects, it reads and displays the messages sent by the client. The server stops when the client sends "/quit" or disconnects.

The SimpleChatClient connects to the server using a specified IP address and port. It allows the user to input messages from the console, which are then sent to the server. The client stops when the user inputs "/quit".

Project made during the Academia de Código bootcamp between May -> Aug 2023. www.academiadecodigo.org
<p></p>
<p></p>
Linux and macOS

nc -p <source_port> localhost 8000
<p></p>
<p></p>
Windows (https://nmap.org/)

ncat -p <source_port> localhost 8000

<source_port>: The port number you want to use as the source port for the connection.


