package br.sceweb.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

/**
 * Objetivo: Validar o cadastro de Empresas no Banco de Dados
 * @author Caue Polimanti
 *
 */
public class UC01CadastrarEmpresa {
	public static Empresa empresa;
	public static EmpresaDAO empresaDAO;
	
	/**
	 * Prepara o ambiente de testes
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();		
		empresa.setCnpj("60430951000122");
		empresa.setNomeDaEmpresa("Open Informatica Ltda");
		empresa.setNomeFantasia("Open Informatica");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("122121");
	}

	/**
	 * Valida o cadastro de empresa
	 */
	@Test
	public void CT01UC01FB_cadastrar_empresa_com_sucesso() {		
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	/**
	 * Volta o sistema para o estado anterior para
	 * estabelecer as pre-condicoes antes da execucao dos próximos testes
	 * @throws Exception
	 */
	@After
	public void excluiEmpresa() throws Exception {
		empresaDAO.exclui(empresa.getCnpj());
	}
	
	/**
	 * Teste de cadastro de empresa com cnpj ja existente
	 */
	@Test(expected=RuntimeException.class)
	public void CT02UC01A2_cadastrar_empresa_cnpj_existente() {
		empresaDAO.adiciona(empresa);
		
		// tenta cadastrar uma empresa com cnpj igual
		empresa = new Empresa();		
		empresa.setCnpj("60430951000122");
		empresa.setNomeDaEmpresa("Closed Informatica Ltda");
		empresa.setNomeFantasia("Closed Informatica");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("122121");
		empresaDAO.adiciona(empresa);
	}
	
	/**
	 * Teste de cadastro de empresa com cnpj invalido
	 */
	@Test(expected=IllegalArgumentException.class)
	public void CT02UC01A2_cadastrar_empresa_cnpj_invalido() {
		empresa.setCnpj("");
		empresaDAO.adiciona(empresa);
	}
	
	/**
	 * Teste de cadastro com campos obrigatórios em branco
	 * Obs.: maneira errada de se fazer, apesar de funcionar.
	 * Devemos fazer o teste unitário o mais reduzido possível,
	 * com alvo de teste objetivo
	 */
	@Test
	public void CT02UC01A2_cadastrar_empresa_campos_branco() {
		int contaErros = 0;	// contador da quantidade de erros
		final int qtdErrosEsperada = 4;	// qtd de erros esperada
		
		try{
			empresa.setNomeDaEmpresa("");
		} catch(IllegalArgumentException e){
			if(e.getMessage() == "Nome da empresa invalido")
				contaErros++;
		}
		try{
			empresa.setNomeFantasia("");
		} catch(IllegalArgumentException e){
			if(e.getMessage() == "Nome Fantasia da empresa invalido")
				contaErros++;
		}
		try{
			empresa.setEndereco("");
		} catch(IllegalArgumentException e){
			if(e.getMessage() == "Endereco da empresa invalido")
				contaErros++;
		}
		try{
			empresa.setTelefone("");
		} catch(IllegalArgumentException e){
			if(e.getMessage() == "Telefone da empresa invalido")
				contaErros++;
		}
		
		// verifica se a quantidade de erros gerada foi a
		// equivalente ao total de erros esperada
		assertEquals(qtdErrosEsperada, contaErros);
	}

}
