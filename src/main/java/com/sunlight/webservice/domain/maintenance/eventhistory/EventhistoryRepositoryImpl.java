package com.sunlight.webservice.domain.maintenance.eventhistory;

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

import com.querydsl.core.Fetchable;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.sunlight.webservice.domain.environment.userinfo.QUserinfo;
import com.sunlight.webservice.domain.environment.userinfo.Userinfo;
import com.sunlight.webservice.domain.maintenance.eventhistory.QEventhistory;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistoryMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySearchRequestDto;

@Repository
public class EventhistoryRepositoryImpl extends QueryDslRepositorySupport implements EventhistoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public EventhistoryRepositoryImpl() {
        super(Eventhistory.class);
    }

    @Override
    public EventhistoryMainResponseDto getEventhistoryByQuerydsl(Long id) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QEventhistory eventhistory = QEventhistory.eventhistory;

        return queryFactory.select(
        		Projections.constructor(EventhistoryMainResponseDto.class, 
        				eventhistory.equipment
        				, eventhistory.author
        				, eventhistory.worker
        				, eventhistory.content
        				, eventhistory.result
        				, eventhistory.remark
        				))
                .from(eventhistory)
                .where(eventhistory.id.eq(id)).fetchOne();

    }

	@Override
    public List<EventhistoryMainResponseDto> getEventhistoryList(EventhistorySearchRequestDto eventhistorySearchResponseDto)  {

        QEventhistory eventhistory = QEventhistory.eventhistory;
        JPQLQuery query = from(eventhistory);

        if(!StringUtils.isEmpty(eventhistorySearchResponseDto.getCYear()) && !StringUtils.isEmpty(eventhistorySearchResponseDto.getCMonth())) {
        	query.where(eventhistory.workdate.like("%" + eventhistorySearchResponseDto.getCYear() + "." + eventhistorySearchResponseDto.getCMonth() + "%"));
        }
        
        query.orderBy(eventhistory.id.desc());
        List<EventhistoryMainResponseDto> result = query.fetch();
        return result;
    }
	
	
	@Override
	public long update(Eventhistory entity) {
		 QEventhistory eventhistory = QEventhistory.eventhistory;
    	
    	long rstCnt = new JPAUpdateClause(entityManager, eventhistory).where(eventhistory.id.eq(entity.getId()))
        .set(eventhistory.workdate, entity.getWorkdate())
        .set(eventhistory.equipment, entity.getEquipment())
        .set(eventhistory.author, entity.getAuthor())
        .set(eventhistory.worker, entity.getWorker())
        .set(eventhistory.content, entity.getContent())
        .set(eventhistory.result, entity.getResult())
        .set(eventhistory.remark, entity.getRemark())
        .execute();
    	    	
    	return rstCnt;
		
	}
	
}
