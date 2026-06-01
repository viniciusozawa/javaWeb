/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.viniciusozawainfoh.modelo.dao;

import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.entity.Cidade;
import br.edu.ifsuldeminas.viniciusozawainfoh.modelo.entity.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author 02338079698
 */
public class FuncionarioDao extends GenericoDAO<Funcionario>{
    
    
    public void salvar(Funcionario objFuncionario){
        String sql = "INSERT INTO FUNCIONARIO(NOME, SALARIO, NASCIMENTO, CODIGOCIDADE) VALUES(?,?,?,?)";
        save(sql, objFuncionario.getNomeFuncionario(), objFuncionario.getSalarioFuncionario(), objFuncionario.getNascimentoFuncionario(), objFuncionario.getCidadeFuncionario().getCodCidade());
        
    }
    
    public void alterar(Funcionario objFuncionario){
        String sql = "UPDATE FUNCIONARIO SET NOME = ? , SALARIO =?, NASCIMENTO =?, CODIGOCIDADE =? WHERE CODIGO=?";
        save(sql, objFuncionario.getNomeFuncionario(), objFuncionario.getSalarioFuncionario(), objFuncionario.getNascimentoFuncionario(), objFuncionario.getCidadeFuncionario().getCodCidade(), objFuncionario.getCodigoFuncionario() );
        
    }
    public void exclui(Funcionario objFuncionario){
        String sql = "DELETE FROM FUNCIONARIO WHERE CODIGO=?";
        save(sql, objFuncionario.getCodigoFuncionario());
        
    }
    
    private static class FuncionarioRowMapper implements RowMapper<Funcionario>{
        CidadeDao objCidadeDao = new CidadeDao();
        @Override
        public Funcionario mapRow(ResultSet rs) throws SQLException {
           Funcionario objFuncionario = new Funcionario();
           objFuncionario.setCodigoFuncionario(rs.getInt(1));
           objFuncionario.setNomeFuncionario(rs.getString(2));
           objFuncionario.setSalarioFuncionario(rs.getDouble(3));
           objFuncionario.setNascimentoFuncionario(rs.getDate(4).toLocalDate());
           objFuncionario.setCidadeFuncionario(objCidadeDao.buscarCidadePorId(rs.getInt(5)));
           
           System.out.println("Mapeando o objeto cidade"+objFuncionario.toString());
           return objFuncionario;
        }
        
    }
    
    public List<Funcionario> buscarTodasCidade(){
        String sql = "SELECT * FROM FUNCIONARIO";
        return buscarTodos(sql, new FuncionarioRowMapper());
    }
    
    public Funcionario buscarFuncionarioPorId(int id){
        String sql = "SELECT * FROM FUNCIONARIO WHERE CODIGO=? ";
        return buscarPorId(sql, new FuncionarioRowMapper(), id);
    }
}
