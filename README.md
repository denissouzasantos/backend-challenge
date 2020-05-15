# backend-challenge
# Api para validar Senha

Para executar o projeto, pode seguir os passos seguintes

1. Installar ou ter instalado o Java na versão Java 8 ou superior, configurar a variavel de ambiente JAVA_HOME.
2. Installar ou ter instalado o maven na versão 3.6.0, configurar a variavel de ambiente M2_HOME.
3. Executar o seguinte comando mvn clean install
4  Executar o seguinte comando java -jar target/itau-0.0.1-SNAPSHOT.jar

Linguagem escolhida para o desenvolvimento da aplicação foi Java na versão 8, Java é uma linguagem orientada a objeto fortimente tipada, além de ofereceer uma vasta variedade de recursos.

Escolhi utilizar o Spring Boot, para criar a aplicação assim as configurações basicas no pom.xml já vem preenchidas assim como as depênncias que posso selecionar, como por exemplo Spring Web, para expor minhas API, para partte de segurança da API utilizei o Spring Security, passando um usuario e senha para a autenticação e acesso ao serviço, o motivo pelo qual escolhi o framework Spring, foi pelo recurso de injeção de dependências e inversão de controle, deixando a responsabilidade do framework gerencia e me entrega um objeto quando eu preciso utilizar.

