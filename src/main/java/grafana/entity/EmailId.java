package grafana.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmailId implements Serializable {

	@Column(name = "grafana_user")
	private String grafana_user;

	@Column(name = "email")
	private String email;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EmailId))
			return false;
		EmailId emailId = (EmailId) o;
		return Objects.equals(getGrafana_user(), emailId.getGrafana_user())
				&& Objects.equals(getEmail(), emailId.getEmail());

	}

	@Override
	public int hashCode() {
		return Objects.hash(getGrafana_user(), getEmail());

	}

}
