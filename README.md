her er det mySQL jeg har til den :

use social_medium;
CREATE USER IF NOT EXISTS 'emmapasquer'@'localhost' IDENTIFIED BY 'emmapasquer';
GRANT USAGE ON *.* TO `emmapasquer`@`localhost`;
GRANT SELECT, INSERT, UPDATE, DELETE ON movies.* TO 'emmapasquer'@'localhost';


// --> tried an debug med chat gpt
SELECT user, host FROM mysql.user WHERE user = 'emmapasquer';

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON *.* TO 'emmapasquer'@'localhost';
