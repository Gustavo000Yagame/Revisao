package service;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Helpdesk {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Chamado> chamados = new ArrayList<>();



    public ArrayList<Chamado> buscarChamadosPorNome(String nome){
        ArrayList<Chamado> lista = new ArrayList<>();
        for (Chamado c : chamados){
            if (c.getCliente().getNome().equalsIgnoreCase(nome)){
                lista.add(c);
            }
        }
        return lista;
    }


    public ArrayList<Chamado> listarChamadosPorStatus(StatusChamado status){
        ArrayList<Chamado> lista = new ArrayList<>();

        for (Chamado c : chamados){
            if (c.getStatus() == status){
                lista.add(c);
            }
        }

        return lista;
    }

    // Buscar chamado pelo número
    public Chamado buscarChamadoPorNumero(Integer numero){
        for (Chamado c : chamados){
            if (c.getNumero().equals(numero)){
                return c;
            }
        }
        return null;
    }

    public Chamado buscarChamadoPorNome(String nome){
        for (Chamado c : chamados){
            if (c.getCliente().getNome().equalsIgnoreCase(nome)){
                return c;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Alterar status do chamado
    public boolean alterarStatusChamado(Integer numero, StatusChamado novoStatus){
        Chamado c = buscarChamadoPorNumero(numero);

        if (c == null){
            return false;
        }

        c.setStatus(novoStatus);
        return true;
    }

    //Operações do Cliente
    public void cadastrarCliente(String nome, String email){

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setEmail(email);
        clientes.add(c);
    }

    public Cliente buscarCliente(String email){
        for (Cliente c : clientes){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c;
            }
        }
        return null;
    }


    public boolean alterarDescricaoChamado(Integer numero, String descricao) {
        Chamado chamado = buscarChamadoPorNumero(numero);
        if (chamado == null) {
            return false;
        }
        chamado.setDescricao(descricao);
        return true;
    }


    //Operações do Chamado
    public void abrirChamado(Integer numero, String titulo, String descricao, PrioridadeChamado prioridade, Cliente cliente){
        if (numero == null) return;

        //Cliente cli = buscarCliente(email);

        Chamado ch = new Chamado();
        ch.setNumero(numero);
        ch.setTitulo(titulo);
        ch.setData(LocalDate.now());
        ch.setDescricao(descricao);
        ch.setPrioridade(prioridade);
        ch.setStatus(StatusChamado.ABERTO);
        ch.setCliente(cliente);

        chamados.add(ch);

    }
}
