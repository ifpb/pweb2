# Especificação do Projeto

O projeto vai tratar de diversos aspectos do desenvolvimento de uma aplicação Web usando a arquitetura de microsserviços.

O objetivo do projeto é fornecer uma interface Web para o gerenciamento e visualização de horários do IFPB. Para tal, devem ser cumpridos os seguintes requisitos:

O deve fornecer uma interface restrita a coordenadores de cursos e membros da comissão de horários, que oferecerá acesso à todas as informações necessárias para a elaboração do horário, tais como dados de cursos, disciplinas, professores e ambientes.

Também deve ser fornecida uma interface de acesso aberto, no qual será possível visualizar o horário e realizar buscas pro professores, turmas e ambientes.

## Requisitos Mínimos
* Conter ao menos serviços de autenticação e gerenciamento de horários

## Arquitetura
A arquitetura do projeto completo será composta de pelo menos os seguintes componentes:
* API Gateway: contém as regras de roteamento, chamadas para serviço de autenticação, logging, composição de APIs, visões materializadas CQRS e implementação do padrão backends para frentes visando atender as interfaces públicas e restrita para o gerenciamento de horários.
* Servidor Eureka / Spring Cloud Config: concentra o registro de instâncias e configuração de todos os serviços
* Microsserviços de negócio: ao menos dois microsserviços responsáveis por fornecer acesso aos dados envolvidos no gerenciamento de horários
* Microserviço de autenticação: serviço que contém a base de horários, papéis e permissões para acesso aos serviços internos

## Divisão de grupos
A turma terá autonomia para se organiza em relação à distribuição de tarefas. No entanto, a cada um dos alunos deverá ser atribuído um papel principal pelo qual ele estará responsável, dentre os seguintes:
- 1) Líder técnico (SCRUM Master)
- 2) Arquiteto de Software
- 3) Dev backend
- 4) Dev frontend
- 5) Testes

Importante: a atribuição de papel não indica que o aluno deverá fazer apenas tarefas relacionadas ao seu perfil. Ele deverá participar das atividades do projeto como um todo, mas será o "responsável" por liderar a sua respectiva categoria junto aos demais membros.

## Processo
Deverá ser utilizado o processo SCRUM, com Springs de no máximo 2 semanas e reuniões diárias entre os membros.
O papel do PO (Product Owner) caberá ao professor (Diego)

## Primeiros passos
- Elaboração do Product Backlog
- Elaboração do Plano de Releases
- Elaboração do projeto arquitetural de software

* Prazo máximo de entrega dos primeiros passos: 08/03

* As demais entregas serão realizadas conforme a elaboração do plano de releases.
