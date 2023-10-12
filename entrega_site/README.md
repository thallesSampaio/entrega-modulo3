<h1>Modelagem RJTRIP</h1>

<h3>Conceitual:</h3>

![conceitualRJTRIP](https://github.com/thallesSampaio/entrega-modulo3/assets/114416169/f5b42e0c-ee67-4412-811c-bfbd66ac406b)

<h3>Lógico:</h3>

![logicoRJTRIP](https://github.com/thallesSampaio/entrega-modulo3/assets/114416169/2501d4b2-c060-4884-80fa-cac389b4f44f)]

<h3>Fisico:</h3>
<p>
  create DATABASE RJTRIP;<br>
<br>
use RJTRIP;<br>
<br>
CREATE TABLE cliente (<br>
    cliente_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,<br>
    nomeCliente VARCHAR(100),<br>
    cpf VARCHAR(11) UNIQUE,<br>
    dataNascimento DATE,<br>
    email VARCHAR(100) UNIQUE,<br>
    senha VARCHAR(32),<br>
    endereco VARCHAR(200)<br>
);<br>
<br>
CREATE TABLE pacote (<br>
    pacote_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,<br>
    tipoPacote VARCHAR(50)<br>
);<br>
<br>
CREATE TABLE pedido (<br>
    pedido_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,<br>
    cli_id INT,<br>
    paco_id INT,<br>
    duracao INT,<br>
    dataViagem DATE,<br>
    destinosEscolhidos VARCHAR(150),<br>
    FOREIGN KEY(cli_id) REFERENCES cliente(cliente_id),<br>
    FOREIGN KEY(paco_id) REFERENCES pacote(pacote_id)<br>
);
</p>

<h3>UML:</h3>

![modelo UML](https://github.com/thallesSampaio/entrega-modulo3/assets/114416169/e4364e58-3f71-43e7-8353-dc214fadf02e)


