# website-admin
Área administrativa de um website

## Banco de dados
Script para criação de usuário e banco de dados da aplicação:

```sql
-- Criação do usuário
CREATE ROLE websiteadmin LOGIN PASSWORD 'websiteadmin';

CREATE DATABASE websiteadmindb OWNER websiteadmin;
```
