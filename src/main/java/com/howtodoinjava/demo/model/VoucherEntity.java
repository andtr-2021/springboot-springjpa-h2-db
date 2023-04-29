package com.howtodoinjava.demo.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_VOUCHERS")
public class VoucherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public VoucherEntity() {

    }

    @Column(name="voucher_amount")
    private String voucherAmount;

    @Column(name="voucher_code")
    private String voucherCode;

    @Column(name="voucher_expire_date")
    private String voucherExpiryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoucherAmount() {
        return voucherAmount;
    }

    public void setVoucherAmount(String voucherAmount) {
        this.voucherAmount = voucherAmount;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherExpiryDate() {
        return voucherExpiryDate;
    }

    public void setVoucherExpiryDate(String voucherExpiryDate) {
        this.voucherExpiryDate = voucherExpiryDate;
    }
}
