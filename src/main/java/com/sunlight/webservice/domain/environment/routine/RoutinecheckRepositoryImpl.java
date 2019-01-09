package com.sunlight.webservice.domain.environment.routine;

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
import com.sunlight.webservice.domain.environment.routine.QRoutinecheck;
import com.sunlight.webservice.dto.environment.routine.RoutinecheckMainResponseDto;
import com.sunlight.webservice.dto.environment.routine.RoutinecheckSearchRequestDto;

@Repository
public class RoutinecheckRepositoryImpl extends QueryDslRepositorySupport implements RoutinecheckCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public RoutinecheckRepositoryImpl() {
        super(Routinecheck.class);
    }

    @Override
    public RoutinecheckMainResponseDto getRoutinecheckByQuerydsl(Long id) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QRoutinecheck routinecheck = QRoutinecheck.routinecheck;

        return queryFactory.select(
        		Projections.constructor(RoutinecheckMainResponseDto.class, 
        				routinecheck.period
        				, routinecheck.weektime
        				, routinecheck.equipment
        				, routinecheck.worker
        				, routinecheck.content
        				, routinecheck.remark
        				, routinecheck.author
        				))
                .from(routinecheck)
                .where(routinecheck.id.eq(id)).fetchOne();

    }

	@Override
    public Page<RoutinecheckMainResponseDto> getRoutinecheckList(RoutinecheckSearchRequestDto routinecheckSearchResponseDto, Pageable pageable)  {

        QRoutinecheck routinecheck = QRoutinecheck.routinecheck;

        JPQLQuery query = from(routinecheck);

        if(!StringUtils.isEmpty(routinecheckSearchResponseDto.getEquipment())) {
        	query.where(routinecheck.equipment.like("%" + routinecheckSearchResponseDto.getEquipment() + "%"));
        }
        
        if(!StringUtils.isEmpty(routinecheckSearchResponseDto.getStartDate())) {
        	String tempDate = routinecheckSearchResponseDto.getStartDate().replace(".", "-") + "T00:00:00";
        	LocalDateTime startDate = LocalDateTime.parse(tempDate);
        	query.where(routinecheck.modifiedDate.goe(startDate));
        }
        
        if(!StringUtils.isEmpty(routinecheckSearchResponseDto.getEndDate())) {
        	String tempDate = routinecheckSearchResponseDto.getEndDate().replace(".", "-") + "T23:59:29";
        	LocalDateTime endDate = LocalDateTime.parse(tempDate);
        	query.where(routinecheck.modifiedDate.loe(endDate));
        }

        query.orderBy(routinecheck.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<RoutinecheckMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
/*        QueryResults<RoutinecheckMainResponseDto> result = queryFactory.select(
        		Projections.constructor(RoutinecheckMainResponseDto.class, 
        				routinecheck.period
        				, routinecheck.weektime
        				, routinecheck.equipment
        				, routinecheck.worker
        				, routinecheck.content
        				, routinecheck.remark
        				, routinecheck.author
        				))
                .from(routinecheck)
                .where()
                .offset(pageable.getOffset()) // offset과
                .limit(pageable.getPageSize()) // Limit 을 지정할 수 있고
                .orderBy(routinecheck.id.desc()) // 정렬도 가능하다
                .fetchResults();*/
        		
        return new PageImpl<>(result, pageable, totalCount);
    }
}
