-- สร้าง table Users
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('ADMIN', 'REGISTERED') NOT NULL DEFAULT 'REGISTERED',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- เพิ่มข้อมูลแถวใหม่ โดยกำหนดให้เป็น admin
INSERT INTO Users (username, password_hash, email, role)
VALUES ('admin_user', SHA2('secure_password', 256), 'admin@email.com', 'ADMIN');