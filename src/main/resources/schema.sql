-- Create the Candy table
CREATE TABLE IF NOT EXISTS candy (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price DECIMAL(10, 2)
    );

-- Create the Delivery table
CREATE TABLE IF NOT EXISTS delivery (
    delivery_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    recipient_name VARCHAR(255),
    address_full VARCHAR(500),
    delivery_time DATETIME,
    completed BOOLEAN
);

-- Create the Plant table (assuming you have a Plant entity)
CREATE TABLE IF NOT EXISTS plant (
    plant_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    delivery_id BIGINT,
    FOREIGN KEY (delivery_id) REFERENCES delivery(delivery_id) ON DELETE CASCADE
);

-- Create the candy_delivery table
create table if not exists candy_delivery (
    candy_id BIGINT NOT NULL,
    delivery_id BIGINT NOT NULL,
    foreign key (candy_id) references candy(id),
    foreign key (delivery_id) references delivery(delivery_id) on delete cascade
);