package sut.se.G09.Backend.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name="Educational")
public class Educational {




	@Id
	@SequenceGenerator(name = "edu_seq", sequenceName = "edu_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edu_seq")
	private Long iD;
	private String eduName;

	public void setEduId(Long iD) {
		this.iD = iD;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	public Educational(Long iD, String eduName) {
		this.iD = iD;
		this.eduName = eduName;
	}
}




