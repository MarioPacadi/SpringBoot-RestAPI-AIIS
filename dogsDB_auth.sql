INSERT INTO account (email, username, password, role_id)
VALUES ('admin@admin.com', 'admin', '$2a$10$Gjk7748.woF3SuMphhlGeulsrPNt3l.lZLLuZ4Z05EIMuy6A5aX6e', 1);
--password: admin123

INSERT INTO account (email, username, password, role_id)
VALUES ('user@user.com', 'user', '$2a$10$so/N/jYj4VHruPT0QmHtOuqk10KlU9FMkxnpDLeNyE6ZjQt8ZedJe', 2);
--password: user123

delete from account
where username='test'
