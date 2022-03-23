create table users
(
    userId int primary key auto_increment,
    userName varchar(100),
    userPassword varchar(100),
    userEmail varchar(100),
    userDescribe varchar(200),
    userLoginTime timestamp,
    userHead text
);

create table article
(
    articleId int primary key auto_increment,
    articleTitle varchar(200),
    articleContent text,
    articleTime timestamp,
    articleDescribe varchar(200),
    userId int
);

create table reply
(
    replyId int primary key auto_increment,
    replyContent text,
    replyTime timestamp,
    replyAuthorId int,
    authorId int,
    articleId int
);

create index articleIndex on article(articleTitle(50));
-- alter table article add userId int;

# alter table article add constraint a_fk foreign key(userId) references users(userId) on update cascade;
# alter table reply add constraint reply_replyAuthorId_fk foreign key (replyAuthorId) references users(userId) on update cascade;
# alter table reply add constraint reply_authorId_fk foreign key (authorId) references users(userId) on update cascade;
# alter table reply add constraint reply_articleId_fk foreign key (articleId) references 	article(articleId) on update cascade;


