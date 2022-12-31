package com.unr.realtranz.service;

import com.unr.realtranz.entities.Users;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.repository.VentureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 00:21
 **/
@Service
public class VentureService {

    @Autowired
    VentureRepository ventureRepository;

    @Transactional
    public Venture getVentureByName(String ventureName){
        return ventureRepository.findByVentureName(ventureName);
    }

    public void saveVenture(Venture venture){
        ventureRepository.save(venture);
    }

    public List<Venture> getAllVentures() {
       return ventureRepository.findAll();
    }

    public List<Venture> getAllVenturesByUser(Users user) {
        return ventureRepository.findByOwner(user);
    }
}
