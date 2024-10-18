-- 코드를 입력하세요
/*
ANIMAL_INS 테이블에서 각 동물의 아이디와 이름, 들어온 날짜를 조회한다.
결과는 아이디 순으로 조회한다.(오름차순)
들어온 날짜는 년-월-일만 보여준다.
*/
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID