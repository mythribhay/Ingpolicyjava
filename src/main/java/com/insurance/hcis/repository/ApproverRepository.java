/**
 * 
 */
package com.insurance.hcis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.hcis.entity.Approver;

/**
 * @author SubhaMaheswaran
 *
 */
@Repository
public interface ApproverRepository extends JpaRepository<Approver, Integer> {

	/**
	 * @param email
	 * @param password
	 * @return Approver
	 */
	Optional<Approver> findByEmailAndPassword(String email, String password);

}
