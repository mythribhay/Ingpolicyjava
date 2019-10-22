/**
 * 
 */
package com.insurance.hcis.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SubhaMaheswaran
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponsePolicyClaimDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient List<ResponsePolicyClaim> policyClaim;
	private String message;
	private Integer statuCode;

}
