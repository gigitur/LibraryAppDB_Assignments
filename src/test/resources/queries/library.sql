select count(id) from users; #--actual

select count(distinct id) from users; #--expected unique ones only

select * from books
where name like '%th';


-- us2
select count(*) from book_borrow
WHERE is_returned=0;










