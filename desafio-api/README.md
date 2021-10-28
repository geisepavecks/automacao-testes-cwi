## DESAFIO API - CWI RESET

### Introdução

Trata-se de uma prática de testes que simula a manipulação de um sistema interno de reservas em um hotel.

Nessa prática foram utilizados 15 testes ao total, dentro de quatro *Suites*: 

- **HealthCheck** - teste simples para confirmar se a API está rodando como o esperado.
- **Schema** - teste para garantir que a estrutura da *response* está de acordo.
- **Acceptance** - para testar os cenários de exceção.
- **E2e** - para validar o fluxo como um todo, percorrendo toda a API e valida as interdependências também.

### Considerações

Houveram alguns impasses na elaboração e execução do teste de **Acceptance**, como o objetivo era ser desafiador, também foi proposto pela equipe da CWI, testar erros que foram colocados propositalmente pelos avaliadores para que fossem analisados, porém sem efetivo intuito de resolução, apenas testar falhas e avaliar com criticidade o ocorrido. Antecipo que estes erros estão comentados no código, mas para ampla visão, os deixarei neste meu relatório crítico, também.

- #### "Teste de Exclusão de uma Reserva por ID" - DeleteBookingTest

  O teste guarda em uma variável um ID aleatório de uma reserva através do método `getABookingId()`, da classe utilitária `Utils`. Depois, passa esse mesmo ID para o método `deleteBooking()`, que deleta a reserva. Como a API tem uma resposta com status code incoerente para o método DELETE, pois o status code retornado é 201 e no body contém a string "Created", o teste espera isso apenas para conseguir realizar o teste da exclusão em si. Logo depois disso, é feita uma requisição GET através do método `getBookingById()` da classe `GetBookingRequest`, passando o mesmo ID usado para exclusão. O status code retornado é 404 (not found) como o esperado, assim validando a função de exclusão de registro, mesmo que o status code de retorno 201 não esteja de acordo (por ser implantado propositalmente) e com isso o teste "falhe", o foco de exclusão de registro acontece, portanto, o objetivo é atingido nesse teste.

- #### "Listar IDs de reservas utilizando o filtro name, checkin and checkout date" - GetBookingTest

  Os filtros checkin e checkout, quando **usados em conjunto**, apresentam duas limitações. A primeira, sobre o checkin, é que ele apenas funciona caso o dia esteja ausente. E a segunda, sobre o checkout, é que ele apenas funciona caso a data esteja completa.

### Cenários cobertos pelos testes

**Suite Healthcheck:**

- /HEALTHCHECK
  - Verificar se API está online

**Suite Schema :**

- /GET
  - Garantir o schema do retorno da lista de reservas
  - Garantir o schema do retorno de uma reserva específica

**Suite Acceptance:**

- /*DELETE*
  - Excluir um reserva com sucesso
- /*GET*
  - Listar IDs das reservas
  - Listar uma reserva específica
  - Listar IDs de reservas utilizando o filtro firstname
  - Listar IDs de reservas utilizando o filtro lastname
  - Listar IDs de reservas utilizando o filtro checkin
  - Listar IDs de reservas utilizando o filtro checkout
  - Listar IDs de reservas utilizando o filtro checkin e checkout
  - Listar IDs de reservas utilizando o filtro name, checkin e checkout date
- /*POST*
  - Criar uma nova reserva
- /*PUT*
  - Alterar uma reserva usando o token
  - Alterar uma reserva usando o Basic auth

**Suite E2e :**

- /*DELETE*
  - Tentar excluir uma reserva que não existe
  - Tentar excluir uma reserva sem autorização
- /*GET*
  - Visualizar erro de servidor 500 quando enviar filtro mal formatado
- /*POST*
  - Validar retorno 500 quando o payload da reserva estiver inválido
  - Validar a criação de mais de uma reserva em sequencia
  - Criar uma reserva enviando mais parâmetros no payload da reserva
  - Validar retorno 418 quando o header Accept for invalido
- /*PUT*
  - Tentar alterar uma reserva quando o token não for enviado
  - Tentar alterar uma reserva quando o token enviado for inválido
  - Tentar alterar uma reserva que não existe



