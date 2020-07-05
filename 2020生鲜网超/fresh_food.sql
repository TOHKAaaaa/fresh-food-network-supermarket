drop table if exists admin_infor;

drop table if exists customer_infor;

drop table if exists discount_infor;

drop table if exists food_evaluation;

drop table if exists food_infor;

drop table if exists full_discount_infor;

drop table if exists full_product_associate;

drop table if exists limited_time_promotion_infor;

drop table if exists order_form_details;

drop table if exists product_buy;

drop table if exists product_food_recommend;

drop table if exists product_infor;

drop table if exists product_order_form;

drop table if exists send_addr;

/*==============================================================*/
/* Table: admin_infor                                           */
/*==============================================================*/
create table admin_infor
(
   admin_id             varchar(20) not null,
   admin_name           varchar(20),
   admin_pwd            varchar(255),
   primary key (admin_id)
);

/*==============================================================*/
/* Table: customer_infor                                        */
/*==============================================================*/
create table customer_infor
(
   customer_id          varchar(20) not null,
   customer_name        varchar(20),
   customer_sex         varchar(10),
   customer_pwd         varchar(255),
   customer_phonenum    varchar(20),
   customer_email       varchar(50),
   customer_city        varchar(50),
   customer_registration_date timestamp,
   customer_VIPwhether  varchar(10),
   customer_VIPddl      timestamp,
   primary key (customer_id)
);

/*==============================================================*/
/* Table: discount_infor                                        */
/*==============================================================*/
create table discount_infor
(
   discount_id          varchar(20) not null,
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   discount_details     varchar(255),
   apply_price          float,
   discount_price       float,
   start_date           timestamp,
   end_date             timestamp,
   primary key (discount_id)
);

/*==============================================================*/
/* Table: food_evaluation                                       */
/*==============================================================*/
create table food_evaluation
(
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   customer_id          varchar(20),
   evaluation_infor     varchar(255),
   evaluation_date      timestamp,
   evaluation_star      int,
   photos               varchar(20)
);

/*==============================================================*/
/* Table: food_infor                                            */
/*==============================================================*/
create table food_infor
(
   food_id              varchar(20) not null,
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   food_name            varchar(20),
   food_materials       varchar(255),
   food_step            varchar(255),
   food_picture         varchar(255),
   primary key (food_id)
);

/*==============================================================*/
/* Table: full_discount_infor                                   */
/*==============================================================*/
create table full_discount_infor
(
   full_discount_id     varchar(20) not null,
   full_discount_details varchar(255),
   able_sum             int,
   discount             float,
   full_discount_start_time timestamp,
   full_discount_end_time timestamp,
   primary key (full_discount_id)
);

/*==============================================================*/
/* Table: full_product_associate                                */
/*==============================================================*/
create table full_product_associate
(
   full_discount_id     varchar(20) not null,
   product_id           varchar(20) not null,
   fresh_food_id        varchar(20) not null,
   product_discount_start_time timestamp,
   product_discount_end_time timestamp,
   primary key (full_discount_id, product_id, fresh_food_id)
);

/*==============================================================*/
/* Table: limited_time_promotion_infor                          */
/*==============================================================*/
create table limited_time_promotion_infor
(
   limited_time_promotion_id varchar(20) not null,
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   limited_time_promotion_sum int,
   limited_time_promotion_price float,
   associate_start_time timestamp,
   associate_end_time   timestamp,
   primary key (limited_time_promotion_id)
);

/*==============================================================*/
/* Table: order_form_details                                    */
/*==============================================================*/
create table order_form_details
(
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   full_discount_id     varchar(20),
   order_form_id        varchar(20),
   order_form_sum       int,
   order_form_price     float,
   discount             float
);

/*==============================================================*/
/* Table: product_buy                                           */
/*==============================================================*/
create table product_buy
(
   product_buy_id       varchar(20) not null,
   admin_id             varchar(20),
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   product_buy_sum      int,
   product_state        varchar(20),
   primary key (product_buy_id)
);

/*==============================================================*/
/* Table: product_food_recommend                                */
/*==============================================================*/
create table product_food_recommend
(
   product_id           varchar(20),
   fresh_food_id        varchar(20),
   food_id              varchar(20),
   evaluation           varchar(255)
);

/*==============================================================*/
/* Table: product_infor                                         */
/*==============================================================*/
create table product_infor
(
   product_id           varchar(20) not null,
   product_name         varchar(20),
   product_price        float,
   product_VIP_price    float,
   product_num          int,
   product_specification varchar(50),
   product_details      varchar(255),
   fresh_food_id        varchar(20) not null,
   fresh_food_name      varchar(20),
   fresh_food_describe  varchar(255),
   primary key (product_id, fresh_food_id)
);

/*==============================================================*/
/* Table: product_order_form                                    */
/*==============================================================*/
create table product_order_form
(
   order_form_id        varchar(20) not null,
   discount_id          varchar(20) not null,
   customer_id          varchar(20) not null,
   addr_id              varchar(20) not null,
   original_price       float,
   finally_price        float,
   request_send_time    timestamp,
   order_form_state     varchar(20),
   primary key (order_form_id, customer_id, addr_id, discount_id)
);

/*==============================================================*/
/* Table: send_addr                                             */
/*==============================================================*/
create table send_addr
(
   addr_id              varchar(20) not null,
   province             varchar(20),
   city                 varchar(20),
   district             varchar(20),
   address              varchar(50),
   linkman              varchar(20),
   phonenum             varchar(20),
   primary key (addr_id)
);

alter table discount_infor add constraint FK_Relationship_6 foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table food_evaluation add constraint FK_evluate foreign key (customer_id)
      references customer_infor (customer_id) on delete restrict on update restrict;

alter table food_evaluation add constraint FK_include_evulate foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table food_infor add constraint FK_cook foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table full_product_associate add constraint FK_full_product_associate foreign key (full_discount_id)
      references full_discount_infor (full_discount_id) on delete restrict on update restrict;

alter table full_product_associate add constraint FK_full_product_associate2 foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table limited_time_promotion_infor add constraint FK_Relationship_5 foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table order_form_details add constraint FK_Relationship_11 foreign key (full_discount_id)
      references full_discount_infor (full_discount_id) on delete restrict on update restrict;

alter table order_form_details add constraint FK_Relationship_12 foreign key (order_form_id, , , )
      references product_order_form (order_form_id, customer_id, addr_id, discount_id) on delete restrict on update restrict;

alter table order_form_details add constraint FK_Relationship_13 foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table product_buy add constraint FK_Relationship_14 foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table product_buy add constraint FK_Relationship_15 foreign key (admin_id)
      references admin_infor (admin_id) on delete restrict on update restrict;

alter table product_food_recommend add constraint FK_include foreign key (food_id)
      references food_infor (food_id) on delete restrict on update restrict;

alter table product_food_recommend add constraint FK_make foreign key (product_id, fresh_food_id)
      references product_infor (product_id, fresh_food_id) on delete restrict on update restrict;

alter table product_order_form add constraint FK_Relationship_10 foreign key ()
      references discount_infor (discount_id) on delete restrict on update restrict;

alter table product_order_form add constraint FK_Relationship_8 foreign key (customer_id)
      references customer_infor (customer_id) on delete restrict on update restrict;

alter table product_order_form add constraint FK_Relationship_9 foreign key (addr_id)
      references send_addr (addr_id) on delete restrict on update restrict;
