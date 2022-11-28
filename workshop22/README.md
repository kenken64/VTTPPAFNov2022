## Workshop 22

```
drop database if exists rsvpdb;

create database rsvpdb;

use rsvpdb;
```

```
CREATE USER 'rsvp'@'localhost' IDENTIFIED BY 'Password@123456';

GRANT ALL PRIVILEGES ON *.* TO 'rsvp'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;
```

## Json data sample

```
{
	"name": "Kenneth",
	"email": "k@k.com",
	"phone": "3345677",
	"confirmation_date": "2018-12-10T13:49:51.141Z"
	"comments": "hi hi"
}
```
