

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/veiculos")
public class VeiculoResources {

	@Autowired
	private VeiculoRepository vr;

	//@GetMapping(value = "/teste", produces = "application/json")
	//public @ResponseBody Veiculo testeVeiculo() {
	//	return new Veiculo(1L, "FIAT", "UNO", "BRANCO", 5000, "1.0", "CARRO");
	//}
	@GetMapping(value = "/{id}")
	public Veiculo buscaId(@PathVariable Long id) throws Exception {
		Optional<Veiculo> verifica = vr.findById(id);
		if (!verifica.isPresent()) {
			throw new Exception("Id - " + id + " Inexistente!");
		}
		return verifica.get();
	}

	@GetMapping(value = "/lista")
	public @ResponseBody Iterable<Veiculo> listaVeiculos() {
		Iterable<Veiculo> listaVeiculos = vr.findAll();
		return listaVeiculos;
	}



	
	@GetMapping(value = "/tipo/{tipo}")
    public @ResponseBody
    Iterable<Veiculo> listaPorTipo(@PathVariable String tipo) {
        Iterable<Veiculo> listaVeiculos = vr.tiposDeVeiculo(tipo);
        return listaVeiculos;
    }
    
    @GetMapping(value = "/montadora/{montadora}")
    public @ResponseBody
    Iterable<Veiculo> listaPorMontadora(@PathVariable String montadora) {
        Iterable<Veiculo> listaVeiculos = vr.montadora(montadora);
        return listaVeiculos;
    }
    
    @GetMapping(value = "/motor/{motor}")
    public @ResponseBody
    Iterable<Veiculo> listaPorMotor(@PathVariable String motor) {
        Iterable<Veiculo> listaVeiculos = vr.motor(motor);
        return listaVeiculos;
    }
    	@PostMapping(value = "/adiciona")
	public Veiculo cadastraVeiculo(@RequestBody @Valid Veiculo oVeiculo) {
		return vr.save(oVeiculo);
	}

    
    @GetMapping(value = "/filtros/{tipo}/{montadora}/{km}")
    public @ResponseBody
    Iterable<Veiculo> filtros(@PathVariable String tipo, @PathVariable String montadora, @PathVariable int km) {
        Iterable<Veiculo> listaVeiculos = vr.filtros(tipo, montadora, km);
        return listaVeiculos;
    }
	
	

	@PutMapping(value = "/modifica/{id}")
	public ResponseEntity<Veiculo> modificaVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo oVeiculo) {
		Optional<Veiculo> veiculoInfo = vr.findById(id);

		if (veiculoInfo.isPresent()) {
			Veiculo veiculoAtual = veiculoInfo.get();
			veiculoAtual.setId(oVeiculo.getId());
			veiculoAtual.setMontadora(oVeiculo.getMontadora());
			veiculoAtual.setModelo(oVeiculo.getModelo());
			veiculoAtual.setCor(oVeiculo.getCor());
			veiculoAtual.setKm(oVeiculo.getKm());
			veiculoAtual.setMotor(oVeiculo.getMotor());
			veiculoAtual.setTipo(oVeiculo.getTipo());

		
			vr.save(veiculoAtual);
			return ResponseEntity.ok(veiculoAtual);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	

	@DeleteMapping(value = "/deleta")
	public Veiculo deletaVeiculo(@RequestBody Veiculo oVeiculo) {
		vr.delete(oVeiculo);
		return oVeiculo;
	}
	

	
}
