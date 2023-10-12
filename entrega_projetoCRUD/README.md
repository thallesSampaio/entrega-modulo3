<h1>Projeto console agencia de viagens.</h1>
<h3>Feito com Java, JDBC e MySQL. Aplicado o CRUD em todas as tabelas.</h3><br><br>
<h1>Modelagem de dados</h1>
<h3>Conceitual:</h3>

![ConceitualCrud](https://github.com/thallesSampaio/entrega-modulo3/assets/114416169/6db97a9e-5c4f-454c-9939-9aa2112738c0)

<h3>Lógico:</h3>

![LogicoCrud](https://github.com/thallesSampaio/entrega-modulo3/assets/114416169/e368d0a1-af42-4b01-9b17-16f84f78635d)

<h3>Fisico/comandos SQL:</h3>
<p>create DATABASE agenciaViagens;<br>

use agenciaViagens;<br>
<br>
CREATE TABLE cliente (<br>
  cliente_id INT  NOT NULL AUTO_INCREMENT,<br>
  nome varchar(100) NOT NULL,<br>
  cpf varchar(11) NOT NULL UNIQUE,<br>
  PRIMARY KEY (cliente_id)<br>
);<br>
<br>
CREATE TABLE destinos (<br>
  destino_id int(11) NOT NULL AUTO_INCREMENT,<br>
  pais varchar(100) NOT NULL,<br>
  cidade varchar(100) NOT NULL UNIQUE,<br>
  PRIMARY KEY (destino_id)<br>
);<br>
<br>
CREATE TABLE pedidos (<br>
  pedido_id int(11) NOT NULL AUTO_INCREMENT,<br>
  cli_id int(11) NOT NULL,<br>
  dest_id int(11) NOT NULL,<br>
  dataViagem date DEFAULT NULL,<br>
  PRIMARY KEY (pedido_id),<br>
  CONSTRAINT pedidos_ibfk_1 FOREIGN KEY (cli_id) REFERENCES cliente (cliente_id),<br>
  CONSTRAINT pedidos_ibfk_2 FOREIGN KEY (dest_id) REFERENCES destinos (destino_id)<br>
);
</p>

<h3>UML:</h3>

![UmlCrud](https://github.com/thallesSampaio/entrega-modulo3/assets/114416169/1f926e82-84e2-446d-93a0-e3daa56ee09d)

