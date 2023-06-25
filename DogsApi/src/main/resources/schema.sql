IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'dog_breed')
    BEGIN
        CREATE TABLE dog_breed (
          id INT IDENTITY PRIMARY KEY,
          breedName VARCHAR(255) NOT NULL,
          breedType VARCHAR(255) NOT NULL,
          breedDescription VARCHAR(MAX) NOT NULL,
          furColor VARCHAR(255) NOT NULL,
          origin VARCHAR(255) NOT NULL,
          minHeightInches INT NOT NULL,
          maxHeightInches INT NOT NULL,
          minWeightPounds INT NOT NULL,
          maxWeightPounds INT NOT NULL,
          minLifeSpan INT NOT NULL,
          maxLifeSpan INT NOT NULL,
          imgThumb VARCHAR(MAX) NOT NULL,
          imgSourceURL VARCHAR(MAX),
          imgAttribution VARCHAR(MAX),
          imgCreativeCommons BIT NOT NULL
        );
    END;


IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'account')
    BEGIN
        CREATE TABLE account (
             id INT IDENTITY PRIMARY KEY,
             username VARCHAR(100) NOT NULL UNIQUE,
             password VARCHAR(1000) NOT NULL
        );
    END;

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'authority')
    BEGIN
        CREATE TABLE authority (
           id INT IDENTITY PRIMARY KEY,
           authority_name VARCHAR(100) NOT NULL UNIQUE
        );
    END;

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'user_authority')
    BEGIN
        CREATE TABLE user_authority (
            user_id INT NOT NULL,
            authority_id INT NOT NULL,
            CONSTRAINT fk_account FOREIGN KEY (user_id) REFERENCES account(id),
            CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES authority(id)
        );
    END;
