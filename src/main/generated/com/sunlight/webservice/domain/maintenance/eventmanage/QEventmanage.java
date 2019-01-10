package com.sunlight.webservice.domain.maintenance.eventmanage;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEventmanage is a Querydsl query type for Eventmanage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEventmanage extends EntityPathBase<Eventmanage> {

    private static final long serialVersionUID = -1882100735L;

    public static final QEventmanage eventmanage = new QEventmanage("eventmanage");

    public final com.sunlight.webservice.domain.QBaseTimeEntity _super = new com.sunlight.webservice.domain.QBaseTimeEntity(this);

    public final StringPath actiondetail = createString("actiondetail");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath equipment = createString("equipment");

    public final DateTimePath<java.time.LocalDateTime> eventdate = createDateTime("eventdate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath reason = createString("reason");

    public final DateTimePath<java.time.LocalDateTime> recoverdate = createDateTime("recoverdate", java.time.LocalDateTime.class);

    public final StringPath worker = createString("worker");

    public QEventmanage(String variable) {
        super(Eventmanage.class, forVariable(variable));
    }

    public QEventmanage(Path<? extends Eventmanage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEventmanage(PathMetadata metadata) {
        super(Eventmanage.class, metadata);
    }

}

