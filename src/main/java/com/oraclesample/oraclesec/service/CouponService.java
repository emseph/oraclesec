package com.oraclesample.oraclesec.service;

import java.util.*;

import com.oraclesample.oraclesec.model.Coupon;
import com.oraclesample.oraclesec.repository.CouponRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getAllCoupon() {
        return couponRepository.findAll();
    }

    public void addCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public void removeCouponById(int id) {
        couponRepository.deleteById(id);
    }

    public Optional<Coupon> getCouponById(int id) {
        return couponRepository.findById(id);
    }
}
