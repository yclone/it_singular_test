package stepDefinitions.eComerce;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import runnerFiles.DriverFactory;
import suport.eComerce.Carrinho_sup;

public class Carrinho_stp {
	
	Carrinho_sup carrinho_sup;

	@Dado("que eu acesso o carinho")
	public void que_eu_acesso_o_carinho() {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.ClicaCarrinho();
	}

	@Quando("eu seleciono a opção de pagamento {string}")
	public void eu_seleciono_a_opção_de_pagamento(String string) {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.selOptPagamento(string);
	}
	
	@Quando("no campo numero do cartão eu digito {string}")
	public void no_campo_numero_do_cartão_eu_digito(String string) {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.digitaNumCard(string);
	}

	@Quando("no campo titular do cartão eu digito {string}")
	public void no_campo_titular_do_cartão_eu_digito(String string) {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.digitaTitular(string);
	}

	@Quando("no campo data de vencimento eu digito {string}")
	public void no_campo_data_de_vencimento_eu_digito(String string) {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.digitaDtVenc(string);
	}

	@Quando("no campo codigo de segurança eu digito {string}")
	public void no_campo_codigo_de_segurança_eu_digito(String string) {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.digitaCogSeg(string);
	}

	@Quando("clico em comprar")
	public void clico_em_comprar() {
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		carrinho_sup.clicaComprar();
	}

	@Entao("deve apresentar a mensagem {string}")
	public void deve_apresentar_a_mensagem(String string) {
		boolean retorno;
		carrinho_sup = new Carrinho_sup(DriverFactory.getDriver());
		retorno = carrinho_sup.validaResposta(string);
		assertEquals(retorno, true);
	}

}
