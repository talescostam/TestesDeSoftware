package sistemabancario;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class GerenciadoraClientesTest1 {

    @Test
    public void testPesquisaCliente() {

        //Criando alguns clientes
        Cliente cliente1 = new Cliente(1, "Tales", 32, "tales@gmail.com", 1, true);
        Cliente cliente2 = new Cliente(2, "Clayton", 48, "clayton@gmail.com", 2, true);

        //Inserindo os clientes criados na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente1);
        clientesDoBanco.add(cliente2);

        GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);

        //Execução do teste
        Cliente cliente = gerenciadoraClientes.pesquisaCliente(1);

        //Avaliação do teste
        Assert.assertEquals(cliente1, cliente);
        assertThat(cliente.getId(), CoreMatchers.is(1));
        assertThat(cliente.getEmail(), CoreMatchers.is("tales@gmail.com"));

    }

    @Test
    public void testRemoveCliente() {

        //Criando alguns clientes
        Cliente cliente1 = new Cliente(1, "Tales", 32, "tales@gmail.com", 1, true);
        Cliente cliente2 = new Cliente(2, "Clayton", 48, "clayton@gmail.com", 2, true);

        //Inserindo os clientes criados na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente1);
        clientesDoBanco.add(cliente2);

        GerenciadoraClientes gerenciadoraClientes = new GerenciadoraClientes(clientesDoBanco);

        //Execução do teste
        Boolean deletou = gerenciadoraClientes.removeCliente(1);

        //Avaliação do teste
        assertThat(deletou.booleanValue(), CoreMatchers.is(true));

    }

}
