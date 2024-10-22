-- 코드를 입력하세요
/*
CAR_RENTAL_COMPANY_CAR 테이블에서 통풍시트, 열선시트, 가죽시트 중 하나 이상의 옵션이 포함된
자동차가 종류 별로 몇 대인지 출력하라.
자동차 수에 대한 컬럼명은 CARS로 지정하고 결과는 자동차 종류 기준으로 오름차순 정렬해라.
*/


SELECT CAR_TYPE, COUNT(OPTIONS) AS CARS
FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS REGEXP '통풍시트|열선시트|가죽시트'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE

# SELECT *
# FROM CAR_RENTAL_COMPANY_CAR