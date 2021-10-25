package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Feature("Testes site de Ecommerce")
public class SetupTest extends BaseTests{

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("index.php"));
        System.out.print("Abrimos o navegador e carregamos a url!");
    }


    @Test
    @Story("Fazer cadastro no site")
    public void testCreateAnAccount() throws InterruptedException {
        //1º Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage loginPage = new LoginPage();
        AccountCreationPage createAccount = new AccountCreationPage();

        //2º Clicar em "Sign in" no site
        home.clickBtnLogin();
        System.out.println("Clicou em Sign In e direcionou para a página de Authentication");

        //3º Verificação se ao clicar no botão "Sign In" da Home, ocorreu o direcionamento para a página de Cadastro
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        //4º No "CREATE AN ACCOUNT" preencher o Email address | clicar em create an account | validar página
        loginPage.fillNewAccEmail();
        System.out.println("Preencheu o email");
        loginPage.clickCreateAccountButton();
        System.out.println("Clicou em Create an account");

        // ~ Garantir que vai dar tempo de trocar de página ~
        Thread.sleep(5000);
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account#account-creation")));
        System.out.println("Validou a url da minha página de create an account");

        //5º Preencher informações no YOUR PERSONAL INFORMATION
        createAccount.selectTitle();
        System.out.println("Escolheu title");
        createAccount.fillFirstName("Geise");
        System.out.println("Preencheu first name");
        createAccount.fillLastName("Paveck");
        System.out.println("Preencheu last name");
        createAccount.fillPassword("teste01");
        System.out.println("Preencheu password");
        createAccount.selectDayOfBirth();
        System.out.println("Escolheu day of birth");
        createAccount.selectMontOfBirth();
        System.out.println("Escolheu month of birth");
        createAccount.selectYearOfBirth();
        System.out.println("Escolheu year of birth");

        //6º Preencher informações no YOUR ADDRESS
        createAccount.fillAddressCompany("CWI");
        System.out.println("Preencheu company");
        createAccount.fillAddress("Rua Teste, Bairro Teste, número 123.");
        System.out.println("Preencheu address");
        createAccount.fillAddressLineTwo("Apto 404");
        System.out.println("Preencheu address (line 2)");
        createAccount.selectCountry();
        System.out.println("Escolheu country");
        createAccount.selectState();
        System.out.println("Escolheu state");
        createAccount.fillCity("Miami");
        System.out.println("Preencheu city");
        createAccount.fillZip("00001");
        System.out.println("Preencheu zip postal code");
        createAccount.fillMobilePhone("123456789");
        System.out.println("Preencheu mobile phone");

        //7º clicar em Register
        createAccount.clickBtnSubmitRegister();
        System.out.println("Clicou em Register");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("my-account"));
        System.out.println("Validou a url da minha página de my account");
    }

     @Test
     @Story ("Fazer login no site")
        public void testLogin() {
            //1º Iniciar as páginas
            HomePage home = new HomePage();
            LoginPage login = new LoginPage();

            //2º Clicar no botão login da home:
            home.clickBtnLogin();
            System.out.println("Clicou em Sign In e direcionou para a página de login");

            //3º Verificação se ao clicar no botão Login da Home, ocorreu o direcionamento para a página de Login
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
            login.fillEmail();
            System.out.println("Preencheu o email");
            login.fillPasswd();
            System.out.println("Preencheu a senha");
            login.clickBtnSubmitLogin();
            System.out.println("Clicou em Sign In");
            assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
            System.out.println("Validou a url da minha conta");
            assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
            System.out.println("Validou a minha conta do site");
     }

    @Test
    @Story("Realizar compra de um vestido")
    public void testAcessCategoryDresses() throws InterruptedException{
        //1º Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        MyAccountPage myAccount = new MyAccountPage();
        DressesPage dresses = new DressesPage();
        OrderPage order = new OrderPage();

        //2º Clicar no botão login da home:
        home.clickBtnLogin();
        System.out.println("Clicou em Sign In e direcionou para a página de login");

        //3º Verificação se ao clicar no botão Login da Home, ocorreu o direcionamento para a página de Login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        login.fillEmail();
        System.out.println("Preencheu o email");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a url da minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou a minha conta do site");

        //Clicar na categoria Dresses
        myAccount.clickDressesLink();
        System.out.println("Clicou no dresses");

        dresses.clickChiffonDressAddToCartButton();
        System.out.println("Clicou no botão Add to Cart do Chiffon Dress");
        dresses.clickCheckoutButton();
        System.out.println("Clicou no Proceed to checkout");

        order.clickProceedButton();
        System.out.println("Clicou no Proceed to checkout 2");
        order.clickSubmitButton();
        System.out.println("Clicou no Proceed to checkout 3");
        order.clickAgreeInput();
        System.out.println("Clicou no input de agreement");
        order.clickProcessCarrierButton();
        System.out.println("Clicou no Proceed to checkout 4");
        order.clickPayByBankWireLink();
        System.out.println("Clicou no Pay by bank wire");
        order.clickConfirmButton();
        System.out.println("Clicou no I confirm my order");

        Thread.sleep(5000);
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("order-confirmation"));
    }

