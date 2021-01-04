# Desafio it Singular

projeto para testes automatizados em ambiente WEB criado em Java, Maven, TestNg, Selenium e Cucumber utilizando o padrão DriveFactory

## Instalação

Baixe ou clone o repositório

Instale a ultima versão do Eclipse

Com o Eclipse aberto, importe o projeto via Projeto Maven Existente.

## Selenium Sever

eu utilizei o Selenoid para executar o Server e o Grid do Selenium

[SELENOID](https://aerokube.com/selenoid/latest/)

porem é possível utilizar normalmente com o selenium server e grid padrão

[Grid 3](https://www.selenium.dev/documentation/en/grid/grid_3/)


## Como Utilizar

necessario instalar o plugin do Cucumber no Eclipse para poder executar o projeto de dentro do próprio Eclipse.
```bash
botão direito sobre o projeto > Run as > Maven Install
```
Caso queira executar direto, necessario ter instalado o Maven e configurar nas variáveis de ambiente do Windows, com o seu pront de comando navegar ate a pasta onde contem o POM do projeto e digitar o comando abaixo

```maven
mvn clean install
```

## Report

O projeto esta configurado para executar em paralelo, dentro do Pakage runnerFiles, no arquivo "RunTestNGTest.java" junto com maven-surefire-plugin configurado no POM do projeto

```jav
@DataProvider(parallel = true)
```

Após executar o projeto, será gerado dentro da pasta "target" do projeto um arquivo JSON para poder ser utilizado em ci/cd, e uma pasta chamada cucumber-html-report com o arquivo "index.html", dentro deste html terá o relatório de execução do projeto

## Author

Vinicius Marra Santos - QA Engenier
