![ui_screenshot](https://github.com/user-attachments/assets/7c51ed28-4f24-4c38-a154-f690735d270f)


# JavaDatabase GUI (Cloud Database)

JavaDatabase GUI เป็นโปรเจกต์ที่พัฒนาโดยใช้ Java สำหรับการจัดการฐานข้อมูล โดยเชื่อมต่อกับฐานข้อมูล PostgreSQL ที่โฮสต์อยู่บน **Supabase** และมีส่วนติดต่อผู้ใช้งาน (GUI) ที่เป็นมิตรและใช้งานง่าย. 

---

## Introduction 🧑‍🎓

สวัสดีครับทุกคน,  
ผมชื่อ **Gotzastory** เป็นนักศึกษาระดับชั้น **ปวส.1** ในสาขาเทคโนโลยีสารสนเทศ หรือ ไอที โปรเจกต์นี้เป็นส่วนหนึ่งของวิชา **Object-Oriented Programming (OOP)** ซึ่งเป็นหนึ่งในหัวใจสำคัญของการเขียนโปรแกรมในเชิงโครงสร้าง โดยผมได้เรียนรู้และประยุกต์ใช้แนวคิด OOP เพื่อพัฒนาโปรแกรมที่มีโครงสร้างชัดเจน ง่ายต่อการขยาย และสามารถนำไปใช้งานในสถานการณ์จริงได้

ในโปรเจกต์นี้ ผมได้พัฒนาแอปพลิเคชันที่สามารถจัดการข้อมูลในฐานข้อมูลด้วยการเชื่อมต่อกับ **PostgreSQL** ผ่านคลาวด์แพลตฟอร์มชื่อดังอย่าง **Supabase** แอปพลิเคชันนี้ออกแบบมาเพื่อแสดงผลข้อมูล เพิ่ม แก้ไข และลบข้อมูลในฐานข้อมูล พร้อมทั้งสร้าง GUI (Graphical User Interface) เพื่อให้ใช้งานง่ายและเป็นมิตรกับผู้ใช้มากที่สุด

### เป้าหมายของโปรเจกต์นี้

1. เพื่อฝึกฝนการเขียนโปรแกรมด้วยแนวคิด **Object-Oriented Programming (OOP)** และสร้างโปรแกรมที่มีโครงสร้างดี.
2. เพื่อเรียนรู้การทำงานกับฐานข้อมูล **PostgreSQL** และการเชื่อมต่อฐานข้อมูลบนคลาวด์ผ่าน **Supabase**.
3. เพื่อพัฒนาโปรแกรมให้สามารถแปลงเป็น **.exe** ได้ด้วยเครื่องมือ **Launch4j** ทำให้ใช้งานได้สะดวกและเป็นมิตรกับผู้ใช้ที่ไม่ต้องติดตั้ง JDK.
4. เพื่อเตรียมความพร้อมสำหรับการพัฒนาระบบในสถานการณ์จริงและอาชีพในอนาคต.

ขอบคุณที่สนใจโปรเจกต์นี้ หวังว่าจะเป็นประโยชน์สำหรับผู้ที่ศึกษาในด้านเดียวกันครับ 😊

---

## Features

- **เพิ่มข้อมูล**: เพิ่มรายการข้อมูลใหม่เข้าสู่ฐานข้อมูลผ่าน GUI.
- **แก้ไขข้อมูล**: แก้ไขรายการข้อมูลที่มีอยู่.
- **ลบข้อมูล**: ลบรายการข้อมูลจากฐานข้อมูล.
- **แสดงข้อมูล**: ดูรายการข้อมูลทั้งหมดในฐานข้อมูลผ่าน GUI.
- **เชื่อมต่อกับ Cloud Database**: ใช้ Supabase เป็นฐานข้อมูล PostgreSQL.
- **แปลงเป็นไฟล์ EXE**: รองรับการใช้งานแบบ Standalone.

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
   git clone https://github.com/<your-username>/JDBC-GUI-Cloud-DB.git
   cd JavaDatabaseGUI
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
     jar cvfm JavaDatabaseGUI.jar META-INF/MANIFEST.MF -C bin . -C lib postgresql-42.7.4.jar
     ```

5. **แปลงเป็น EXE (Optional)**:
   - ใช้ **Launch4j** เพื่อแปลงไฟล์ `.jar` เป็น `.exe`.

---

## Usage

1. **รันโปรแกรม**:
   - ใช้ไฟล์ `.jar`:
     ```bash
     java --enable-preview -jar JavaDatabaseGUI.jar
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