//    @Test
//    @Story("Realizar o login")
//    public void testLogin(){
//
//        //Iniciar as páginas
//        HomePage home = new HomePage();
//        LoginPage login = new LoginPage();
//
//        //Clicar no botão login da home:
//        home.clickBtnLogin();
//        System.out.println("Clicou em Sign In e direcionou para a página de login");
//
//        //Verificação se ao clicar no botão Login da Home, ocorreu o direcionamento para a página de Login
//        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
//        login.fillEmail();
//        System.out.println("Preencheu o email");
//        login.fillPasswd();
//        System.out.println("Preencheu a senha");
//        login.clickBtnSubmitLogin();
//        System.out.println("Clicou em Sign In");
//        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
//        System.out.println("Validou a url da minha conta");
//        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
//        System.out.println("Validou a minha conta do site");
//
//    }
//
//    @Test
//    public void testSearch() {
//
//        String quest = "DRESS";
//        String questResultQtd = "7";
//
//        //Iniciar as páginas
//        HomePage home = new HomePage();
//        SearchPage search = new SearchPage();
//
//        //Fazer a pesquisa
//        home.doSearch(quest);
//
//        //Validar a pesquisa
//        assertTrue(search.isSearchPage());
//        assertEquals(search.getTextLighter().replace("\"", ""), quest);
//        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
//    }
//
//    @Test
//    @Story("Acessar Categoria")
//    public void testAcessCategoryTShirts(){
//        //Iniciar as páginas
//        HomePage home = new HomePage();
//        CategoryPage category = new CategoryPage();
//
//        //Clicar na categoria T-SHIRTS
//        home.clickCategoryTShirts();
//
//        //Validar se ao clicar na categoria T_SHIRTS ocorre o direcionamento correto
//        assertTrue(category.isPageTshirts());
//    }
//
//    @Test
//    @Story("Acessar página de produto")
//    public void testAddProductToProductPage(){
//        //Acessar a categoria T-Shirts
//        testAcessCategoryTShirts();
//
//        //Iniciar as páginas
//        CategoryPage category = new CategoryPage();
//        ProductPage pdp = new ProductPage();
//
//        //Salva nome do produto na página de categoria
//        String nameProductCategory = category.getProductNameCategory();
//
//       //clicar em more e direcionar para a pagina do produto
//        category.clickProductAddToProductPage();
//
//        //Verigicar se produto está a páginna de detalhes do produto corretamente
//        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));
//    }
//
//    @Test
//    @Story("Adicionar produto ao carrinho")
//    public void testAddProductToCartPage(){
//        //Acessa a página de produto
//        testAddProductToProductPage();
//        //Iniciar as páginas
//        ProductPage pdp = new ProductPage();
//        CartPage cart = new CartPage();
//
//        //Salvar o nome do produto na páginna de PDP
//        String nameProductPDP = pdp.getProductNamePDP();
//
//        //Clicar no botão de add ao carrinho
//        pdp.clickButtonAddToCart();
//
//        //Clicar no botão Proceed To Checkout da modal
//        pdp.clickButtonModalProceedToCheckout();
//
//        //validação do nome do produto no carrinho
//        assertTrue(cart.getNameProductCart().equals(nameProductPDP));
//
//    }
//
//
}