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

**สำคัญ**

โดยมีบทบาท role

`REGISTERED กับ ADMIN`

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




*Comment*

รับค่า comments ทั้งหมดของ แต่ละประเทศ โดย คนหาโดย code country 3 ตัว

GET

`http://localhost:8080/api/comments?country=<country code>`

Ex

`http://localhost:8080/api/comments?country=USA`



**query เฉพาะ comment อันเดียว โดยระบุ comment_id**

GET

`http://localhost:8080/api/comments/get?id=<comment_id>`

EX

`http://localhost:8080/api/comments/get?id=1`



**การ post comments**

การ post comment โดยใช้ Parambody

POST

http://localhost:8080/api/comments/newComment

โดยต่้องใส่ Parambody เข้าไปด้วย json เช่น

`
{
"userId": 888888,
"username" : "test",
"countryId": "USA",
"commentText": "The WHERE clause is optional, but you'll usually want it, unless you really want to delete every row from the table.",
"createdAt": "2024-10-25T10:15:30",
"updatedAt": "2024-10-25T10:15:30",
"profileUri": "vvvvvvvv"
}
`

**การแก้ไข comment**

ต้อง put พร้อมกับ Parambody



PUT 

`http://localhost:8080/api/comments/<idComment>`

EX

`http://localhost:8080/api/comments/2`

`
{
"commentText": "ทดสอบ",
"updatedAt": "2024-10-25T10:15:30"
}
`


#ข้อควรระวัง fontend ควรตรวจสอบด้วยว่า userId เดียวกันไหม ถึง จะให้ดำนเนิการแก้ไข

** Delete Comment **

ลบโดยใช้ comment id แต่ ต้องให้ fontend ตรวจสอบด้วยว่า ผู้ใช้คนเดียวกันไหม ถึงจะลบได้

DELETE

ใส่ค่า @PathVariable

`http://localhost:8080/api/comments/<comment id>`

EX

`http://localhost:8080/api/comments/3`



**LOGIN**

ใช้ร่วมกับ Parambody 

`
{
"username": "admin",
"password": "admin"
}
`

POST 

http://localhost:8080/api/login

คือ 3 สถานะ 
200 ok
401 ระหัสผิด
404 ไม่เจอ user

หลังจาก login เสร็จแล้ว

ผู้ใช้ จะได้ token ให้เก็บไว้ใน cooike แล้วขอเข้าใช้ใหม่ โดยใส่ไว้ใน header

Authorization: Bearer <token>


**Country Detail**

GET ประเทศโดย code

`
http://localhost:8080/api/country?countryCode=<Code ประเทศ>
`

ตัวอยา่ง

`
http://localhost:8080/api/country?countryCode=USA
`