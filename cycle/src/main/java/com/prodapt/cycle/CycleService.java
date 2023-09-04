package com.prodapt.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.prodapt.cycle.repository.*;

@Service
public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    public List<Cycle> getAllCycles() {
        return cycleRepository.findAll();
    }

    public Cycle borrowCycleById(Integer id) {
        Cycle cycle = cycleRepository.findById(id).orElse(null);
        if (cycle != null && cycle.isAvailable() && cycle.getStock() > 0) {
            cycle.setAvailable(false);
            cycle.setStock(cycle.getStock() - 1);
            cycleRepository.save(cycle);
            return cycle;
        }
        return null;     }

    public Cycle returnCycleById(Integer id) {
        Cycle cycle = cycleRepository.findById(id).orElse(null);
        if (cycle != null && !cycle.isAvailable()) {
            cycle.setAvailable(true);
            cycle.setStock(cycle.getStock() + 1);
            cycleRepository.save(cycle);
            return cycle;
        }
        return null; 
    }

    public List<Cycle> getAllModelsAndStock() {
        return cycleRepository.findAll();
    }

    public Cycle incrementStockById(Integer id, int incrementAmount) {
        Cycle cycle = cycleRepository.findById(id).orElse(null);
        if (cycle != null) {
            cycle.setStock(cycle.getStock() + incrementAmount);
            cycleRepository.save(cycle);
            return cycle;
        }
        return null; 
    }

	public void saveCycle(Cycle cycle) {
		cycleRepository.save(cycle);
		
	}

	
}
