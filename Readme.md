วิธีการนำ database เข้าไปใน mysql ของ docker

คัดลอกไฟ [olympic-init.sql](olympic-init.sql) เข้าไปไว้ใน doker container

`docker cp ./olympic-init.sql <ชื่อ container>:/olympic-init.sql
`
ตัวอย่าง

`docker cp ./olympic-init.sql mysql-olympic:/olympic-init.sql`

หลังจากนั้น เข้าไปใน terminal ของ docker 

`docker exec -it <ชื่อ container> bash`

ตัวอย่าง

`docker exec -it mysql-olympic bash`

พอเข้าไปใน terminal ของ docker แล้ว จะมีเห็นสัญญาลัษณ์ `#`

ให้พิมพ์ mysql เพื่อสร้าง database

`mysql -u root -p`

โดยสร้าง database ชื่อ olympic

`CREATE DATABASE IF NOT EXISTS olympic;`

ออกจาก mysql ด้วยคำสั่ง exit แต่ยังอยู่ใน terminal ของ docker

หลังจากนั้น ย้าย database [olympic-init.sql](olympic-init.sql) ให้ไปอยู่ ใน mysql ด้วยคำสั่ง

`mysql -u root -p olympic < olympic-init.sql
`

โดยทั้งหมดนี้ ให้อยู่ใน directory เดี่ยวกับกับไฟล์  [olympic-init.sql](olympic-init.sql)

เป็นอันเรียบร้อย
