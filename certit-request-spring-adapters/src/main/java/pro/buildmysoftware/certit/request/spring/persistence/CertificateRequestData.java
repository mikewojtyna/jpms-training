package pro.buildmysoftware.certit.request.spring.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class CertificateRequestData {

	@Id
	private String id;
}
