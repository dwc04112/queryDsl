package com.example.queryDslExam.user_info.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Quser_info is a Querydsl query type for user_info
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Quser_info extends EntityPathBase<user_info> {

    private static final long serialVersionUID = 446945740L;

    public static final Quser_info user_info = new Quser_info("user_info");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath region = createString("region");

    public final StringPath user_class = createString("user_class");

    public final NumberPath<Long> user_id = createNumber("user_id", Long.class);

    public final StringPath user_name = createString("user_name");

    public Quser_info(String variable) {
        super(user_info.class, forVariable(variable));
    }

    public Quser_info(Path<? extends user_info> path) {
        super(path.getType(), path.getMetadata());
    }

    public Quser_info(PathMetadata metadata) {
        super(user_info.class, metadata);
    }

}

