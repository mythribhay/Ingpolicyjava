/**
 * 
 */
package com.insurance.hcis.dto;

import java.io.Serializable;

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
public class RequestClaimApproveDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer claimId;
	private Integer approverId;
	private String comments;
	private String levelOneStatus;
	private String levelTwoStatus;
}
