CREATE DATABASE webNote;
GO
USE webNote;
GO
CREATE TABLE Users (
    id INT PRIMARY KEY IDENTITY(1,1),
    username VARCHAR(50) UNIQUE NOT NULL,
    passwordHash VARCHAR(255) NOT NULL,
    fullname VARCHAR(100),
    email VARCHAR(100),
    role VARCHAR(20) DEFAULT 'user'
);
GO
CREATE TABLE Notes (
    id INT PRIMARY KEY IDENTITY(1,1),
    userId INT,
    title VARCHAR(100),
    content TEXT,
    isPublic BIT DEFAULT 0,
    createdAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (userId) REFERENCES Users(id)
);
GO
CREATE TABLE TodoLists (
    id INT PRIMARY KEY IDENTITY(1,1),
    userId INT,
    title VARCHAR(100),
    tasks TEXT,
    isPublic BIT DEFAULT 0,
    createdAt DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (userId) REFERENCES Users(id)
);
GO

INSERT INTO Users (username, passwordHash, fullname, email, role)
VALUES ('meoleodeo', HASHBYTES('SHA2_256', '1234567'), 'Admin', 'admin@webnote.com', 'admin');
