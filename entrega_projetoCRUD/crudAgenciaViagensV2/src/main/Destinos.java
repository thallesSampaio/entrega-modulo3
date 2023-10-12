package main;

import java.util.Scanner;

import main.dao.DestinosDAO;

public class Destinos {
	private int destinoId;
	private String pais, cidade;
	Scanner scanner = new Scanner(System.in);
	DestinosDAO destinosDAO = new DestinosDAO();
	
	public void cadastrarDestinos() {
		System.out.println("CADASTRO DE DESTINO");
		Destinos dest = new Destinos();
		System.out.print("PAIS: ");
		dest.setPais(scanner.nextLine());
		System.out.print("CIDADE: ");
		dest.setCidade(scanner.nextLine());
		destinosDAO.cadastrarDestinos(dest);
		System.out.println("DESTINO CADASTRADO COM SUCESSO!");
	}
	
	public void listarDestinos () {
		System.out.println("Lista de destinos: ");
		for (Destinos d : destinosDAO.consultaDestinos()) {
			System.out.println("ID: " + d.getDestinoId());
			System.out.println("PAIS: " + d.getPais());
			System.out.println("CIDADE: " + d.getCidade());
			System.out.println("------------------");
		}
	}
	
	public void atualizarDestinos() {
		System.out.print("Digite o ID do destino que deseja atualizar: ");
		int idAttDest = scanner.nextInt();
		Destinos destinosAtualizar = destinosDAO.buscarDestinos(idAttDest);
		if(destinosAtualizar != null) {
			System.out.print("Digite o novo pais: ");
			scanner.nextLine();
			destinosAtualizar.setPais(scanner.nextLine());
			System.out.print("Digite a nova cidade: ");
			destinosAtualizar.setCidade(scanner.nextLine());
			destinosDAO.atualizarDestinos(destinosAtualizar);
			System.out.println("Destino atualizado com sucesso!");
		} else {
			System.out.println("Destino nao encontrado.");
		}
	}
	
	public void deletarDestinos() {
		System.out.print("ID do destino que deseja excluir: ");
		int destIdDeletar = scanner.nextInt();
		Destinos destinoDeletar = destinosDAO.buscarDestinos(destIdDeletar);
		if(destinoDeletar != null) {
			destinosDAO.deletarDestino(destIdDeletar);
			System.out.println("Destino excluido com sucesso!");
		} else {
			System.out.println("destino nao encontrado.");
		}
	}
	
	public int getDestinoId() {
		return destinoId;
	}
	public void setDestinoId(int destinoId) {
		this.destinoId = destinoId;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
