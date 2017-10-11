---------------------------------------------------------------------

create table StatementCategory(
	id bigserial primary key
	,name varchar(40) not null
);
	
create unique index IDX_STATEMENT_CATEGORY_NAME on statementcategory(NAME);

---------------------------------------------------------------------
	
create table CostCenter(
	id bigserial primary key
	,name varchar(40) not null
);
	
create unique index IDX_COST_CENTER_NAME on costcenter(NAME);

---------------------------------------------------------------------

create table StatementGroup(
	id bigserial primary key
	,name varchar(40) not null
);
	
create unique index IDX_STATEMENT_GROUP_NAME on StatementGroup(NAME);


---------------------------------------------------------------------

create table Account(
	id bigserial primary key
	,name varchar(40) not null
	,creation timestamp not null
);
	
create unique index IDX_ACCOUNT_NAME on Account(NAME);

---------------------------------------------------------------------

create table Statement(
	id bigserial primary key
	,account_id bigint
	,costcenter_id bigint
	,description varchar(50) not null
	,creation timestamp not null
	,statementcategory_id bigint
	,duedate date not null
	,statementgroup_id bigint
	,installment smallint
	,paydate date
	,status varchar(20)
	,template_id smallint
	,statementtype varchar(20)
);

alter table statement add constraint FK_STATEMENT_ACCOUNT foreign key (account_id) references account(id);
alter table statement add constraint FK_STATEMENT_COST_CENTER foreign key (costcenter_id) references costcenter(id);
alter table statement add constraint FK_STATEMENT_STATEMENTCATEGORY foreign key (statementcategory_id) references statementcategory(id);
alter table statement add constraint FK_STATEMENT_STATEMENTGROUP foreign key (statementgroup_id) references statementgroup(id);
alter table statement add constraint FK_STATEMENT_TEMPLATE foreign key (template_id) references statement(id);
create index IDX_STATEMENT_STATEMENTTYPE on statement(statementtype);
create index IDX_STATEMENT_STATEMENTGROUP on statement(statementgroup_id);

---------------------------------------------------------------------