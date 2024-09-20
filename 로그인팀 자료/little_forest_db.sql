--회원 테이블
CREATE TABLE Members (
    MemberID INT PRIMARY KEY,  --회원번호
    MemberName VARCHAR(100), -- 회원이름
    Age INT,                -- 나이
    PhoneNumber VARCHAR(15), -- 전화번호
    UserName VARCHAR(50) UNIQUE, -- 아이디
    Password VARCHAR(50)        -- 비밀번호
    -- 권한 등급 추가
);
ALTER TABLE Members
ADD COLUMN is_active BOOLEAN;
--상품 테이블
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,  --상품번호
    ProductName VARCHAR(100) UNIQUE, --상품명
    Price DECIMAL(10,2)             --상품가격
    -- 장르 추가
);

--주문 테이블
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY, -- 주문번호
    OrderQuantity INT,      -- 주문 수량
    OrderDate DATE,     -- 주문 일자
    MemberID INT,   -- 회원번호
    ProductID INT,  -- 상품 번호
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

--장바구니 테이블
CREATE TABLE Cart (
    CartID INT PRIMARY KEY, --장바구니번호
    Quantity INT,           -- 수량
    CartDate DATE,          -- 장바구니 일자
    MemberID INT,           -- 회원번호
    ProductID INT,          -- 상품번호
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

