package com.sunlight.webservice.domain.maintenance.eventhistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEventhistory is a Querydsl query type for Eventhistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventhistory extends EntityPathBase<Eventhistory> {

    private static final long serialVersionUID = -1835268129L;

    public static final QEventhistory eventhistory = new QEventhistory("eventhistory");

    public final com.sunlight.webservice.domain.QBaseTimeEntity _super = new com.sunlight.webservice.domain.QBaseTimeEntity(this);

    public final StringPath author = createString("author");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath equipment = createString("equipment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath remark = createString("remark");

    public final StringPath result = createString("result");

    public final StringPath workdate = createString("workdate");

    public final StringPath worker = createString("worker");

    public QEventhistory(String variable) {
        super(Eventhistory.class, forVariable(variable));
    }

    public QEventhistory(Path<? extends Eventhistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEventhistory(PathMetadata metadata) {
        super(Eventhistory.class, metadata);
    }

}

