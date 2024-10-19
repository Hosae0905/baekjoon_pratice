-- 코드를 입력하세요
/*
APPOINTMENT 테이블에서 22년 5월에 예약한 환자 수를 진료과코드 별로 조회한다.
컬럼명은 진료과 코드, 5월예약건수로 한다.
결과는 진료과별 예약한 환자 수 기준 오름차순, 같다면 진료과 코드 기준 오름차순 정렬한다.
*/

SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
# WHERE APNT_YMD LIKE '2022-05%'
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY 2, 1