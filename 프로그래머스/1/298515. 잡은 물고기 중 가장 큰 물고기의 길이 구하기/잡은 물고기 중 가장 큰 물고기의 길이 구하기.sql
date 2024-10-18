-- 코드를 작성해주세요
# FISH_INFO 테이블에서 가장 길이가 큰 물고기를 조회한다.
# 길이가 큰 물고기에 cm를 붙여서 출력한다.

SELECT CONCAT(MAX(LENGTH), 'cm') AS MAX_LENGTH FROM FISH_INFO