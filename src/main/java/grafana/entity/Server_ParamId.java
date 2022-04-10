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
public class Server_ParamId implements Serializable {

	@Column(name="id")
	private int id;

	@Column(name="key")
	private String key;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Server_ParamId))
			return false;
		Server_ParamId server_paramId = (Server_ParamId) o;
		return Objects.equals(getId(), server_paramId.getId()) && Objects.equals(getKey(), server_paramId.getKey());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getKey());
	}

}
