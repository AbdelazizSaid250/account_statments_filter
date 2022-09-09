create table data_source_iec61850
(
    id           varchar(255) primary key,
    name         text not null,
    port         int  not null,
    ip           text not null,
    manufacturer text null,
    description  text null
);

create table functional_constraint
(
    id   varchar(255) primary key,
    name text not null
);

create table logical_device
(
    id      varchar(255) primary key,
    name    text not null,
    ld_inst text null
);

create table logical_node
(
    id        varchar(255) primary key,
    ld_id     varchar(255) not null,
    name      text         not null,
    ln_inst   text         null,
    ln_class  text         null,
    ln_type   text         null,
    ln_prefix text         null,
    foreign key (ld_id) references logical_device (id)
);

create table data_object
(
    id      varchar(255) primary key,
    ln_id   varchar(255) not null,
    name    text         not null,
    do_type text         null,
    cdc     text         null,
    foreign key (ln_id) references logical_node (id)
);

create table data_attribute
(
    id               varchar(255) primary key,
    do_id            varchar(255) not null,
    name             text         not null,
    data_attr_type   text         null,
    data_attr_b_type text         null,
    dchg             bool         null,
    qchg             bool         null,
    dupd             bool         null,
    foreign key (do_id) references data_object (id)
);

create table data_point_iec61850
(
    id       varchar(255) primary key,
    ds_id    varchar(255) not null,
    fc_id    varchar(255) not null,
    da_id    varchar(255) not null,
    mms_name text         not null,
    foreign key (da_id) references data_attribute (id),
    foreign key (ds_id) references data_source_iec61850 (id),
    foreign key (fc_id) references functional_constraint (id)
);

create table port_configuration
(
    id        varchar(255) primary key,
    port_name varchar(255) not null,
    baud_rate int          not null,
    data_bits int          not null,
    parity    text         not null,
    stop      int          not null,
    constraint port_configuration_port_name_uindex
        unique (port_name)
);

create table serial_device
(
    id          varchar(255) primary key,
    protocol    text not null,
    device_name text not null
);

create table data_source_modbus
(
    id               varchar(255) primary key,
    port_config_id   varchar(255) null,
    serial_device_id varchar(255) null,
    server_id        int          not null,
    voltage_level    text         null,
    feeder_number    text         null,
    foreign key (port_config_id) references port_configuration (id),
    foreign key (serial_device_id) references serial_device (id)
);

create table data_point_modbus
(
    id                    varchar(255) primary key,
    data_source_id        varchar(255) not null,
    register_address      int          not null,
    consecutive_registers int          not null,
    threshold_percentage  int          not null,
    status                text         null,
    message               text         null,
    prev_value            float        null,
    last_time             timestamp    null,
    foreign key (data_source_id) references data_source_modbus (id)
);

create table register_info
(
    id                    varchar(255) primary key,
    serial_device_id      varchar(255) not null,
    register_address      int          not null,
    consecutive_registers int          not null,
    threshold_percentage  int          not null,
    mapped_data           text         null,
    encoding              text         null,
    description           text         null,
    constraint registers_map_register_address_uindex
        unique (register_address),
    foreign key (serial_device_id) references serial_device (id)
);

