# Programa para estudo da Arquitetura Hexagonal

Este é um exemplo de programa simples que utiliza a arquitetura hexagonal para separar as responsabilidades e facilitar a manutenção e testabilidade do código. O programa é desenvolvido em Java 17, utilizando o framework Spring e o banco de dados H2.

## Requisitos

- Java 17
- IntelliJ IDEA (ou qualquer outra IDE de sua preferência)
- Maven

## Configuração

1. Clone o repositório para a sua máquina local.
2. Abra o projeto no IntelliJ IDEA (ou na sua IDE de preferência).
3. Certifique-se de que o Java 17 está configurado corretamente no projeto.

## Estrutura do Projeto

O projeto segue a estrutura básica da arquitetura hexagonal, com as seguintes camadas:

- **Application**: contém as classes responsáveis pela comunicação com o mundo externo.
- **Domain**: contém as classes que representam o domínio da aplicação e suas regras de negócio.
- **Ports**: contém as interfaces que representam os contratos do sistema, ou seja, as operações que podem ser realizadas. Essas interfaces são independentes de qualquer tecnologia ou implementação específica.
- **Adapters**: contém as implementações concretas das interfaces definidas na camada de ports. Essas implementações são responsáveis por se comunicar com o mundo externo, como banco de dados, serviços externos, interfaces de usuário, etc.

## Executando o Programa

1. Execute a classe `Application` para iniciar o programa.
2. O programa irá iniciar um servidor embutido do Spring e estará disponível na porta `8080`.
3. Você pode utilizar um cliente REST (ex: Postman) para enviar requisições para a API.

## Banco de Dados H2

O programa utiliza o banco de dados H2 para armazenar os dados. O H2 é um banco de dados em memória, o que significa que os dados são perdidos quando o programa é encerrado. No entanto, você pode modificar as configurações do banco de dados para utilizar um banco de dados persistente.

- URL do Banco de Dados: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (vazio)