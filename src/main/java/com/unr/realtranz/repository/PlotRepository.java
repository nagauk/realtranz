package com.unr.realtranz.repository;

import com.unr.realtranz.entities.Plot;
import com.unr.realtranz.entities.Users;
import com.unr.realtranz.entities.Venture;
import com.unr.realtranz.models.PlotStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    List<Plot> findByVenture(Venture venture);

    Plot findById(long id);

    Plot findByVentureAndPlotId(Venture venture, String plotId);

    Plot findByVentureAndId(Venture venture, Long id);
    Page<Plot> findByPltStatus(PlotStatus status, Pageable pageable);
    Page<Plot> findByPltStatusAndPlotIdContainingIgnoreCaseOrPlotSizeContainingIgnoreCaseOrFacingContainingIgnoreCase(PlotStatus status,String keyword1,String keyword2,String keyword3, Pageable pageable);
}
