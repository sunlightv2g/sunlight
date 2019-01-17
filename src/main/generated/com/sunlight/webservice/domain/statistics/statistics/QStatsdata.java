package com.sunlight.webservice.domain.statistics.statistics;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStatsdata is a Querydsl query type for Statsdata
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatsdata extends EntityPathBase<Statsdata> {

    private static final long serialVersionUID = -984065035L;

    public static final QStatsdata statsdata = new QStatsdata("statsdata");

    public final NumberPath<Double> acurrent = createNumber("acurrent", Double.class);

    public final NumberPath<Double> avoltage = createNumber("avoltage", Double.class);

    public final NumberPath<Double> bcurrent = createNumber("bcurrent", Double.class);

    public final NumberPath<Double> bvoltage = createNumber("bvoltage", Double.class);

    public final NumberPath<Double> ccurrent = createNumber("ccurrent", Double.class);

    public final NumberPath<Double> cvoltage = createNumber("cvoltage", Double.class);

    public final NumberPath<Integer> humidity1 = createNumber("humidity1", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> illumination1 = createNumber("illumination1", Integer.class);

    public final NumberPath<Integer> temperature1 = createNumber("temperature1", Integer.class);

    public final StringPath userid = createString("userid");

    public final NumberPath<Integer> voltage1 = createNumber("voltage1", Integer.class);

    public QStatsdata(String variable) {
        super(Statsdata.class, forVariable(variable));
    }

    public QStatsdata(Path<? extends Statsdata> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStatsdata(PathMetadata metadata) {
        super(Statsdata.class, metadata);
    }

}

