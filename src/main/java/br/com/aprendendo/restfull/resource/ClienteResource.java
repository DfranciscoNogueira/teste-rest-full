package br.com.aprendendo.restfull.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.aprendendo.restfull.entidadeModel.Cliente;
import br.com.aprendendo.restfull.service.ClienteService;

/**
 * 
 * Contem os metodos de acesso ao webService
 * 
 * @author Diego_Francisco
 *
 */
@Path("/cliente")
public class ClienteResource {

    @GET
    @Path("/findAllClientes")
    @Produces("application/json") // pode ser tambem um XML basta trocar o json por xml
    public List<Cliente> findAllClientes() {
        return new ClienteService().findAllClientes();
    }

}
