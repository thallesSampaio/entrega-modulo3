package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import main.dao.ClienteDAO;
import main.dao.DestinosDAO;
import main.dao.PedidoDAO;

public class Pedido {
	private int pedido_id;
	private Cliente cliente;
	private Destinos destino;
	private Date dataViagem;
	
	PedidoDAO pedidoDAO = new PedidoDAO();
	Scanner scanner = new Scanner(System.in);
	ClienteDAO clienteDAO = new ClienteDAO();
	DestinosDAO destinosDAO = new DestinosDAO();
	
	public void cadastrarPedidos() {
		Pedido pedido = new Pedido();
		System.out.print("ID do Cliente: ");
		int clienteId = scanner.nextInt();
		Cliente clienteConsulta = clienteDAO.buscarCliente(clienteId);
		if (clienteConsulta != null) {
			pedido.setCliente(clienteConsulta);
			System.out.print("ID do destino: ");
			int destinoId = scanner.nextInt();
			Destinos destinoConsulta = destinosDAO.buscarDestinos(destinoId);
			if(destinoConsulta != null) {
				pedido.setDestino(destinoConsulta);
				System.out.print("Data da viagem (dd/mm/yyyy): ");
				String dataString = scanner.next();
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dataViagem = sdf.parse(dataString);
					pedido.setDataViagem(dataViagem);
					pedidoDAO.cadastrarPedido(pedido);
					System.out.println("Pedido cadastrado com sucesso!");
				} catch (ParseException e) {
					System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
				}
			} else {
				System.out.println("Destino não encontrado.");
			}
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

	public void listarPedidos() {
		List<Pedido> pedidos = pedidoDAO.listarPedidos();
		System.out.println("Lista de Pedidos:");
		for (Pedido p : pedidos) {
			System.out.println("Pedido ID: " + p.getPedido_id());
			System.out.println("Cliente: " + p.getCliente().getNome());
			System.out.println("Pais: " + p.getDestino().getPais() + " // Cidade: " + p.getDestino().getCidade() );
			System.out.println("Data Viagem: " + p.getDataViagem());
			System.out.println("-----------------------------");
		}
	}

	public void atualizarPedidos() {
		System.out.print("ID do pedido para atualizaçao: ");
		int pedidoID = scanner.nextInt();
		Pedido pedidoAtualizar = pedidoDAO.buscarPedido(pedidoID);
		if(pedidoAtualizar != null) {
			System.out.print("Nova Data da Viagem (dd/mm/yyyy): ");
			String novaDataString = scanner.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date novaDataViagem = sdf.parse(novaDataString);
				pedidoAtualizar.setDataViagem(novaDataViagem);
				pedidoDAO.atualizarPedido(pedidoAtualizar);
				System.out.println("Pedido atualizada com sucesso!");
			} catch (ParseException e) {
                System.out.println("Formato de data invalido. Use dd/mm/yyyy.");
            }
		} else {
			System.out.println("Pedido nao encontrado.");
		}
	}

	public void deletarPedido() {
		System.out.print("ID do pedido que deseja deletar: ");
		int pedidoIdExcluir = scanner.nextInt();
		Pedido pedidoExcluir = pedidoDAO.buscarPedido(pedidoIdExcluir);
		if(pedidoExcluir != null) {
			pedidoDAO.deletarPedido(pedidoIdExcluir);
			System.out.println("Pedido excluido com sucesso!");
		} else {
			System.out.println("Consulta nao encontrado.");
		}
	}
	
	
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Destinos getDestino() {
		return destino;
	}
	public void setDestino(Destinos destino) {
		this.destino = destino;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	
}
