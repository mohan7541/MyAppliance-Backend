DROP TABLE IF EXISTS appliances;

CREATE TABLE appliances (
  serial_number INT AUTO_INCREMENT  PRIMARY KEY,
  brand VARCHAR(250) NOT NULL,
  model VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL,
  date_bought DATE DEFAULT CURRENT_TIMESTAMP()
);

INSERT INTO appliances (brand, model, status) VALUES
    ('Apple', 'ipad', 'NEW'),
    ('Apple', 'iphone12', 'NEW'),
    ('Whirlpool', 'Washer', 'OLD'),
    ('Hitachi', 'Fridge', 'SOLD'),
    ('Hitachi', 'Fan', 'SOLD'),
    ('LG', 'Fridge', 'UNUSED'),
    ('LG', 'Washer', 'UNUSED'),
    ('Apple', 'ipod6', 'OLD'),
    ('Butterfly', 'Stove', 'NEW');