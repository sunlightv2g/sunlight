package com.sunlight.webservice.domain.environment.userinfo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.ParamExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;

@Repository
public class UserinfoRepositoryImpl extends QueryDslRepositorySupport implements UserinfoCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public UserinfoRepositoryImpl() {
        super(Userinfo.class);
    }
    
    @Override
    public long getUserinfoByQuerydsl(String userid) {
    	QUserinfo userinfo = QUserinfo.userinfo;
    	JPQLQuery query = from(userinfo);
    	query.where(userinfo.userid.eq(userid));
    	return query.fetchCount();
    }
    
    @Override
    public long getUserinfoByQuerydsl(String userid, String userpass) {
    	QUserinfo userinfo = QUserinfo.userinfo;
    	JPQLQuery query = from(userinfo);
    	query.where(userinfo.userid.eq(userid));
    	query.where(userinfo.userpass.eq(userpass));
    	return query.fetchCount();
    }

	@Override
    public Page<UserinfoMainResponseDto> getUserinfoList(UserinfoSearchRequestDto userinfoSearchResponseDto, Pageable pageable)  {

        QUserinfo userinfo = QUserinfo.userinfo;
        
        JPQLQuery query = from(userinfo);
        if(!StringUtils.isEmpty(userinfoSearchResponseDto.getSearchStr())) {
        	if(userinfoSearchResponseDto.getSearchFlag().equals("all")) {
        		query.where(userinfo.userid.like("%" + userinfoSearchResponseDto.getSearchStr() + "%")
        				.or(userinfo.username.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"))
        				.or(userinfo.userpart.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"))
        				.or(userinfo.useremail.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"))
        				);
        	}
	        if(userinfoSearchResponseDto.getSearchFlag().equals("userid")) {
	        	query.where(userinfo.userid.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"));
	        }
	        if(userinfoSearchResponseDto.getSearchFlag().equals("username")) {
	        	query.where(userinfo.username.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"));
	        }
	        if(userinfoSearchResponseDto.getSearchFlag().equals("userpart")) {
	        	query.where(userinfo.userpart.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"));
	        }
	        if(userinfoSearchResponseDto.getSearchFlag().equals("useremail")) {
	        	query.where(userinfo.useremail.like("%" + userinfoSearchResponseDto.getSearchStr() + "%"));
	        }
        }
        
        
        query.orderBy(userinfo.id.desc());
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        
        List<UserinfoMainResponseDto> result = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();
        
        return new PageImpl<>(result, pageable, totalCount);
    }
	
	@Override
	public long update(Userinfo entity) {
    	QUserinfo userinfo = QUserinfo.userinfo;
    	
    	long rstCnt = new JPAUpdateClause(entityManager, userinfo).where(userinfo.id.eq(entity.getId()))
        .set(userinfo.userid, entity.getUserid())
        .set(userinfo.username, entity.getUsername())
        .set(userinfo.userrole, entity.getUserrole())
        .set(userinfo.userpart, entity.getUserpart())
        .set(userinfo.userhp, entity.getUserhp())
        .set(userinfo.usertel, entity.getUsertel())
        .set(userinfo.useremail, entity.getUseremail())
        .set(userinfo.usersms, entity.getUsersms())
        .execute();
    	    	
    	return rstCnt;
		
	}
}
