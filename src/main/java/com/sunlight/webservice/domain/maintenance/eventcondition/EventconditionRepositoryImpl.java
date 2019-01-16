package com.sunlight.webservice.domain.maintenance.eventcondition;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.JPQLQuery;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionSearchRequestDto;

@Repository
public class EventconditionRepositoryImpl extends QueryDslRepositorySupport implements EventconditionCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public EventconditionRepositoryImpl() {
        super(Eventcondition.class);
    }

    public Page<EventconditionMainResponseDto> getEventconditionList(EventconditionSearchRequestDto eventconditionSearchResponseDto, Pageable pageable)  {

        QEventcondition eventcondition = QEventcondition.eventcondition;

        JPQLQuery query = from(eventcondition);

        query.orderBy(eventcondition.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<EventconditionMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
        return new PageImpl<>(result, pageable, totalCount);
    }
	
	
}
