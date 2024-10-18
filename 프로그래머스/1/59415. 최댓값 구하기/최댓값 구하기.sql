-- 코드를 입력하세요
/*
가장 최근에 들어온 동물은 언제 들어왔는지 조회
ANIMAL_INS 테이블에서 가장 최근에 들어온 동물을 조회한다.
DATETIME을 조회해야 하는데 컬럼 명은 시간이 되어야 한다.
*/

SELECT MAX(DATETIME) AS 시간 FROM ANIMAL_INS