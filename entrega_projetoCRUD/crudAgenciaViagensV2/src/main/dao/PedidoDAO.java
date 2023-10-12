package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Conexao;
import main.Pedido;

public class PedidoDAO {
	ClienteDAO clienteDAO = new ClienteDAO();
	DestinosDAO destinosDAO = new DestinosDAO();
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void cadastrarPedido (Pedido pedido) {
		String sql = "INSERT INTO pedidos (cli_id, dest_id, dataViagem) VALUE (?,?,?)";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedido.getCliente().getClienteId());
			pstm.setInt(2, pedido.getDestino().getDestinoId());
			pstm.setTimestamp(3, new java.sql.Timestamp(pedido.getDataViagem().getTime()));
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Pedido> listarPedidos() {
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "SELECT * from pedidos";
		ResultSet rset = null;
		
		try { 
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while(rset.next()) {
				Pedido pedido = new Pedido();
				pedido.setPedido_id(rset.getInt("pedido_id"));;
				pedido.setCliente(clienteDAO.buscarCliente(rset.getInt("cli_id")));
				pedido.setDestino(destinosDAO.buscarDestinos(rset.getInt("dest_id")));
				pedido.setDataViagem(rset.getTimestamp("dataViagem"));
				pedidos.add(pedido);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pedidos;
	}

	public Pedido buscarPedido(int pedidoID) {
		Pedido pedido = null;
		String sql = "SELECT * FROM pedidos WHERE pedido_id =?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedidoID);
			ResultSet rset = pstm.executeQuery();
			
			if(rset.next()) {
				pedido = new Pedido();
				pedido.setPedido_id(rset.getInt("pedido_id"));
				pedido.setCliente(clienteDAO.buscarCliente(rset.getInt("cli_id")));
				pedido.setDestino(destinosDAO.buscarDestinos(rset.getInt("dest_id")));
				pedido.setDataViagem(rset.getTimestamp("dataViagem"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pedido;
	}
	
	public void atualizarPedido (Pedido pedido) {
		String sql = "UPDATE pedidos SET cli_id = ?, dest_id = ?, dataViagem = ? WHERE pedido_id = ?";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pedido.getCliente().getClienteId());
			pstm.setInt(2, pedido.getDestino().getDestinoId());
			pstm.setTimestamp(3, new java.sql.Timestamp(pedido.getDataViagem().getTime()));
			pstm.setInt(4, pedido.getPedido_id());
			pstm.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void deletarPedido(int id) {
		String sql = "DELETE FROM pedidos where pedido_id = ?";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void fecharConexao() throws Exception {
		conn = Conexao.createConnectionToMYSQL();
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
