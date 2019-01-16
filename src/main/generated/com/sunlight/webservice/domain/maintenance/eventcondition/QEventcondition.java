package com.sunlight.webservice.domain.maintenance.eventcondition;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEventcondition is a Querydsl query type for Eventcondition
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventcondition extends EntityPathBase<Eventcondition> {

    private static final long serialVersionUID = 487113599L;

    public static final QEventcondition eventcondition = new QEventcondition("eventcondition");

    public final com.sunlight.webservice.domain.QBaseTimeEntity _super = new com.sunlight.webservice.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath equipment = createString("equipment");

    public final StringPath flag = createString("flag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath place = createString("place");

    public final StringPath status = createString("status");

    public final StringPath workdate = createString("workdate");

    public QEventcondition(String variable) {
        super(Eventcondition.class, forVariable(variable));
    }

    public QEventcondition(Path<? extends Eventcondition> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEventcondition(PathMetadata metadata) {
        super(Eventcondition.class, metadata);
    }

}

