# DesafioCovid


## Instalação

É recomendando que você possua a última versão do MySQL no seu computador.

As tabelas no banco são criadas automaticamente, com exceção da tabela Status.

Foram utilizadas as as bibliotecas Lombok, JSon Web Token (JWT) e spring web security para fazer validação do usuário.

Configuração de banco e jwt.secret

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/atendimento?useTimezone=true&serverTimezone=UTC
spring.datasource.username= root
spring.datasource.password= Layton1984
jwt.secret=javamaster

## Uso

O processo inicia com a criação do usuário no endpoint register, e autenticação do usuário no endpoint auth
Após a validação o usuario pode criar a primeira triagem, que exigirá o preenchimento de todos os dados, com exceção dos atributos boolean, que são false por padrão.
Após registrar a triagem, o usuário deverá receber a tela de atendimento, com campos para preencher durante a estadia do usuário na unidade de atendimento médico.
O atendimento é considerado terminado, quando usuário define a data e hora de saída do paciente.
A partir dos atendimentos concluídos, o endpoint "estatisticas" mostrará o tempo máximo, mínimo e médio de cada atendimento em sua respectiva unidade de atendimento.
Juntamente com esses dados, estarão o número de atendimentos de Covid, definidos com a confirmação do exameDeBiologiaMolecular ou exameDeSorologia que são exigidos quando usuário apresenta sintomas comuns da covid.
