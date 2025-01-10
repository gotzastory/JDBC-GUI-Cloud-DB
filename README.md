![ui_screenshot](https://github.com/user-attachments/assets/7c51ed28-4f24-4c38-a154-f690735d270f)


# Java Database GUI (Cloud Database)

โปรเจกต์นี้เป็นระบบจัดการฐานข้อมูลหนังสือ โดยใช้ **Java** และเชื่อมต่อกับฐานข้อมูล **PostgreSQL** บน **Supabase** พร้อมรองรับการแปลงไฟล์เป็น `.exe` สำหรับการใช้งานง่ายผ่าน GUI

---

## Features

- **เพิ่มข้อมูล**: เพิ่มรายการข้อมูลใหม่เข้าสู่ฐานข้อมูล.
- **แก้ไขข้อมูล**: แก้ไขรายการข้อมูลที่มีอยู่.
- **ลบข้อมูล**: ลบรายการข้อมูลจากฐานข้อมูล.
- **แสดงข้อมูล**: ดูรายการข้อมูลทั้งหมดในฐานข้อมูล.
- **เชื่อมต่อกับ Cloud Database**: ใช้ Supabase เป็นฐานข้อมูล PostgreSQL.
- **UI Friendly**: ส่วนติดต่อผู้ใช้งานที่ง่ายต่อการใช้งาน.

---

## Technologies Used

- **Java**: ภาษาโปรแกรมหลัก.
- **PostgreSQL**: ฐานข้อมูลที่ใช้.
- **Supabase**: โฮสต์ฐานข้อมูลบนคลาวด์.
- **Launch4j**: แปลงไฟล์ `.jar` เป็น `.exe`.

---

## Requirements

1. **JDK**: JavaSE-23 หรือเวอร์ชันที่รองรับ.
2. **PostgreSQL Driver**: `postgresql-42.7.4.jar` (รวมในโฟลเดอร์ `lib`).
3. **Git**: สำหรับการควบคุมเวอร์ชัน (ถ้าต้องการ).

---

## Installation

### ขั้นตอนการตั้งค่า:

1. **Clone โปรเจกต์จาก GitHub**:
   ```bash
   git clone https://github.com/<your-username>/JavaDatabase5.git
   cd JavaDatabase5
   ```

2. **ตั้งค่าฐานข้อมูลใน Supabase**:
   - สร้างตารางชื่อ `books` ด้วยโครงสร้างดังนี้:
     ```sql
     CREATE TABLE books (
         book_id SERIAL PRIMARY KEY,
         book_name VARCHAR(255)
     );
     ```

3. **ตั้งค่า Config.java**:
   - อัปเดต `USERNAME`, `PASSWORD`, และ `URL` ให้ตรงกับฐานข้อมูลของคุณ:
     ```java
     private static final String URL = "jdbc:postgresql://db.your-supabase-url.supabase.co:5432/postgres";
     private static final String USERNAME = "your-username";
     private static final String PASSWORD = "your-password";
     ```

4. **Build JAR File**:
   - ใช้คำสั่ง:
     ```bash
     jar cvfm JavaDatabase.jar META-INF/MANIFEST.MF -C bin . -C lib postgresql-42.7.4.jar
     ```

5. **แปลงเป็น EXE (Optional)**:
   - ใช้ **Launch4j** เพื่อแปลงไฟล์ `.jar` เป็น `.exe`.

---

## Usage

1. **รันโปรแกรม**:
   - ใช้ไฟล์ `.jar`:
     ```bash
     java --enable-preview -jar JavaDatabase.jar
     ```
   - หรือรันไฟล์ `.exe` (ถ้าแปลงแล้ว).

2. **เชื่อมต่อฐานข้อมูล**:
   - ตรวจสอบให้แน่ใจว่า Supabase เปิดใช้งานและฐานข้อมูลถูกต้อง.

---

## Troubleshooting

1. **Error: Unable to connect to database**
   - ตรวจสอบว่า `Config.java` ตั้งค่าถูกต้อง.
   - ตรวจสอบว่า Supabase เปิดให้เชื่อมต่อจาก IP Address ของคุณ.

2. **Error: Could not find main class**
   - ตรวจสอบว่า `MANIFEST.MF` ระบุ `Main-Class` ถูกต้อง:
     ```text
     Main-Class: com.mystou.javadb.v.BooksView
     ```

---

## Contributing

1. Fork โปรเจกต์นี้บน GitHub.
2. สร้าง Branch ใหม่:
   ```bash
   git checkout -b feature/your-feature
   ```
3. Commit การเปลี่ยนแปลงของคุณ:
   ```bash
   git commit -m "Add your feature"
   ```
4. Push ไปยัง Branch ของคุณ:
   ```bash
   git push origin feature/your-feature
   ```
5. เปิด Pull Request.

---

## License

โปรเจกต์นี้อยู่ภายใต้ลิขสิทธิ์ [MIT License](./LICENSE).

---

## Author

**Gotzastory**  
[GitHub](https://github.com/gotzastory) | [Email](mailto:scottxrifer@gmail.com)

---

ขอบคุณที่ใช้โปรเจกต์นี้! 😊
