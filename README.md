# SnapSafe

**SnapSafe** is a simple Java application for secure image encryption and decryption using XOR-based cryptography. It allows users to protect their images with a numeric key, ensuring privacy and secure sharing.

---

## Features

- Encrypt and decrypt images using a user-provided numeric key.
- Supports common image formats like `.jpg`, `.png`, and `.bmp`.
- User-friendly GUI with file chooser and key input.
- Overwrites original image with encrypted/decrypted data.
- Simple, lightweight, no external dependencies.

---

## How to Use

1. Run the application.
2. Enter a numeric key for encryption or decryption.
3. Click **Encrypt Image** or **Decrypt Image**.
4. Select the image file from the dialog.
5. The program will process the image and display a success message.

> **Important:** The image file will be overwritten. Keep a backup if you want to preserve the original.

---

## Technologies

- Java SE
- Swing for GUI
- File I/O and basic cryptographic operations (XOR)

---

## Getting Started

### Compile and Run

```bash
javac src/*.java
java -cp src Main
