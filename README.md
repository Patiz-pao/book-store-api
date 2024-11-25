# Book Store API

⚠️ **คำเตือน / Warning**  
Free Hosting Auto-Sleep  
- เนื่องจาก API ถูก deploy ด้วยบริการโฮสติ้งฟรี อาจมีการเข้าสู่โหมดพัก (auto-sleep) หลังจากไม่มีการใช้งานเป็นเวลานาน เมื่อมีการเรียกใช้ API ครั้งแรกหลังจากโหมดพัก อาจต้องรอประมาณ 5-10 นาที เพื่อให้ API กลับมาทำงานอีกครั้ง  
- The API is deployed using a free hosting service, which may enter an auto-sleep mode after being idle for a while. The first API call after the sleep mode may require a wait time of 5-10 minutes for the API to resume operation.

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)  
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)  
![cURL](https://img.shields.io/badge/cURL-4A90E2?style=for-the-badge&logo=curl&logoColor=white)

Book Store API เป็นโปรเจค **Java Spring Boot** สำหรับให้บริการ API ที่เชื่อมต่อกับ [Book Store Frontend Repository](https://github.com/Patiz-pao/book-store-frontend)  
โดยเป็นโปรเจค backend ที่สนับสนุนการทำงานของเว็บไซต์ [Book Store Shop](https://books-store-shop.netlify.app) ทั้งหมด  
เช่น การจัดการสินค้า, การทำคำสั่งซื้อ, และการจัดการผู้ใช้งาน  

Book Store API is a **Java Spring Boot** project that provides an API connecting with the [Book Store Frontend Repository](https://github.com/Patiz-pao/book-store-frontend).  
This backend project supports the entire functionality of the [Book Store Shop](https://books-store-shop.netlify.app) website,  
including product management, order management, and user management.

## 🛠 คุณสมบัติ (Features) / Features
- **การจัดการสินค้า (Products Management):** เพิ่ม, แก้ไข, ลบ และเรียกดูสินค้าทั้งหมด  
- **การจัดการผู้ใช้งาน (User Management):** ระบบการสมัครสมาชิก, ล็อกอิน และจัดการโปรไฟล์  

- **Products Management:** Add, edit, delete, and view all products  
- **User Management:** User registration, login, and profile management  

## 🌐 เว็บไซต์ที่เกี่ยวข้อง / Related Websites
- เว็บไซต์โปรเจค: [Book Store Shop](https://books-store-shop.netlify.app)  
- Repository Frontend: [Book Store Frontend](https://github.com/Patiz-pao/book-store-frontend)

- Project Website: [Book Store Shop](https://books-store-shop.netlify.app)  
- Frontend Repository: [Book Store Frontend](https://github.com/Patiz-pao/book-store-frontend)

## 🚀 การเริ่มต้นใช้งาน (Getting Started)
API จะพร้อมใช้งานหลังจากเริ่มเซิร์ฟเวอร์ที่:  
`[http://localhost:8080] หรือ (https://book-store-api-4mpr.onrender.com)`  

API will be available after the server starts at:  
`[http://localhost:8080] or (https://book-store-api-4mpr.onrender.com)`

คุณสามารถใช้เครื่องมือเช่น Postman หรือ cURL ในการทดสอบ API  
You can use tools like Postman or cURL to test the API

## 🙏 ขอบคุณ (Thank You)
ขอบคุณที่ใช้โปรเจค Book Store API!  
Thank you for using Book Store API!
