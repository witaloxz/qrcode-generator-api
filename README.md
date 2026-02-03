# QR Code Generator API
REST API built with Spring Boot to generate QR Codes and upload them to AWS S3, following Clean Architecture principles.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)
![Google ZXing](https://img.shields.io/badge/Google%20ZXing-3.5.2-blue)
![Docker](https://img.shields.io/badge/Docker-✓-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)
---

# 🚀 Getting Started

This section describes how to set up and run the QR Code Generator application locally or using Docker.

## 🧩 Prerequisites

Ensure you have the following installed and configured:
- Java 21 (JDK)
- Maven
- Docker
- AWS Account with access to S3
- AWS CLI configured with valid credentials

## 🔐 Environment Configuration

Create a .env file in the project root directory with the required AWS credentials:

```env
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=your_region
AWS_BUCKET_NAME=your_bucket_name
```

## ▶️ Running the Application

### Local Development

1. Configure environment variables (`.env`)

2. Build the project:

```
mvn clean package
```

3. Start the application:
   
```
mvn spring-boot:run
```

The application will be available at:
http://localhost:8080

## 🐳 Docker

1. Build the Docker image:
   
```
docker build -t qrcode-generator:latest .
```

2. Run the container:

```
docker run --env-file .env -p 8080:8080 qrcode-generator:latest
```

## ☁️ AWS S3 Setup

### To enable QR code storage:

1. Create an S3 bucket in your AWS account

2. Update `AWS_BUCKET_NAME in your` `.env` file

3. Ensure the AWS user has permission to:
- `s3:PutObject`
- `s3:GetObject`

## 🔌 API Reference

### POST /qrcode
Generate a QR code from the provided text and store it in AWS S3. The QR code will be generated as a PNG image with dimensions of 200x200 pixels.

**Parameters**

| Name | Required | Type | Description |
|------|----------|------|-------------|
| `text` | required | string | The text content to be encoded in the QR code. This can be any string value that you want to convert into a QR code. |

**Response**

```json
{
    "url": "https://your-bucket.s3.your-region.amazonaws.com/random-uuid"
}
```

**Error Response**

If an error occurs during QR code generation or S3 upload, the API will return a 500 Internal Server Error.

**Example Usage**

```bash
curl -X POST http://localhost:8080/qrcode \
     -H "Content-Type: application/json" \
     -d '{"text": "https://example.com"}'
```

## License

This project is licensed under the MIT License - see the LICENSE file for details. 



