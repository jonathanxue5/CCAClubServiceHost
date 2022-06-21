CREATE TABLE IF NOT EXISTS club (
    club_id UUID NOT NULL PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    encoded_password VARCHAR(200) NOT NULL,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(500) NOT NULL,
    profile_picture_url VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS socials (
    social_id UUID NOT NULL PRIMARY KEY,
    club_id UUID NOT NULL,
    social_name VARCHAR(200) NOT NULL,
    social_link VARCHAR(200) NOT NULL,
    FOREIGN KEY (social_id) REFERENCES club(club_id)
);

CREATE TABLE IF NOT EXISTS club_categories (
    id UUID NOT NULL PRIMARY KEY,
    club_id UUID NOT NULL,
    category VARCHAR(200) NOT NULL,
    FOREIGN KEY (club_id) REFERENCES club(club_id)
);

CREATE TABLE IF NOT EXISTS post (
    post_id UUID NOT NULL PRIMARY KEY,
    sender UUID NOT NULL,
    title VARCHAR(200) NOT NULL,
    FOREIGN KEY (sender) REFERENCES club(club_id)
);

CREATE TABLE IF NOT EXISTS post_tab (
    tab_id UUID NOT NULL PRIMARY KEY,
    post_id UUID NOT NULL,
    header VARCHAR(200) NOT NULL,
    text_content VARCHAR(500),
    media_url VARCHAR(200),
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);

CREATE TABLE IF NOT EXISTS featured_clubs (
    club_id UUID NOT NULL PRIMARY KEY,
    text_content VARCHAR(500),
    media_url VARCHAR(200),
    FOREIGN KEY (club_id) REFERENCES club(club_id)
);