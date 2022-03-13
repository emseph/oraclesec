package com.oraclesample.oraclesec.repository;

import com.oraclesample.oraclesec.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
