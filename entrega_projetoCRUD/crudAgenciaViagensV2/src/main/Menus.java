package main;

import java.util.Scanner;

public class Menus {
	Scanner scanner = new Scanner(System.in);
	Cliente cliMethods = new Cliente();
	Destinos desMethods = new Destinos();
	Pedido pedMethods = new Pedido();

	public void Clientes() {
		System.out.println("----------------------------");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Listar Clientes");
		System.out.println("3 - Atualizar Cliente");
		System.out.println("4 - Excluir Cliente");
		System.out.println("5 - Voltar pro menu principal");
		System.out.println("----------------------------");
		System.out.print("Escolha uma opcao: ");
		int opc = scanner.nextInt();
		switch (opc) {
		case 1:
			// cadastro cliente
			cliMethods.cadastrarCliente();
			break;

		case 2:
			// consulta clientes
			cliMethods.listarClientes();
			break;

		case 3:
			// atualizar cliente
			cliMethods.atualizarClientes();
			break;

		case 4:
			// deletar cliente
			cliMethods.deletarCliente();

			break;

		case 5:
			// voltar
			break;
		}
	}

	public void Destinos() {
		System.out.println("----------------------------");
		System.out.println("1 - Cadastrar Destinos");
		System.out.println("2 - Listar Destinos");
		System.out.println("3 - Atualizar Destinos");
		System.out.println("4 - Deletar Destinos");
		System.out.println("5 - Voltar pro menu principal");
		System.out.println("----------------------------");
		System.out.print("Escolha uma opcao: ");
		int opc = scanner.nextInt();
		switch (opc) {
		case 1:
			desMethods.cadastrarDestinos();
			break;
		case 2:
			desMethods.listarDestinos();
			break;
		case 3:
			desMethods.atualizarDestinos();
			break;
		case 4:
			desMethods.deletarDestinos();
			break;
		case 5:
			//back to main menu
			break;
		}
	}
	
	public void Pedidos() {
		System.out.println("----------------------------");
		System.out.println("1 - Cadastrar Pedido");
		System.out.println("2 - Listar Pedidos");
		System.out.println("3 - Atualizar Pedido");
		System.out.println("4 - Deletar Pedido");
		System.out.println("5 - Voltar pro menu principal");
		System.out.println("----------------------------");
		System.out.print("Escolha uma opcao: ");
		int opc = scanner.nextInt();
		switch (opc) {
		case 1:
			pedMethods.cadastrarPedidos();
			break;
		case 2:
			pedMethods.listarPedidos();
			break;
		case 3:
			pedMethods.atualizarPedidos();
			break;
		case 4:
			pedMethods.deletarPedido();
			break;
		case 5:
			//back to main menu
			break;
		}
	}
}
