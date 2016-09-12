package br.com.aprendendo.restfull.service;

import java.util.List;

import br.com.aprendendo.restfull.dao.ClienteDao;
import br.com.aprendendo.restfull.entidadeModel.Cliente;

public class ClienteService {

    public List<Cliente> findAllClientes() {
        return ClienteDao.getInstance().findAllClientes();
    }

}
