# Terceira-colaborativa-padroes

Repositório da terceira atividade colaborativa da disciplina de Padrões de Projeto de Software do quinto período de Sistemas para Internet (IFPB).

## Padrões de Projeto Utilizados

### 1. Command

#### Justificativa
O padrão Command foi utilizado para encapsular todas as operações que o elevador pode realizar, como subir, descer, abrir porta, fechar porta e chamar elevador. Isso permite que as solicitações sejam parametrizadas e tratadas de forma uniforme, facilitando a implementação de funcionalidades como desfazer operações e registrar logs de ações.

### 2. Singleton

#### Justificativa
O padrão Singleton foi utilizado para garantir que exista apenas uma instância do elevador durante a execução do programa. Isso é importante para manter o estado consistente do elevador e evitar conflitos de estado.

### 3. State

#### Justificativa
O padrão State foi utilizado para gerenciar os diferentes estados do elevador, como parado, subindo e descendo. Isso permite que o comportamento do elevador mude dinamicamente conforme seu estado atual, facilitando a manutenção e a extensão do código.

## Conclusão

A utilização dos padrões de projeto Command, Singleton e State permitiu a criação de um sistema de controle de elevador modular, flexível e fácil de manter. Cada padrão foi escolhido para resolver problemas específicos e melhorar a qualidade do código.