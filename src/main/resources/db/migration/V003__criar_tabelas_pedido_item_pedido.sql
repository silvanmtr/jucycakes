CREATE TABLE pedido (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    codigo_usuario BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE item_pedido (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    codigo_pedido BIGINT(20) NOT NULL,
    codigo_item BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_pedido) REFERENCES pedido(codigo),
    FOREIGN KEY (codigo_item) REFERENCES bolo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
