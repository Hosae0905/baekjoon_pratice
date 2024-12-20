-- 코드를 입력하세요
/*
CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 22년 9월에 속하는 대여기록을 조회한다.
22년 9월 대여 기록에서 대여 기간이 30일 이상이면 장기 대여, 아니면 단기 대여로 표시하는 컬럼을 추가한다.
결과는 대여 기록 ID를 기준으로 내림차순 정렬한다.
*/
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m-%d'), DATE_FORMAT(END_DATE, '%Y-%m-%d'),
(CASE
    WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 THEN '장기 대여'
    WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 30 THEN '단기 대여'
END) AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE '2022-09%'
ORDER BY HISTORY_ID DESC