package com.sunlight.webservice.domain.environment.equipmentinfo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipmentinfo is a Querydsl query type for Equipmentinfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEquipmentinfo extends EntityPathBase<Equipmentinfo> {

    private static final long serialVersionUID = 4206843L;

    public static final QEquipmentinfo equipmentinfo = new QEquipmentinfo("equipmentinfo");

    public final com.sunlight.webservice.domain.QBaseTimeEntity _super = new com.sunlight.webservice.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath equipment = createString("equipment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath installaddr = createString("installaddr");

    public final StringPath installdate = createString("installdate");

    public final StringPath madeby = createString("madeby");

    public final StringPath model = createString("model");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath remark = createString("remark");

    public QEquipmentinfo(String variable) {
        super(Equipmentinfo.class, forVariable(variable));
    }

    public QEquipmentinfo(Path<? extends Equipmentinfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipmentinfo(PathMetadata metadata) {
        super(Equipmentinfo.class, metadata);
    }

}

