select concat('/home/grep/src/', board_id, '/',file_id, file_name, file_ext) as file_path
from used_goods_file
where board_id = 
(select board_id 
from used_goods_board
order by views desc
limit 1)
order by file_id desc;

# /home/grep/src/B0008/MOV_000008photo1.avi
# /home/grep/src/B0008/IMG_000011photo.png
# WITH A AS (SELECT
# BOARD_ID
# FROM
# USED_GOODS_BOARD
# ORDER BY VIEWS DESC
# LIMIT 1)

# SELECT
# CONCAT("/home/grep/src/", BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
# FROM
# USED_GOODS_FILE
# WHERE BOARD_ID = (SELECT * FROM A)
# ORDER BY FILE_ID DESC
