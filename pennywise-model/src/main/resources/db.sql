create table StatementCategory(
	id integer primary key
	,name varchar(40)
);

create unique index IDX_STATEMENT_CATEGORY_NAME on statementcategory(NAME);
