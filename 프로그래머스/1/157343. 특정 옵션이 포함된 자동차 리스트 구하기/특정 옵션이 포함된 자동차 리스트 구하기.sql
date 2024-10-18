-- 코드를 입력하세요
/*
CAR_RENTAL_COMPANY_CAR 테이블에서 네비게이션 옵션이 포함된 자동차 리스트를 출력해야 한다.
자동차 ID를 기준으로 내림차순 정렬해야 한다.
OPTIONS에 네비게이션이 포함되어 있는지 조건문이 필요하다.
*/
SELECT * FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC