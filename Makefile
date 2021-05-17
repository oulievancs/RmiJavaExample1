# Author:	Oulis Evangelos
# Application:	RMI in JAVA
# Subject:	Distributed Systems
PORT = 7500
HOST = localhost

SERVERPACKAGE = RmiServer
CLIENTPACKAGE = RmiClient
SERVER = RmiServer
CLIENT = RmiClient

FLAG = -Xlint


all:
	javac $(SERVERPACKAGE)/*.java $(CLIENTPACKAGE)/*.java $(FLAG)
server:
	java $(SERVERPACKAGE).$(SERVER) $(PORT)
client:
	java $(CLIENTPACKAGE).$(CLIENT) $(HOST) $(PORT)
clean:
	rm $(SERVERPACKAGE)/*.class
	rm $(CLIENTPACKAGE)/*.class
