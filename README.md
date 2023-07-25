# publisorder
Aplicação usando graphql e rabbitmq

# Executando aplicação
- Java 17
- Docker

É preciso ter a imagem do rabbitmq sendo utilizada. A imagem utilizada foi a rabbitmq:3.10.5-management.

Na hora de subir o contaier, o comando: docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.10.5-management
para poder subir o rabbitmq e disponibilizar a porta 15672 na qual a aplicação enviará as mensagens.
