package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Conexao;
import main.Destinos;

public class DestinosDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void cadastrarDestinos(Destinos destino) {
		String sql = "INSERT INTO destinos(pais,cidade)" + "VALUES (?,?)";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
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
			} }
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

	public List<Destinos> consultaDestinos() {
		String sql = "SELECT * FROM destinos";
		List<Destinos> destinos = new ArrayList<Destinos>();
		ResultSet rset = null;
		
		try {
			
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Destinos destino = new Destinos();
				destino.setDestinoId(rset.getInt("destino_id"));
				destino.setPais(rset.getNString("pais"));
				destino.setCidade(rset.getNString("cidade"));
				destinos.add(destino);
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
		return destinos;
	}

	public void atualizarDestinos(Destinos destino) {
		String sql = "UPDATE destinos SET pais = ?, cidade = ?" + "WHERE destino_id = ?";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getPais());
			pstm.setString(2, destino.getCidade());
			pstm.setInt(3, destino.getDestinoId());
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

	public Destinos buscarDestinos(int destinoID) {
		Destinos destino = null;
		String sql = "SELECT * FROM destinos WHERE destino_id = ?";
		
		try {
			conn = Conexao.createConnectionToMYSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, destinoID);
			ResultSet rset = pstm.executeQuery();
			if (rset.next()) {
				destino = new Destinos();
				destino.setDestinoId(rset.getInt("destino_id"));
				destino.setPais(rset.getNString("pais"));
				destino.setCidade(rset.getNString("cidade"));
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
		return destino;
	}

	public void deletarDestino(int id) {
		String sql = "DELETE FROM destinos WHERE destino_id = ?";
		
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
}
