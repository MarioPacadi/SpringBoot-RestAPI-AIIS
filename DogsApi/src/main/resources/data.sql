DELETE FROM dog_breed;
DELETE FROM user_authority;
DELETE FROM account;
DELETE FROM authority;

INSERT INTO dog_breed (breedName, breedType, breedDescription, furColor, origin, minHeightInches, maxHeightInches, minWeightPounds, maxWeightPounds, minLifeSpan, maxLifeSpan, imgThumb, imgSourceURL, imgAttribution, imgCreativeCommons)
VALUES ('Afador', 'Mixed Breed Dogs', 'The Afador is a hybrid dog composed of an Afghan Hound and a Labrador Retriever that originated in Alaska around the year 2000.', 'black, brown, gray, red, fawn', 'Alaska', 20, 29, 50, 75, 10, 12, 'https://s3.us-west-004.backblazeb2.com/encurate/static/dogbreed/dog-default.jpg', null, null, 0);

INSERT INTO dog_breed (breedName, breedType, breedDescription, furColor, origin, minHeightInches, maxHeightInches, minWeightPounds, maxWeightPounds, minLifeSpan, maxLifeSpan, imgThumb, imgSourceURL, imgAttribution, imgCreativeCommons)
VALUES ('Labrador Retriever', 'Retrievers', 'The Labrador Retriever is a medium to large-sized breed of retriever dog that originated in Canada.', 'black, yellow, chocolate', 'Canada', 21, 24, 55, 80, 10, 12, 'https://s3.us-west-004.backblazeb2.com/encurate/static/dogbreed/dog-default.jpg', null, null, 0);

INSERT INTO dog_breed (breedName, breedType, breedDescription, furColor, origin, minHeightInches, maxHeightInches, minWeightPounds, maxWeightPounds, minLifeSpan, maxLifeSpan, imgThumb, imgSourceURL, imgAttribution, imgCreativeCommons)
VALUES ('German Shepherd', 'Herding Dogs', 'The German Shepherd is a breed of working dog known for its intelligence and versatility. It originated in Germany and is often used as a police, service, and search and rescue dog.', 'black, tan, sable, black and tan, black and red', 'Germany', 22, 26, 55, 90, 9, 13, 'https://s3.us-west-004.backblazeb2.com/encurate/static/dogbreed/dog-default.jpg', null, null, 0);

INSERT INTO dog_breed (breedName, breedType, breedDescription, furColor, origin, minHeightInches, maxHeightInches, minWeightPounds, maxWeightPounds, minLifeSpan, maxLifeSpan, imgThumb, imgSourceURL, imgAttribution, imgCreativeCommons)
VALUES ('Golden Retriever', 'Retrievers', 'The Golden Retriever is a large-sized breed of retriever dog known for its friendly and intelligent nature. It originated in Scotland and is often used as a hunting and service dog.', 'golden, cream', 'Scotland', 21, 24, 55, 75, 10, 12, 'https://s3.us-west-004.backblazeb2.com/encurate/static/dogbreed/dog-default.jpg', null, null, 0);

INSERT INTO account (username, password)
VALUES ('account', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = account
       ('admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin

INSERT INTO authority (authority_name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO user_authority (user_id, authority_id)
VALUES (2, 1),
       (1, 2);
