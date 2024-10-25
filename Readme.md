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


วิธีการเพิ่ม user เข้าไปใน database โดย ใช้ Parambody
และต้อง createAt ต้องเป็น format ที่ถูกต้อง
ตัวอย่าง

`
{
"username": "user2",
"passwordHash": "hashed_password_here",
"email": "user2@example.com",
"role": "REGISTERED",
"createdAt" : "2024-10-25T10:15:30"
}
`


ดูผู้ใช้ทั้งหมด
GET
http://localhost:8080/api/users

เพิ่มผู้ใช้ 
POST
http://localhost:8080/api/users/newUser


`
{
"username": "user2",
"passwordHash": "hashed_password_here",
"email": "user2@example.com",
"role": "REGISTERED",
"createdAt" : "2024-10-25T10:15:30"
}
`

ลบผู้ใช้
DELETE
http://localhost:8080/api/users/2
http://localhost:8080/api/users/{id}

อับเดท บทบาทผุ้ใช้ 
PUT
http://localhost:8080/api/users/5
http://localhost:8080/api/users/{id}

`
{
"role": "REGISTERED",
}
`

หรือ

`
{
"role": "ADMIN",
}
`