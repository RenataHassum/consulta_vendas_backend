### Renata Hassum - [Linkedin](https://www.linkedin.com/in/renataviottohassumdev) | renatahassum@gmail.com

# Sobre o projeto Consulta de vendas e envio de SMS [![NPM](https://img.shields.io/npm/l/react)](https://github.com/RenataHassum/consulta_vendas_backend/blob/main/LICENSE) 

O Projeto Consulta Vendas com Envio de SMS é um projeto backend desenvolvido com Spring Boot, que permite ao usuário informar datas específicas para consultar vendas e retorna um relatório paginado com informações como, ID da venda, data da transação, quantia vendida e nome do vendedor associado.

Além disso, realiza o envio de SMS contendo o ID do vendedor. Projeto proposto pela instituição de ensino <a href="https://devsuperior.com.br/cursos"><img align="center" height="16" alt="DevSuperior" src="https://devsuperior.com.br/_next/static/images/logo-white-10059e26f600604a7b5bd7782ed7550c.svg"></a>

# Teste as requisições no Postman Collection
#### Siga o passo a passo:
1) Faça o clone do projeto
```bash
# Pré-requisitos: Java 17 / Necessário uma conta na Twillio para configurar variáveis de ambiente
# clonar repositório
git clone git@github.com:RenataHassum/consulta_vendas_backend.git

# entrar na pasta do projeto back end
cd consulta_vendas_backend
cd backend

# executar o projeto
./mvnw spring-boot:run
```
2) Clique no botão "Run in Postman"
3) Acesse a opção "View collection"
4) Teste as requisições conforme orientações abaixo
   
      [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/22138191-6c1439be-da01-42b9-9d2f-9dcbefe5770c?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D22138191-6c1439be-da01-42b9-9d2f-9dcbefe5770c%26entityType%3Dcollection%26workspaceId%3Da98ebf5e-88b7-4670-8786-714d2be631fd)

#### Não é necessário realizar a configuração de ambiente do projeto

## Venda endpoints
`GET by ID`
- Permite obter informações sobre uma venda específica com base no ID da venda
- Os dados retornados incluem o ID da venda, a quantidade vendida e a data da transação

## Relatório de Vendas endpoints
`GET Report`
- Permite retornar uma listagem paginada com as vendas que se enquadram nos critérios informados opcionalmente
  - Data inicial (opcional): Se não informada, será considerada a data de um ano antes da data final
  - Data final (opcional): Se não informada, será considerada a data atual do sistema
  - Trecho do nome do vendedor (opcional): Se não informado, será considerado o texto vazio

## Sumário de Vendas por Vendedor endpoints
`GET Summary`
- Permite retornar uma listagem com o nome do vendedor e a soma das vendas realizadas por esse vendedor no período especificado opcionalmente
  - Data inicial (opcional): Se não informada, será considerada a data de um ano antes da data final
  - Data final (opcional): Se não informada, será considerada a data atual do sistema
  - Trecho do nome do vendedor (opcional): Se não informado, será considerado o texto vazio

## Envio de SMS endpoints - o projeto utiliza o serviço Twilio de forma gratuita
`GET Notification Sms`
- Devido à configuração gratuita, não é possível personalizar o número de telefone do remetente para receber as mensagens de SMS dos vendedores
- Ao realizar a requisição, se o sistema retornar o código "200" como resultado, isso indica que a operação foi concluída com sucesso e está funcionando corretamente

# Tecnologias | Implantação em produção
- Java, Spring Boot, API REST, JPA, Hibernate, Maven, H2 Database, PostgreSQL, ORM, Git
- Implantação Backend: Até o presente momento, o projeto não conta com a implementação no backend em uma plataforma de hospedagem
- Implantação banco de dados: Postgresql

# Técnicas | Competências
- Programação Orientada a Objetos (POO) e Seed de Banco de Dados: Permite o desenvolvimento eficiente de um sistema orientado a objetos e a criação de um modelo conceitual representando entidades e relacionamentos.
- Arquitetura em Camadas: Utiliza uma estrutura organizada em camadas, proporcionando separação clara de responsabilidades e facilitando a manutenibilidade do sistema.
- Web Services RESTful: Implementa web services RESTful, seguindo o padrão DTO para transferência de dados.
- Paginação de Dados: Implementa técnicas de paginação para otimizar o desempenho e viabilizar a navegação eficiente em conjuntos de dados extensos.
- Consultas ao Banco de Dados com JPQL: Realiza consultas ao banco de dados utilizando a linguagem de consulta JPQL.

## Figma
https://www.figma.com/file/Yu2RHFmirHQ4BIVZM2XxY6/DSMeta2?type=design&node-id=0-1&t=2R8F5CDjriNMbizs-0

## Modelo conceitual
![Modelo Conceitual](https://github.com/RenataHassum/assets/blob/main/consulta_vendas_assets/modelo_conceitual.jpg?raw=true)

## Padrão camadas
![Padrão camadas](https://github.com/RenataHassum/assets/blob/main/padrao_camadas.jpg?raw=true)

# Agradecimentos
<a href="https://devsuperior.com.br/cursos"><img align="center" height="16" alt="DevSuperior" src="https://devsuperior.com.br/_next/static/images/logo-white-10059e26f600604a7b5bd7782ed7550c.svg"></a> - Professor Nélio Alves

# Autora
### Renata Hassum - [Linkedin](https://www.linkedin.com/in/renataviottohassumdev) | renatahassum@gmail.com
Fico à disposição para qualquer esclarecimento, não hesite em me contatar
