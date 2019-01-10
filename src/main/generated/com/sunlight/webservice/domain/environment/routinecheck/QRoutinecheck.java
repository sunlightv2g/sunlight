package com.sunlight.webservice.domain.environment.routinecheck;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoutinecheck is a Querydsl query type for Routinecheck
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoutinecheck extends EntityPathBase<Routinecheck> {

    private static final long serialVersionUID = 479340319L;

    public static final QRoutinecheck routinecheck = new QRoutinecheck("routinecheck");

    public final com.sunlight.webservice.domain.QBaseTimeEntity _super = new com.sunlight.webservice.domain.QBaseTimeEntity(this);

    public final StringPath author = createString("author");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath equipment = createString("equipment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath period = createString("period");

    public final StringPath remark = createString("remark");

    public final StringPath weektime = createString("weektime");

    public final StringPath worker = createString("worker");

    public QRoutinecheck(String variable) {
        super(Routinecheck.class, forVariable(variable));
    }

    public QRoutinecheck(Path<? extends Routinecheck> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoutinecheck(PathMetadata metadata) {
        super(Routinecheck.class, metadata);
    }

}

