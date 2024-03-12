-- 코드를 작성해주세요
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM
(SELECT 
(CASE WHEN ITEM_ID IN (SELECT DISTINCT PARENT_ITEM_ID FROM ITEM_TREE) THEN NULL ELSE ITEM_ID END) AS ITEM_ID,
ITEM_NAME, RARITY
FROM ITEM_INFO) TB
WHERE ITEM_ID IS NOT NULL
ORDER BY ITEM_ID DESC
