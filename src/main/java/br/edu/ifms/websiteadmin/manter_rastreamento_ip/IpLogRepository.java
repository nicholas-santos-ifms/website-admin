/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.manter_rastreamento_ip;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author santos
 */
public interface IpLogRepository extends JpaRepository<IpLog, Long> {

    List<IpLog> findByIpAddressAndSuccessfulLoginAndLastLoginAttemptGreaterThanEqual(String ipAddress, Boolean successLogin, Long lastLoginAttempt);
}
