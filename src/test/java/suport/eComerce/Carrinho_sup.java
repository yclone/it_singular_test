package suport.eComerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.Actions;

public class Carrinho_sup {
	
	private WebDriver driver;
	Actions action;

	@FindBy(id = "debito")
	private WebElement debito;

	@FindBy(id = "creditovista")
	private WebElement creditovista;
	
	@FindBy(id = "creditoparcelado")
	private WebElement creditoparcelado;

	@FindBy(id = "creditoparcelado")
	private WebElement creditoparceladoParcela;

	@FindBy(name = "numero")
	private WebElement numero;
	
	@FindBy(name = "titularCartao")
	private WebElement titularCartao;
	
	@FindBy(name = "dataVencimento")
	private WebElement dataVencimento;
	
	@FindBy(name = "codSeguranca")
	private WebElement codSeguranca;
	
	@FindBy(linkText = "Finalizar compra")
	private WebElement Finalizar_compra;
	
	@FindBy(css = ".mensagemSucesso")
	private WebElement mensagemSucesso;


	public Carrinho_sup(WebDriver driver) {
		super();
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public Carrinho_sup ClicaCarrinho() {

		return new Carrinho_sup(driver);
	}

	public Carrinho_sup selOptPagamento(String string) {
		if (string.equals("debito")) {
			action.clicar(debito);
		} else if (string.equals("credito")) {
			action.clicar(creditoparcelado);
		} 
		return new Carrinho_sup(driver);
	}
	
	public Carrinho_sup digitaNumCard(String string) {
		String[] numEParcela = string.split(",");
		if (numEParcela.length > 1) {
			action.digitar(numero, numEParcela[0]);
			action.digitar(creditoparceladoParcela, numEParcela[1]);
		} else {
			action.digitar(numero, numEParcela[0]);
			action.digitar(creditoparceladoParcela, "A vista");
		}
		return new Carrinho_sup(driver);
	}

	public Carrinho_sup digitaTitular(String string) {
		action.digitar(titularCartao, string);
		return new Carrinho_sup(driver);
	}

	public Carrinho_sup digitaDtVenc(String string) {
		action.digitar(dataVencimento, string);
		return new Carrinho_sup(driver);
	}

	public Carrinho_sup digitaCogSeg(String string) {
		action.digitar(codSeguranca, string);
		return new Carrinho_sup(driver);
	}

	public Carrinho_sup clicaComprar() {
		action.clicar(Finalizar_compra);
		return new Carrinho_sup(driver);
	}

	public boolean validaResposta(String mensagem) {
		return action.validaResp(mensagemSucesso, mensagem);
	}

	

}
