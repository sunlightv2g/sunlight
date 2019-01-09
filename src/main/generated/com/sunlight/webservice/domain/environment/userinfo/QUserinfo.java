package com.sunlight.webservice.domain.environment.userinfo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserinfo is a Querydsl query type for Userinfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserinfo extends EntityPathBase<Userinfo> {

    private static final long serialVersionUID = -2082666305L;

    public static final QUserinfo userinfo = new QUserinfo("userinfo");

    public final com.sunlight.webservice.domain.QBaseTimeEntity _super = new com.sunlight.webservice.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath useremail = createString("useremail");

    public final StringPath userhp = createString("userhp");

    public final StringPath userid = createString("userid");

    public final StringPath username = createString("username");

    public final StringPath userpart = createString("userpart");

    public final StringPath userpass = createString("userpass");

    public final StringPath userrole = createString("userrole");

    public final StringPath usersms = createString("usersms");

    public final StringPath usertel = createString("usertel");

    public QUserinfo(String variable) {
        super(Userinfo.class, forVariable(variable));
    }

    public QUserinfo(Path<? extends Userinfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserinfo(PathMetadata metadata) {
        super(Userinfo.class, metadata);
    }

}

