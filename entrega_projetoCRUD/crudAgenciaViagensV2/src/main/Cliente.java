package main;

import java.util.Scanner;

import main.dao.ClienteDAO;

public class Cliente {
	private int clienteId;
	private String nome, cpf;
	ClienteDAO clienteDAO = new ClienteDAO();
	Scanner scanner = new Scanner(System.in);
	
	public void cadastrarCliente() {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		System.out.print("Nome do cliente: ");
		cli.setNome(scanner.nextLine());
		System.out.print("CPF do cliente: ");
		cli.setCpf(scanner.nextLine());
		clienteDAO.cadastrar(cli);
		System.out.println("Cliente cadastrado com sucesso!");
	}
	
	public void listarClientes() {
		System.out.println("Lista de clientes: ");
		for (Cliente c : clienteDAO.consultaClientes()) {
			System.out.println("ID: " + c.getClienteId());
			System.out.println("NOME: " + c.getNome());
			System.out.println("CPF: " + c.getCpf());
			System.out.println("-------------------------------");
		}
	}
	
	public void atualizarClientes() {
		System.out.print("Digite o ID do cliente que deseja atualizar: ");
		int idAttCli = scanner.nextInt();	
		Cliente clienteAtualizar = clienteDAO.buscarCliente(idAttCli);
		if(clienteAtualizar != null) {
			System.out.print("Digite o novo nome: ");
			scanner.nextLine();
			clienteAtualizar.setNome(scanner.nextLine());
			System.out.print("Digite o novo cpf: ");
			clienteAtualizar.setCpf(scanner.nextLine());
			clienteDAO.atualizar(clienteAtualizar);
			System.out.println("Cliente atualizado com sucesso!");
		} else {
			System.out.println("Cliente nao encontrado.");
		}
	}
	
	public void deletarCliente() {
		System.out.print("Id do cliente que deseja excluir: ");
		int cliIdDeletar = scanner.nextInt();
		Cliente clienteDeletar = clienteDAO.buscarCliente(cliIdDeletar);
		if (clienteDeletar != null) {
			clienteDAO.deletar(cliIdDeletar);
			System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Cliente nao encontrado.");
        }
	}
	
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
