package pro.buildmysoftware.certit.infrastructure.spring.persistence;

import org.springframework.data.repository.CrudRepository;

public interface CertificateRequestSpringDateRepository extends CrudRepository<CertificateRequestData, String> {

}
