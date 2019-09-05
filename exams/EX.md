# Exercício de Revisão Teórica para a avaliação

O Sistema de planejamento acadêmico Chronos foi desenvolvido pelo CEFET-MG e possui como principal objetivo agilizar a confecção de planos de aula e planos de curso.

Sobre a implementação, o Chronos é um sistema monolítico construído em EJB e que roda implantado no servidor de aplicações Glassfish.

Os detalhes do projeto Chronos podem ser encontrados neste artigo:
http://www.digddv.cefetmg.br/wp-content/uploads/sites/52/2017/11/Chronos-v16.pdf

## Atividades

1) Considerando o diagrama de classes do sistema Chronos (Figura 3 do artigo), construa um novo diagrama de classes em UML que aplique os padrões definidos no modelo Domain Driven Design (DDD), identificando o escopo de cada conjunto de classes (bounded-context) e agrupando as entidades em agregados e identificando suas entidades raízes (aggregate root).

2) Suponha que você foi contratado para decompor o sistema monolítico Chronos em uma arquitetura de microsserviços. Defina uma estratégia de decomposição com base no diagrama de classes construído na questão anterior e nas especificidades do ambiente de utilização do Chronos (observar os detalhes descritos no artigo). Para tal, crie um diagrama arquitetural identificando os serviços e componentes que farão parte dessa arquitetura. Lembre-se de especificar cada banco de dados utilizado, como também a comunicação entre os serviços e demais artefatos que possam ser utilizados para dar suporte à arquitetura, tais como entrega de mensagens, registro de serviços, centralização de configuração, etc.  
