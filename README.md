# RabbitMQ & SpringBoot

### This is a *Spring Boot* application that shows the use of queues. 


# Set-up

- Install Docker for Windows: and let the installer do the rest 

- Open Powershell and type:
``docker --version`` 

- If successfully installed, you will see the version of docker you have just installed

Now we have to download the RabbitMQ image. 
``docker pull rabbitmq:3-management`` 

Then start the RabbitMQ Docker image with a simple command:

``docker run -d -p 15672:15672 -p 5672:5672 --name rabbit-test-for-medium rabbitmq:3-management``

Test the image by opening “http://localhost:15672” in your browser.


# Get running.. 
Open your browser and paste this url:  "http://localhost:8080/api/publish?message=Hello" 

Or go to postman and make a Get request with a Param message and pass the message you want to publish to the queue