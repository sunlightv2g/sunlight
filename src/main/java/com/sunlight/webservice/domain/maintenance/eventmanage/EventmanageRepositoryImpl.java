package com.sunlight.webservice.domain.maintenance.eventmanage;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sunlight.webservice.domain.maintenance.eventmanage.QEventmanage;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageSearchRequestDto;

@Repository
public class EventmanageRepositoryImpl extends QueryDslRepositorySupport implements EventmanageCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public EventmanageRepositoryImpl() {
        super(Eventmanage.class);
    }

	@Override
    public Page<EventmanageMainResponseDto> getEventmanageList(EventmanageSearchRequestDto eventmanageSearchResponseDto, Pageable pageable)  {

        QEventmanage eventmanage = QEventmanage.eventmanage;

        JPQLQuery query = from(eventmanage);

        if(!StringUtils.isEmpty(eventmanageSearchResponseDto.getStartDate())) {
        	String tempDate = eventmanageSearchResponseDto.getStartDate().replace(".", "-") + "T00:00:00";
        	LocalDateTime startDate = LocalDateTime.parse(tempDate);
        	query.where(eventmanage.eventdate.goe(startDate));
        }
        
        if(!StringUtils.isEmpty(eventmanageSearchResponseDto.getEndDate())) {
        	String tempDate = eventmanageSearchResponseDto.getEndDate().replace(".", "-") + "T23:59:29";
        	LocalDateTime endDate = LocalDateTime.parse(tempDate);
        	query.where(eventmanage.eventdate.loe(endDate));
        }

        query.orderBy(eventmanage.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<EventmanageMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
        return new PageImpl<>(result, pageable, totalCount);
    }
	
}
