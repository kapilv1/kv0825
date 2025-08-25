
package com.tool.kv0825.repo;

import com.tool.kv0825.model.RentalAgreement;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class AgreementRepo {
    private final Map<String, RentalAgreement> store = new LinkedHashMap<>();

    public RentalAgreement save(RentalAgreement a) {
        store.put(a.getId(), a);
        return a;
    }

    public Optional<RentalAgreement> findById(String id) { return Optional.ofNullable(store.get(id)); }
    public Collection<RentalAgreement> findAll() { return store.values(); }
}
