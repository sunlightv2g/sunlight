package com.sunlight.webservice.domain.environment.equipmentinfo;

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
import com.sunlight.webservice.domain.environment.equipmentinfo.QEquipmentinfo;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoSearchRequestDto;

@Repository
public class EquipmentinfoRepositoryImpl extends QueryDslRepositorySupport implements EquipmentinfoCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public EquipmentinfoRepositoryImpl() {
        super(Equipmentinfo.class);
    }

/*    @Override
    public EquipmentinfoMainResponseDto getEquipmentinfoByQuerydsl(Long id) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QEquipmentinfo equipmentinfo = QEquipmentinfo.equipmentinfo;

        return queryFactory.select(
        		Projections.constructor(EquipmentinfoMainResponseDto.class, 
        				equipmentinfo.period
        				, equipmentinfo.weektime
        				, equipmentinfo.equipment
        				, equipmentinfo.worker
        				, equipmentinfo.content
        				, equipmentinfo.remark
        				, equipmentinfo.author
        				))
                .from(equipmentinfo)
                .where(equipmentinfo.id.eq(id)).fetchOne();

    }*/

	@Override
    public Page<EquipmentinfoMainResponseDto> getEquipmentinfoList(EquipmentinfoSearchRequestDto equipmentinfoSearchResponseDto, Pageable pageable)  {

        QEquipmentinfo equipmentinfo = QEquipmentinfo.equipmentinfo;

        JPQLQuery query = from(equipmentinfo);

        if(!StringUtils.isEmpty(equipmentinfoSearchResponseDto.getSearchFirst())) {
        	if(!equipmentinfoSearchResponseDto.getSearchFirst().equals("all")) {
        		query.where(equipmentinfo.equipment.like("%" + equipmentinfoSearchResponseDto.getSearchFirst() + "%"));
        	}
        }
        if(!StringUtils.isEmpty(equipmentinfoSearchResponseDto.getSearchStr())) {
	        if(equipmentinfoSearchResponseDto.getSearchSecond().equals("all")) {
	        	query.where(equipmentinfo.model.like("%" + equipmentinfoSearchResponseDto.getSearchStr() + "%")
        				.or(equipmentinfo.madeby.like("%" + equipmentinfoSearchResponseDto.getSearchStr() + "%"))
        				);
	        }
	        if(equipmentinfoSearchResponseDto.getSearchSecond().equals("model")) {
	        	query.where(equipmentinfo.model.like("%" + equipmentinfoSearchResponseDto.getSearchStr() + "%"));
	        }
	        if(equipmentinfoSearchResponseDto.getSearchSecond().equals("madeby")) {
	        	query.where(equipmentinfo.madeby.like("%" + equipmentinfoSearchResponseDto.getSearchStr() + "%"));
	        }
        }
        
        if(!StringUtils.isEmpty(equipmentinfoSearchResponseDto.getSearchDate())) {
        	query.where(equipmentinfo.installdate.like("%" + equipmentinfoSearchResponseDto.getSearchStr() + "%"));
        }

        query.orderBy(equipmentinfo.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<EquipmentinfoMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
/*        QueryResults<EquipmentinfoMainResponseDto> result = queryFactory.select(
        		Projections.constructor(EquipmentinfoMainResponseDto.class, 
        				equipmentinfo.period
        				, equipmentinfo.weektime
        				, equipmentinfo.equipment
        				, equipmentinfo.worker
        				, equipmentinfo.content
        				, equipmentinfo.remark
        				, equipmentinfo.author
        				))
                .from(equipmentinfo)
                .where()
                .offset(pageable.getOffset()) // offset과
                .limit(pageable.getPageSize()) // Limit 을 지정할 수 있고
                .orderBy(equipmentinfo.id.desc()) // 정렬도 가능하다
                .fetchResults();*/
        		
        return new PageImpl<>(result, pageable, totalCount);
    }
}
