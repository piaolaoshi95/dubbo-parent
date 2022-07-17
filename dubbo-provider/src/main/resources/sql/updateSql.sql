CREATE TABLE
    USER
    (
        id INT NOT NULL AUTO_INCREMENT COMMENT '用户编号',
        username VARCHAR(64) COLLATE utf8mb4_bin COMMENT '账号',
        password VARCHAR(32) COLLATE utf8mb4_bin COMMENT '密码',
        create_time DATETIME COMMENT '创建时间',
        deleted bit COMMENT '是否删除。0-未删除；1-删除',
        PRIMARY KEY (id),
        CONSTRAINT idx_username UNIQUE (username)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;