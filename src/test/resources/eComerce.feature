#language:pt
#Author: Vinicius Marra Santos

@FormaDePagamento
Funcionalidade: testes relacionados a forma de pagamento

	@forma_de_pagamento @Chrome
	Esquema do Cenario: testes relacionados a forma de pagamento
    Dado que eu acesso o carinho
    Quando eu seleciono a opção de pagamento "VOpt"
    E no campo numero do cartão eu digito "vNumCard"
    E no campo titular do cartão eu digito "vTitlular"
    E no campo data de vencimento eu digito "vDataVenc"
    E no campo codigo de segurança eu digito "vCodSeg"
    E clico em comprar
    Entao deve apresentar a mensagem "<Msg>"
    
  Exemplos:
  |Cenario																				|VOpt			|vNumCard								|vTitlular		 |vDataVenc		|vCodSeg	|Msg																		|
  |debito	OK																			|debito		|5296 4733 6459 5117		|João da Silva |04/06/2021	|		 			|Seu pedido foi realizado com sucesso.	|
  |credito OK																			|credito 	|5135 7941 5799 4836		|João da Silva |04/06/2021	|237 			|Seu pedido foi realizado com sucesso.	|
  |credito parcelado OK														|credito	|5135 7941 5799 4836, 5	|João da Silva |04/06/2021	|237 			|Seu pedido foi realizado com sucesso.	|
  |debito	sem preencher campos										|debito		|												|							 |						|		 			|preencha os campos obrigatorios				|
  |debito sem numero e data												|debito 	|												|João da Silva |						|237 			|preencha os campos obrigatorios				|
  |debito sem titular e codigo										|debito 	|5296 4733 6459 5117		|				 			 |04/06/2021	|		 			|preencha os campos obrigatorios				|
  |credito sem numero e data											|credito 	|												|João da Silva |						|237 			|preencha os campos obrigatorios				|
  |credito sem titular e codigo										|credito 	|5135 7941 5799 4836		|				 			 |04/06/2021	|		 			|preencha os campos obrigatorios				|
  |credito parcelado sem preencher campos					|credito	|												|							 |						|					|preencha os campos obrigatorios				|
  |credito parcelado sem informar parcela					|credito	|5135 7941 5799 4836		|João da Silva |04/06/2021	|237 			|Seu pedido foi realizado com sucesso.	| 
  |credito parcelado sem informar vencimento			|credito 	|5135 7941 5799 4836, 4	|João da Silva |						|237 			|Seu pedido foi realizado com sucesso.	|     
	|credito parcelado sem informar codigo					|credito 	|5135 7941 5799 4836, 2	|João da Silva |04/06/2021	|		 			|Seu pedido foi realizado com sucesso.	|    
          
           