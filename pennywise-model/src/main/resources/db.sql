create table StatementCategory(
	id bigserial primary key
	,name varchar(40)
);
	
create unique index IDX_STATEMENT_CATEGORY_NAME on statementcategory(NAME);

	
create table CostCenter(
	id bigserial primary key
	,name varchar(40)
);
	
create unique index IDX_COST_CENTER_NAME on costcenter(NAME);

create table StatementGroup(
	id bigserial primary key
	,name varchar(40)
);
	
create unique index IDX_STATEMENT_GROUP_NAME on StatementGroup(NAME);
