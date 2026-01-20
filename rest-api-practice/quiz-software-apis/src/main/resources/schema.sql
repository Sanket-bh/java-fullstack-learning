CREATE TABLE IF NOT EXISTS quiz_question (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(255),
    option_a VARCHAR(100),
    option_b VARCHAR(100),
    option_c VARCHAR(100),
    option_d VARCHAR(100),
    correct_option CHAR(1)
);
