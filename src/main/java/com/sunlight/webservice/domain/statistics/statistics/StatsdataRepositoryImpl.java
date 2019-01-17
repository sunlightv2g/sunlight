package com.sunlight.webservice.domain.statistics.statistics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataMainResponseDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataSearchRequestDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataTimeResponseDto;

@Repository
public class StatsdataRepositoryImpl extends QueryDslRepositorySupport implements StatsdataCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public StatsdataRepositoryImpl() {
        super(Statsdata.class);
    }

    @Override
    public List<StatsdataMainResponseDto> getStatisticsList(StatsdataSearchRequestDto statsdataSearchRequestDto) {
    	
    	QStatsdata statsdata = QStatsdata.statsdata;
        
        JPQLQuery query = from(statsdata);
       	query.where(statsdata.userid.eq(statsdataSearchRequestDto.getUserid()));
       	query.offset(statsdataSearchRequestDto.getOffset());
       	query.limit(1);
        query.orderBy(statsdata.id.desc());
        List<StatsdataMainResponseDto> result = query.fetch();
        return result;
    }
    
    @Override
    public List<StatsdataMainResponseDto> getStatisticsByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(this.getEntityManager());

        QStatsdata statsdata = QStatsdata.statsdata;

        return queryFactory.select(
        		Projections.constructor(StatsdataMainResponseDto.class, 
        				statsdata.id
        				, statsdata.userid
        				, statsdata.avoltage
        				, statsdata.acurrent
        				, statsdata.bvoltage
        				, statsdata.bcurrent
        				, statsdata.cvoltage
        				, statsdata.ccurrent
        				, statsdata.voltage1
        				, statsdata.humidity1
        				, statsdata.illumination1
        				, statsdata.temperature1
        				))
                .from(statsdata)
                .where(statsdata.userid.eq(statsdataSearchRequestDto.getUserid()))
                .fetch();
    }
    
    @Override
    public String getStatisticsTotalByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto) {
    
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
	    Query q = entityManager.createNativeQuery("select round((((0.173 * avoltage * acurrent) + (0.174 * bvoltage * bcurrent) + (0.175 * avoltage * acurrent)) / 3) *  100) as total from statsdata where userid = :userid limit 1 offset :offset");
	    q.setParameter("userid", statsdataSearchRequestDto.getUserid());
	    q.setParameter("offset", statsdataSearchRequestDto.getOffset());
	    String result = String.valueOf(q.getSingleResult());
	    
	    return result;
	    
    }
    
    @Override
    public List<StatsdataTimeResponseDto> getStatisticsTimeByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto) {
    	
//	    Query q = entityManager.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id");
    	String query = "select "; 
    		query += "round((((0.173 * a.avoltage * a.acurrent) + (0.174 * a.bvoltage * a.bcurrent) + (0.175 * a.avoltage * a.acurrent)) / 3) *  0.001) as timeval ";
    		query += ",a.dayflag ";
			query += "from( ";
			query += "select "; 
			query += "sum(avoltage) as avoltage ";
			query += ",sum(acurrent) as acurrent ";
			query += ",sum(bvoltage) as bvoltage ";
			query += ",sum(bcurrent) as bcurrent ";
			query += ",sum(cvoltage) as cvoltage ";
			query += ",sum(ccurrent) as ccurrent ";
			query += ",substring(regdate,12,2) as dayflag ";
			query += "from statsdata  ";
			query += "group by  ";
			query += "substring(regdate,12,2) ";
			query += ") a ";
			query += "order by a.dayflag asc ";
    	System.out.println(query);
    	Query q = entityManager.createNativeQuery(query);
//    	List<StatsdataTotalResponseDto> result = q.getResultList();
    	List<Object> result = (List<Object>) q.getResultList();
    	
    	List<StatsdataTimeResponseDto> StatsdataTotalResponseDto = new ArrayList<StatsdataTimeResponseDto>();
    	Iterator itr = result.iterator();
    	while(itr.hasNext()){
    	   StatsdataTimeResponseDto statsdataTotalResponseDto = new StatsdataTimeResponseDto();
    	   Object[] obj = (Object[]) itr.next();

    	   statsdataTotalResponseDto.setTimeval(String.valueOf(obj[0]));
    	   statsdataTotalResponseDto.setDayflag(String.valueOf(obj[1]));

    	   StatsdataTotalResponseDto.add(statsdataTotalResponseDto);
    	}
    	
    	
    	return StatsdataTotalResponseDto;
    	
    }
}
