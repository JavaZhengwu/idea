package com.itheima.dao;

import com.itheima.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface CustomerDao {

    @Select("select * from cst_customer")
    @Results(id = "customerMap",value = {
            @Result(id = true,property = "custId",column = "cust_id"),
            @Result(property = "custName",column = "cust_name"),
            @Result(property = "custLevel",column = "cust_level"),
            @Result(property = "custSource",column = "cust_source"),
            @Result(property = "custIndustry",column = "cust_industry"),
            @Result(property = "custAddress",column = "cust_address"),
            @Result(property = "custPhone",column = "cust_phone")
    })
    public List<Customer> findAll();


    @Select("select * from cst_customer where cust_id=#{custId}")
    @ResultMap("customerMap")
    Customer findCustomerById(Integer id);

    //@Update("update cst_customer set cust_name=#{custName},cust_level=#{custLevel},cust_source=#{custSource},cust_industry=#{custIndustry},cust_address=#{custAddress},cust_phone=#{custPhone}")
    void updateCustomer(Customer customer);

    @Insert("insert into cst_customer values(#{custId},#{custName},#{custLevel},#{custSource},#{custIndustry},#{custAddress},#{custPhone})")
    void saveCustomer(Customer customer);
}
