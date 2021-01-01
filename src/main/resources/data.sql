INSERT INTO users (username, password, enabled)
values ( 'guest', '$2a$10$y0Qzl0fu6GSQ8aWdDNRfPuT1v2m5IZa9dSf.TG3GW2JyFTGmq6rJW', true );

INSERT INTO users (username, password, enabled)
values ( 'user', '$2a$10$fqxdRHoY6Ttebe8FgcmoeOkUBynhpq.Kz5EfcMfSDewdxBonJiAEO', true );

INSERT INTO users (username, password, enabled)
values ( 'admin', '$2a$10$UtLvlT4oChUGYbF1ptFqvOZXskH8t2S/xaZsC2QSISrPIofVY0pZW', true );
-- values ( 'admin', '$2a$10$KC5LiNjZLA17RI78zdLt1uTGrUoKSsCWOu4zb./q2w8kM9ZokCvn6', true );

INSERT INTO authorities (username, authority) values ( 'guest', 'ROLE_GUEST' );
INSERT INTO authorities (username, authority) values ( 'user', 'ROLE_USER' );
INSERT INTO authorities (username, authority) values ( 'admin', 'ROLE_ADMIN' );