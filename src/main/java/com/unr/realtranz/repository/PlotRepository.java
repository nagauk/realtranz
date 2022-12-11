package com.unr.realtranz.repository;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:08-12-2022 07:40
 **/
@Repository
public interface PlotRepository extends JpaRepository<Plot,Long> {

    List<Plot> findByVenture(String venture);

    Plot findByVentureAndPlotId(String venture, String plotId);

    Plot findByVentureAndId(String venture, Long id);
}
