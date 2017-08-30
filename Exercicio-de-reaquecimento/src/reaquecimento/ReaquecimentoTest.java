package reaquecimento;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReaquecimentoTest {

	private Banco banco = new Banco();
	@Test
	public void IdosoChamadoAntesNaFilaPreferencial() {
		Cliente clienteIdoso = new Cliente("John", 67);
		Cliente clienteNaoIdoso = new Cliente("Marcos", 17);
		Caixa caixaPreferencial = new Caixa(2);
		banco.adicionaNaFila(clienteIdoso);
		banco.adicionaNaFila(clienteNaoIdoso);
		assertEquals("John", banco.retiraFila(caixaPreferencial).getNome());
	}
	@Test
	public void FilaNaoPreferencialChamaOQueEsperaHaMaisTempo() {
		Cliente clienteNaoIdoso = new Cliente("Marcos", 17);
		Cliente clienteIdoso = new Cliente("John", 67);
		Caixa caixaNaoPreferencial = new Caixa(7);
		banco.adicionaNaFila(clienteNaoIdoso);
		banco.adicionaNaFila(clienteIdoso);
		assertEquals("Marcos", banco.retiraFila(caixaNaoPreferencial).getNome());
	}
	@Test
	public void FilaNaoPreferencialChamaOQueEsperaHaMaisTempo2() {
		Cliente clienteIdoso = new Cliente("John", 67);
		Cliente clienteNaoIdoso = new Cliente("Marcos", 17);
		Caixa caixaNaoPreferencial = new Caixa(7);
		banco.adicionaNaFila(clienteIdoso);
		banco.adicionaNaFila(clienteNaoIdoso);
		assertEquals("John", banco.retiraFila(caixaNaoPreferencial).getNome());
	}
	@Test
	public void FilaNaoPreferencialChamaOQueEsperaHaMaisTempo3() {
		Cliente clienteIdoso = new Cliente("John", 67);
		Cliente clienteNaoIdoso = new Cliente("Marcos", 17);
		Cliente clienteNaoIdoso2 = new Cliente("Augusto", 19);
		Cliente clienteNaoIdoso3 = new Cliente("Julia", 62);
		Caixa caixaNaoPreferencial = new Caixa(7);
		banco.adicionaNaFila(clienteNaoIdoso);
		banco.adicionaNaFila(clienteNaoIdoso2);
		banco.adicionaNaFila(clienteNaoIdoso3);
		banco.adicionaNaFila(clienteIdoso);
		assertEquals("Marcos", banco.retiraFila(caixaNaoPreferencial).getNome());
	}
	@Test
	public void NaoHaIdosoNaFila() {
		Cliente clienteNaoIdoso = new Cliente("Marcos", 17);
		Caixa caixaPreferencial = new Caixa(2);
		banco.adicionaNaFila(clienteNaoIdoso);
		assertEquals("Marcos", banco.retiraFila(caixaPreferencial).getNome());
	}
	@Test
	public void NaoHaNinguemNaFila() {
		Caixa caixaPreferencial = new Caixa(2);
		assertNull(banco.retiraFila(caixaPreferencial));
	}

}
