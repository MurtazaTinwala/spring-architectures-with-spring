package com.packtpub.bankingapplication.accounts.services;

import com.packtpub.bankingapplication.accounts.dao.CustomerRepository;
import com.packtpub.bankingapplication.accounts.domain.Customer;
import com.packtpub.bankingapplication.notifications.domain.NotificationChannel;

import java.util.List;

/**
 * Created by renriquez on 15/11/17.
 */
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void savePreferredNotificationChannels(Customer customer, List<NotificationChannel> notificationChannels) {
        notificationChannels.forEach(notificationChannel -> customerRepository.savePreferredChannel(notificationChannel));
    }
}
