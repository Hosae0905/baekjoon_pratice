-- 코드를 입력하세요

/*
SEX_UPON_INTAKE 테이블에서 중성화 여부를 파악한다.
동물의 아이디와 이름, 중성화 여부를 아이디 순으로 조회한다.
중성화가 되어있다면 O, 아니면 X라고 표시한다.
*/

SELECT ANIMAL_ID, NAME, 
(CASE
    WHEN SEX_UPON_INTAKE = 'Neutered Male' THEN 'O'
    WHEN SEX_UPON_INTAKE = 'Spayed Female' THEN 'O'
    ELSE 'X'
END) AS 중성화
FROM ANIMAL_INS 
ORDER BY ANIMAL_ID

# SELECT * 
# FROM ANIMAL_INS