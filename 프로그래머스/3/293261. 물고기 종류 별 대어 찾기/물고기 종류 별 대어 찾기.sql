WITH a AS (
    SELECT fish_type, MAX(length) AS m
    FROM fish_info
    GROUP BY fish_type
)
SELECT fi.id, fni.fish_name,fi.length
FROM fish_info fi
INNER JOIN a ON fi.fish_type = a.fish_type AND fi.length = a.m
INNER JOIN fish_name_info fni ON fni.fish_type = fi.fish_type
ORDER BY fi.id ASC;
