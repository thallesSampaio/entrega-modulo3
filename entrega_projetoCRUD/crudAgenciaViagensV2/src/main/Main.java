package main;


import java.util.Scanner;

import main.dao.ClienteDAO;
import main.dao.DestinosDAO;
import main.dao.PedidoDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Menus menus = new Menus();
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinosDAO destinosDAO = new DestinosDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();

		while (true) {
			System.out.println("SISTEMA DE VIAGENS");
			System.out.println("----------------------------");
			System.out.println("1 - Menu Clientes");
			System.out.println("2 - Menu Destinos");
			System.out.println("3 - Menu Pedidos");
			System.out.println("4 - SAIR");
			System.out.println("----------------------------");
			System.out.print("Escolha uma opcao: ");
			int opc = scanner.nextInt();
			
			switch (opc) {
			case 1:
				menus.Clientes();
				break;
				
			case 2:
				menus.Destinos();
				break;
				
			case 3:
				menus.Pedidos();
				break;
				
			case 4:
				System.out.println("Exiting system...");
				clienteDAO.fecharConexao();
				destinosDAO.fecharConexao();
				pedidoDAO.fecharConexao();
				scanner.close();
				System.exit(0);
				break;
				
			}
		}
	}
}
