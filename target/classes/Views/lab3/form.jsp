
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab3 - bài 1</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }
    
    form {
        width: 50%;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
    
    h2 {
        color: #333;
    }
    
    input[type="file"] {
        margin-bottom: 10px;
    }
    
    button {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    
    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <h2>Xây dựng trang web cho phép upload 1 file hình và 1 file tài liệu bất kỳ. Sau khi upload xong thì hiển thị hình đã upload và download trở lại file tài liệu.</h2>
    <form action="" method="post" enctype="multipart/form-data">
        <label for="photo_file">Hình ảnh:</label><br>
        <input type="file" id="photo_file" name="photo_file"><br>
        <label for="doc_file">Tài liệu:</label><br>
        <input type="file" id="doc_file" name="doc_file"><br>
        <hr>
        <button>Upload</button>
    </form>
</body>
</html>
