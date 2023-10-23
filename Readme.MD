# PosTech - Spring 
<hr>
- Projeto SpringBoot inicializado pelo spring initializr;<br>
- Adicionada dependência do Spring Web, Spring Data JPA e H2 Database;<br>
- Versão do java: 17;
<hr>

<h3>Aula 1</h3>
-Montagem do ambiente por meio do application.properties<br>
-Montagem da entidade produto<br>
-Montagem do repository (Spring Data Jpa) para produto<br>
-Montagem da sevice de produto<br>
-Inversão de controle<br>
-Injeção de dependência<br>
-Montagem da Controller de produto<br>
-Montagem de uma exception - ControllerNotFoundException<br>
-Montagem de um StandardError (apresentação mais bonita de erro para o client)<br>
-Montagem de um Handler - ControllerExceptionHandler 
(classe que captura o erro na Controller - intercepta e joga o nosso StandardError)
-CRUD de Produto

<h3>Aula 2</h3>
<b>-Arquitetura em camadas (layered architecture):</b>
Um dos estilos mais comuns. A ideia por trás da Arquitetura em Camadas é que módulos 
ou componentes com funcionalidades semelhantes sejam organizados em camadas horizontais. 
Como resultado, cada camada desempenha uma função específica na aplicação.<br>
<b>-Padrão DTO (Data Transfer Object):</b> O padrão DTO é usado para transferir dados entre 
camadas de um aplicativo. Ao construir APIs, é importante evitar que dados maliciosos ou 
indesejados fluam livremente entre as camadas. Com o uso de DTOs, você pode controlar quais 
dados são transferidos e como eles são formatados, tornando seu aplicativo mais seguro.<br>
