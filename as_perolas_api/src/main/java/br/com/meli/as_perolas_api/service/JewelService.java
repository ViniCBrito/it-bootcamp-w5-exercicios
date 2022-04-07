package br.com.meli.as_perolas_api.service;

import br.com.meli.as_perolas_api.exception.JewelNotFoundException;
import br.com.meli.as_perolas_api.model.Jewel;
import br.com.meli.as_perolas_api.repository.JewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IService<Jewel, Long> {

    private final JewelRepository jewelRepository;

    public JewelService(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    private Jewel findJewel(Long id) throws RuntimeException {
        return this.jewelRepository.findById(id)
                .orElseThrow(() -> new JewelNotFoundException("ID: ".concat(id.toString())));
    }

    @Override
    public Jewel create(Jewel jewel) {
        return this.jewelRepository.save(jewel);
    }

    @Override
    public List<Jewel> listAll() {
        return this.jewelRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Jewel foundJewel = findJewel(id);
        this.jewelRepository.delete(foundJewel);
    }

    @Override
    public Jewel update(Jewel jewel) {
        Jewel foundJewel = findJewel(jewel.getId());
        foundJewel.setWeight(jewel.getWeight());
        foundJewel.setMaterial(jewel.getMaterial());
        foundJewel.setCarats(jewel.getCarats());
        jewel = this.jewelRepository.save(foundJewel);
        return jewel;
    }
}
