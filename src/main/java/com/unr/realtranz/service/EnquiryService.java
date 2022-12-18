package com.unr.realtranz.service;

import com.unr.realtranz.entities.Enquiry;
import com.unr.realtranz.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:21
 **/
@Service
public class EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    public void saveEnquiry(Enquiry enquiry){
        enquiryRepository.save(enquiry);
    }
}
