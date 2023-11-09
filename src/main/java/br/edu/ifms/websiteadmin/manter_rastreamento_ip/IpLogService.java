/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_rastreamento_ip;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author santos
 */
@Service
@RequiredArgsConstructor
public class IpLogService implements IpTracker {

    private final IpLogRepository ipLogRepository;

    @Override
    public void successfulLogin(String username, String ipAddress) {
        IpLog ipLog = new IpLog();

        ipLog.setIpAddress(ipAddress);
        ipLog.setLastLoginAttempt(System.currentTimeMillis());
        ipLog.setSuccessfulLogin(true);
        ipLog.setUsername(username);

        ipLogRepository.save(ipLog);
    }

    @Override
    public void unsuccessfulLogin(String username, String ipAddress) {
        IpLog ipLog = new IpLog();

        ipLog.setIpAddress(ipAddress);
        ipLog.setLastLoginAttempt(System.currentTimeMillis());
        ipLog.setSuccessfulLogin(false);
        ipLog.setUsername(username);

        ipLogRepository.save(ipLog);
    }

    @Override
    public List<IpLog> fetchIpFailureRecord(String ipAddress, Long startingTime) {
        List<IpLog> list = new ArrayList<>();

        if (ipAddress != null) {
            list = ipLogRepository.findByIpAddressAndSuccessfulLoginAndLastLoginAttemptGreaterThanEqual(ipAddress, false, startingTime);
        }

        return list;
    }
}
