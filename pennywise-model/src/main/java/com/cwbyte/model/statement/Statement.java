package com.cwbyte.model.statement;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.cwbyte.model.finance.Account;
import com.cwbyte.model.finance.CostCenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Statement implements Serializable {
	private static final long serialVersionUID = 4272341547379402045L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "statementcategory_id")
	private StatementCategory category;

	@ManyToOne
	@JoinColumn(name = "costcenter_id")
	private CostCenter costCenter;

	private Date creation;
	private String description;
	private Date dueDate;

	@ManyToOne
	@JoinColumn(name = "statementgroup_id")
	private StatementGroup group;

	private Integer installment;
	private Date payDate;

	@Enumerated
	private StatementStatus status;

	@ManyToOne
	@JoinColumn(name = "template_id")
	private Statement template;

	@Enumerated
	private StatementType type;

	@PrePersist
	public void init() {
		this.creation = new Date();
	}
}
