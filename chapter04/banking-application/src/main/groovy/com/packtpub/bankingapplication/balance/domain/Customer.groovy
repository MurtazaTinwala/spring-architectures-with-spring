package com.packtpub.bankingapplication.balance.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Customer {

    @Id
    Long idCustomer

    String identification

    String fullName
}