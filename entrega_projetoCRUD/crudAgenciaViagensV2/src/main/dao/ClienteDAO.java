package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Cliente;
import main.Conexao;

public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void atualizar(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, cpf = ?" + "WHERE cliente_id = ?";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setInt(3, cliente.getClienteId());
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
	
	public void cadastrar (Cliente cliente) {
		String sql = "INSERT INTO cliente(nome,cpf)" + " VALUES(?,?)";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
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

	public List<Cliente> consultaClientes() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				cliente.setClienteId(rset.getInt("cliente_id"));
				cliente.setNome(rset.getNString("nome"));
				cliente.setCpf(rset.getNString("cpf"));
				clientes.add(cliente);
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
		return clientes;
	}

	public void deletar(int id) {
		String sql = "DELETE FROM cliente WHERE cliente_id = ?";
		
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

	public Cliente buscarCliente(int clienteID) {
		Cliente cliente = null;
		String sql = "SELECT * FROM cliente WHERE cliente_id =?";
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, clienteID);
			ResultSet rset = pstm.executeQuery();
			if (rset.next()) {
				cliente = new Cliente();
				cliente.setClienteId(rset.getInt("cliente_id"));
				cliente.setNome(rset.getNString("nome"));
				cliente.setCpf(rset.getNString("cpf"));
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
		return cliente;
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
